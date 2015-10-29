/*
 * JSLEE Annotations
 * Copyright (c) 2015 Piotr Grabowski, All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */

package jsleeannotations;

import jsleeannotations.slee.Sbb;
import jsleeannotations.xml.service.*;
import jsleeannotations.xml.service.Service;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

@SupportedAnnotationTypes(value = {"jsleeannotations.slee.Service"})
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class ServiceProcessor extends AbstractProcessor {
    private AnnotationFinder annotationFinder;
    ObjectFactory objectFactory = new ObjectFactory();

    JAXBContext context;
    Marshaller marshaller;

    public ServiceProcessor() throws JAXBException {
        context = JAXBContext.newInstance(ServiceXml.class);
        marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        marshaller.setProperty("jaxb.encoding", "UTF-8");
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        ServiceXml serviceXml = objectFactory.createServiceXml();
        annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
        boolean isServiceCreated = false;
        for (TypeElement typeElement : annotations) {
            Set<? extends Element> elementSet = roundEnv.getElementsAnnotatedWith(typeElement);
            for (Element element : elementSet) {
                if (element.getKind().isClass() || element.getKind().isInterface()) {
                    jsleeannotations.slee.Service serviceAnnotation = element.getAnnotation(jsleeannotations.slee.Service.class);
                    Service service = objectFactory.createService();
                    ServiceName serviceName = objectFactory.createServiceName();
                    serviceName.setvalue(serviceAnnotation.name());
                    service.setServiceName(serviceName);
                    ServiceVendor serviceVendor = objectFactory.createServiceVendor();
                    serviceVendor.setvalue(serviceAnnotation.vendor());
                    service.setServiceVendor(serviceVendor);
                    ServiceVersion serviceVersion = objectFactory.createServiceVersion();
                    serviceVersion.setvalue(serviceAnnotation.vendor());
                    service.setServiceVersion(serviceVersion);
                    serviceXml.getService().add(service);

                    DefaultPriority defaultPriority = objectFactory.createDefaultPriority();
                    defaultPriority.setvalue(String.valueOf(serviceAnnotation.defaultPriority()));
                    service.setDefaultPriority(defaultPriority);

                    if (!serviceAnnotation.addressProfileTable().isEmpty())  {
                        AddressProfileTable addressProfileTable = objectFactory.createAddressProfileTable();
                        addressProfileTable.setvalue(serviceAnnotation.addressProfileTable());
                        service.setAddressProfileTable(addressProfileTable);
                    }

                    if (!serviceAnnotation.description().isEmpty()) {
                        Description description = objectFactory.createDescription();
                        description.setvalue(serviceAnnotation.description());
                        service.setDescription(description);
                    }
                    addRootSbb(service, element);

                    isServiceCreated = true;
                } else {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, element.getSimpleName() + " contains jsleeannotations.slee.Service annotation but is not class or interface.");
                }
            }
        }
        if (isServiceCreated) {
            try {
                writeToFile(serviceXml);
            } catch (JAXBException e) {
                throw new RuntimeException("Unable to write output file", e);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;

    }

    private void addRootSbb(Service service, Element element) {
        Sbb sbbAnnotation = annotationFinder.findClassOrInterfaceAnnotation(element, Sbb.class);
        if (sbbAnnotation != null) {
            RootSbb rootSbb = objectFactory.createRootSbb();
            SbbName sbbName = objectFactory.createSbbName();
            SbbVendor sbbVendor = objectFactory.createSbbVendor();
            SbbVersion sbbVersion = objectFactory.createSbbVersion();
            sbbName.setvalue(sbbAnnotation.name());
            sbbVendor.setvalue(sbbAnnotation.vendor());
            sbbVersion.setvalue(sbbAnnotation.version());
            rootSbb.setSbbName(sbbName);
            rootSbb.setSbbVendor(sbbVendor);
            rootSbb.setSbbVersion(sbbVersion);
            service.setRootSbb(rootSbb);
        }
    }

    private void writeToFile(ServiceXml serviceXml) throws JAXBException, IOException {
        FileObject fileObject = processingEnv.getFiler().createResource(StandardLocation.SOURCE_OUTPUT, "", "service.xml", null);
        try (Writer writer = fileObject.openWriter()) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<!DOCTYPE service-xml PUBLIC \"-//Sun Microsystems, Inc.//DTD JAIN SLEE Service 1.1//EN\"\n" +
                    "        \"http://java.sun.com/dtd/slee-service-xml_1_1.dtd\">\n");
            marshaller.marshal(serviceXml, writer);
        }
    }
}
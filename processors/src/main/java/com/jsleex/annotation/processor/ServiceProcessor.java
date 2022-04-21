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

package com.jsleex.annotation.processor;

import com.jsleex.annotation.Sbb;
import com.jsleex.annotation.processor.xml.common.*;
import com.jsleex.annotation.processor.xml.service.*;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Set;

@SupportedAnnotationTypes(value = {"com.jsleex.annotation.Service"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ServiceProcessor extends AbstractProcessor {
    private static final String OUTPUT_FILE = "META-INF/service.xml";
    private static final String DOCTYPE = "<!DOCTYPE service-xml PUBLIC \"-//Sun Microsystems, Inc.//DTD JAIN SLEE Service 1.1//EN\" \"http://java.sun.com/dtd/slee-service-xml_1_1.dtd\">\n";
    private final XmlFileWriter<ServiceXml> xmlWriter;
    private final ObjectFactory objectFactory = new ObjectFactory();
    private AnnotationFinder annotationFinder;

    public ServiceProcessor() {
        try {
            this.xmlWriter = new XmlFileWriter<>(ServiceXml.class, OUTPUT_FILE, DOCTYPE);
        } catch (JSleeXProcessorException e) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Unable to initialize processor.");
            throw new RuntimeException(e);
        }
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
                    com.jsleex.annotation.Service serviceAnnotation = element.getAnnotation(com.jsleex.annotation.Service.class);
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
                xmlWriter.write(processingEnv.getFiler(), serviceXml);
            } catch (JAXBException | IOException e) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Unable to write output file: " + e.getLocalizedMessage());
                throw new RuntimeException("Unable to write output file.", e);
            }
        }
        return true;

    }

    private void addRootSbb(Service service, Element element) {
        Sbb sbbAnnotation = annotationFinder.findClassOrInterfaceAnnotation(element, Sbb.class);
        if (sbbAnnotation != null) {
            final RootSbb rootSbb = objectFactory.createRootSbb();
            final SbbName sbbName = objectFactory.createSbbName();
            final SbbVendor sbbVendor = objectFactory.createSbbVendor();
            final SbbVersion sbbVersion = objectFactory.createSbbVersion();
            sbbName.setvalue(sbbAnnotation.name());
            sbbVendor.setvalue(sbbAnnotation.vendor());
            sbbVersion.setvalue(sbbAnnotation.version());
            rootSbb.setSbbName(sbbName);
            rootSbb.setSbbVendor(sbbVendor);
            rootSbb.setSbbVersion(sbbVersion);
            service.setRootSbb(rootSbb);
        }
    }
}
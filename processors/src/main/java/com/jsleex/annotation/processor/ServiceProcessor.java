/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.Sbb;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;

import java.io.IOException;
import java.util.Set;

@SupportedAnnotationTypes(value = {"com.jsleex.annotation.Service"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ServiceProcessor extends JsleeXProcessor {
    private static final String OUTPUT_FILE = "META-INF/service.xml";
    private static final String DOCTYPE_PUBLIC = "-//Sun Microsystems, Inc.//DTD JAIN SLEE Service 1.1//EN";
    private static final String DOCTYPE_SYSTEM = "http://java.sun.com/dtd/slee-service-xml_1_1.dtd";
    private XmlFileWriter xmlWriter;
    private AnnotationFinder annotationFinder;
    private DocumentBuilder builder;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            this.builder = factory.newDocumentBuilder();
            this.xmlWriter = new XmlFileWriter(OUTPUT_FILE, DOCTYPE_PUBLIC, DOCTYPE_SYSTEM);
        } catch (JSleeXProcessorException | ParserConfigurationException e) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Unable to initialize processor.");
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        final Document doc = builder.newDocument();
        final org.w3c.dom.Element serviceXmlElement = doc.createElement("service-xml");
        doc.appendChild(serviceXmlElement);
        annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
        for (TypeElement typeElement : annotations) {
            Set<? extends Element> elementSet = roundEnv.getElementsAnnotatedWith(typeElement);
            for (Element element : elementSet) {
                if (element.getKind().isClass() || element.getKind().isInterface()) {
                    com.jsleex.annotation.Service serviceAnnotation = element.getAnnotation(com.jsleex.annotation.Service.class);
                    org.w3c.dom.Element service = doc.createElement("service");
                    if (!serviceAnnotation.description().isEmpty()) {
                        org.w3c.dom.Element description = doc.createElement("description");
                        description.setTextContent(serviceAnnotation.description());
                        service.appendChild(description);
                    }
                    org.w3c.dom.Element serviceName = doc.createElement("service-name");
                    serviceName.setTextContent(serviceAnnotation.name());
                    service.appendChild(serviceName);

                    org.w3c.dom.Element serviceVendor = doc.createElement("service-vendor");
                    serviceVendor.setTextContent(serviceAnnotation.vendor());
                    service.appendChild(serviceVendor);
                    org.w3c.dom.Element serviceVersion = doc.createElement("service-version");
                    serviceVersion.setTextContent(serviceAnnotation.version());
                    service.appendChild(serviceVersion);

                    addRootSbb(service, element);

                    org.w3c.dom.Element defaultPriority = doc.createElement("default-priority");
                    defaultPriority.setTextContent(Byte.toString(serviceAnnotation.defaultPriority()));
                    service.appendChild(defaultPriority);

                    if (!serviceAnnotation.addressProfileTable().isEmpty())  {
                        org.w3c.dom.Element addressProfileTable = doc.createElement("address-profile-table");
                        addressProfileTable.setTextContent(serviceAnnotation.addressProfileTable());
                        service.appendChild(addressProfileTable);
                    }
                    serviceXmlElement.appendChild(service);
                } else {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, element.getSimpleName() + " contains jsleeannotations.slee.Service annotation but is not class or interface.");
                }
            }
        }
        if (serviceXmlElement.hasChildNodes()) {
            try {
                xmlWriter.write(processingEnv.getFiler(), doc);
            } catch (IOException | TransformerException e) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Unable to write output file: " + e.getLocalizedMessage());
                throw new RuntimeException("Unable to write output file.", e);
            }
        }
        return true;

    }

    private void addRootSbb(org.w3c.dom.Element service, Element element) {
        Sbb sbbAnnotation = annotationFinder.findClassOrInterfaceAnnotation(element, Sbb.class);
        if (sbbAnnotation != null) {
            final org.w3c.dom.Element rootSbb = service.getOwnerDocument().createElement("root-sbb");
            final org.w3c.dom.Element sbbName = service.getOwnerDocument().createElement("sbb-name");
            final org.w3c.dom.Element sbbVendor = service.getOwnerDocument().createElement("sbb-vendor");
            final org.w3c.dom.Element sbbVersion = service.getOwnerDocument().createElement("sbb-version");
            sbbName.setTextContent(sbbAnnotation.name());
            sbbVendor.setTextContent(sbbAnnotation.vendor());
            sbbVersion.setTextContent(sbbAnnotation.version());
            rootSbb.appendChild(sbbName);
            rootSbb.appendChild(sbbVendor);
            rootSbb.appendChild(sbbVersion);
            service.appendChild(rootSbb);
        }
    }
}
/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import org.w3c.dom.Document;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Set;

@SupportedAnnotationTypes(value = {"com.jsleex.annotation.Sbb"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class SbbProcessor extends JsleeXProcessor {
    private static final String OUTPUT_FILE = "META-INF/sbb-jar.xml";
    private static final String DOCTYPE_PUBLIC = "-//Sun Microsystems, Inc.//DTD JAIN SLEE SBB 1.1//EN";
    private static final String DOCTYPE_SYSTEM = "http://java.sun.com/dtd/slee-sbb-jar_1_1.dtd";
    private XmlFileWriter xmlWriter;
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
        final org.w3c.dom.Element sbbJarElement = doc.createElement("sbb-jar");
        doc.appendChild(sbbJarElement);
        for (TypeElement typeElement : annotations) {
            final Set<? extends Element> elementSet = roundEnv.getElementsAnnotatedWith(typeElement);
            for (Element element : elementSet) {
                for (org.w3c.dom.Element sbbElement : new SbbFromElement(processingEnv, doc).generate(element)) {
                    sbbJarElement.appendChild(sbbElement);
                }
            }
        }
        for (TypeElement typeElement : annotations) {
            final Set<? extends Element> elementSet = roundEnv.getElementsAnnotatedWith(typeElement);
            final org.w3c.dom.Element element = SecurityPermissionsFromElements.generate(elementSet, doc);
            if (element != null) {
                sbbJarElement.appendChild(element);
            }
        }
        if (sbbJarElement.hasChildNodes()) {
            try {
                xmlWriter.write(processingEnv.getFiler(), doc);
            } catch (IOException | TransformerException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

}
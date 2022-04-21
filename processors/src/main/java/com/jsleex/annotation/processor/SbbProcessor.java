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

import com.jsleex.annotation.processor.xml.sbb.*;
import jakarta.xml.bind.JAXBException;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.IOException;
import java.util.Set;

@SupportedAnnotationTypes(value = {"com.jsleex.annotation.Sbb"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class SbbProcessor extends AbstractProcessor {
    private static final String OUTPUT_FILE = "META-INF/sbb-jar.xml";
    private static final String DOCTYPE = "<!DOCTYPE sbb-jar PUBLIC \"-//Sun Microsystems, Inc.//DTD JAIN SLEE SBB 1.1//EN\" \"http://java.sun.com/dtd/slee-sbb-jar_1_1.dtd\">\n";
    private final XmlFileWriter<SbbJar> xmlWriter;

    public SbbProcessor() {
        try {
            this.xmlWriter = new XmlFileWriter<>(SbbJar.class, OUTPUT_FILE, DOCTYPE);
        } catch (JSleeXProcessorException e) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Unable to initialize processor.");
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        final SbbJar sbbJar = new SbbJar();
        for (TypeElement typeElement : annotations) {
            final Set<? extends Element> elementSet = roundEnv.getElementsAnnotatedWith(typeElement);
            for (Element element : elementSet) {
                sbbJar.getSbb().addAll(new SbbFromElement(processingEnv).generate(element));
            }
        }
        if (!sbbJar.getSbb().isEmpty()) {
            try {
                xmlWriter.write(processingEnv.getFiler(), sbbJar);
            } catch (IOException | JAXBException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

}
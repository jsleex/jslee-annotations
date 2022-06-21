/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.LibraryRef;
import com.jsleex.annotation.LibraryRefs;
import org.w3c.dom.Document;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class LibraryRefsFromElement implements XmlFromElement {
    private final ProcessingEnvironment processingEnv;
    private final Document doc;

    public LibraryRefsFromElement(ProcessingEnvironment processingEnv, Document doc) {
        this.processingEnv = processingEnv;
        this.doc = doc;
    }

    @Override
    public List<org.w3c.dom.Element> generate(Element element) {
        final List<org.w3c.dom.Element> libraryRefs = new LinkedList<>();
        final AnnotationFinder annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
        annotationFinder.findAllAnnotationsOnType(element, LibraryRef.class)
                .values().stream().flatMap(Collection::stream).map((a) -> LibraryRefTransform.toXml(a, doc)).forEachOrdered(libraryRefs::add);
        annotationFinder.findAllAnnotationsOnType(element, LibraryRefs.class)
                .values().stream().flatMap(Collection::stream).flatMap(b -> Arrays.stream(b.value()))
                .map((a) -> LibraryRefTransform.toXml(a, doc)).forEachOrdered(libraryRefs::add);
        return libraryRefs;
    }
}

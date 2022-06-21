/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.ChildRelationMethod;
import org.w3c.dom.Document;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ChildRelationFromElement implements XmlFromElement {
    private final AnnotationFinder annotationFinder;
    private final Document doc;

    public ChildRelationFromElement(ProcessingEnvironment processingEnv, Document doc) {
        this.annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
        this.doc = doc;
    }

    @Override
    public List<org.w3c.dom.Element> generate(Element element) {
        List<org.w3c.dom.Element> childRelationMethods = new LinkedList<>();
        annotationFinder.findAllAnnotationsOnTypeMethods(element, ChildRelationMethod.class).entrySet().stream().map(
                (a) -> ChildRelationMethodTransform.toXml(a.getValue(), a.getKey(), doc)
        ).filter(Optional::isPresent).map(Optional::get).forEachOrdered(childRelationMethods::add);
        return childRelationMethods.stream().distinct().collect(Collectors.toList());
    }
}

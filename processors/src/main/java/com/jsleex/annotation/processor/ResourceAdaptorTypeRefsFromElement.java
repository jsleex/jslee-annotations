/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.RaTypeBinding;
import com.jsleex.annotation.RaTypeBindings;
import org.w3c.dom.Document;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ResourceAdaptorTypeRefsFromElement implements XmlFromElement {
    private final ProcessingEnvironment processingEnv;
    private final Document doc;

    public ResourceAdaptorTypeRefsFromElement(ProcessingEnvironment processingEnv, Document doc) {
        this.processingEnv = processingEnv;
        this.doc = doc;
    }

    @Override
    public List<org.w3c.dom.Element> generate(Element element) {
        final List<org.w3c.dom.Element> resourceAdaptorTypeRefs = new LinkedList<>();
        final AnnotationFinder annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
        annotationFinder.findAllAnnotationsOnType(element, RaTypeBinding.class)
                .values().stream().flatMap(Collection::stream).map((a) -> RaTypeBindingTransform.toXml(a, doc)).forEachOrdered(resourceAdaptorTypeRefs::add);
        annotationFinder.findAllAnnotationsOnType(element, RaTypeBindings.class)
                .values().stream().flatMap(Collection::stream).flatMap(b -> Arrays.stream(b.value()))
                .map((a) -> RaTypeBindingTransform.toXml(a, doc)).forEachOrdered(resourceAdaptorTypeRefs::add);
        return resourceAdaptorTypeRefs;
    }
}

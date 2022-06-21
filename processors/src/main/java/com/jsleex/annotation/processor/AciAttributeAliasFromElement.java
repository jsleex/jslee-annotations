/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.SbbActivityContextAttributeAlias;
import com.jsleex.annotation.SbbActivityContextAttributeAliases;
import org.w3c.dom.Document;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class AciAttributeAliasFromElement implements XmlFromElement {
    private final ProcessingEnvironment processingEnv;
    private final Document doc;

    public AciAttributeAliasFromElement(ProcessingEnvironment processingEnv, Document doc) {
        this.processingEnv = processingEnv;
        this.doc = doc;
    }

    @Override
    public List<org.w3c.dom.Element> generate(Element element) {
        final List<org.w3c.dom.Element> sbbActivityContextAttributeAliases = new LinkedList<>();
        final AnnotationFinder annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
        annotationFinder.findAllAnnotationsOnType(element, SbbActivityContextAttributeAlias.class)
                .values().stream().flatMap(Collection::stream).map(
                        (SbbActivityContextAttributeAlias sbbActivityContextAttributeAlias1) -> AciAttributeAliasTransform.toXml(sbbActivityContextAttributeAlias1, doc))
                .forEachOrdered(sbbActivityContextAttributeAliases::add);
        annotationFinder.findAllAnnotationsOnType(element, SbbActivityContextAttributeAliases.class)
                .values().stream().flatMap(Collection::stream).flatMap(b -> Arrays.stream(b.value()))
                .map(
                        (SbbActivityContextAttributeAlias sbbActivityContextAttributeAlias) -> AciAttributeAliasTransform.toXml(sbbActivityContextAttributeAlias, doc))
                .forEachOrdered(sbbActivityContextAttributeAliases::add);
        return sbbActivityContextAttributeAliases;
    }
}

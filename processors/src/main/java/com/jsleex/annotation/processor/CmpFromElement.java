/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.CmpMethod;
import org.w3c.dom.Document;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CmpFromElement implements XmlFromElement {
    private final AnnotationFinder annotationFinder;
    private final Document doc;

    public CmpFromElement(ProcessingEnvironment processingEnv, Document doc) {
        this.annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
        this.doc = doc;
    }

    @Override
    public List<org.w3c.dom.Element> generate(Element element) {
        List<org.w3c.dom.Element> cmpFields = new LinkedList<>();
        annotationFinder.findAllAnnotationsOnTypeMethods(element, CmpMethod.class).entrySet().stream().map(
                (a) -> CmpTransform.toXml(a.getValue(), a.getKey(), doc)
        ).filter(Optional::isPresent).map(Optional::get).forEachOrdered(cmpFields::add);
        return cmpFields.stream().map(WrapperForElement::new).distinct().map(WrapperForElement::getElement).collect(Collectors.toList());
    }

    //this probably can be improved
    static class WrapperForElement {
        private org.w3c.dom.Element element;
        WrapperForElement(org.w3c.dom.Element element){
            this.element = element;
        }

        public org.w3c.dom.Element getElement() {
            return element;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof WrapperForElement)) return false;
            WrapperForElement wrp = (WrapperForElement) o;

            return element.getTextContent().equals(wrp.element.getTextContent());
        }

        @Override
        public int hashCode() {
            return element.getTextContent().hashCode();
        }
    }
}

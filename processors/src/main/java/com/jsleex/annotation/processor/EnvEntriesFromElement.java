/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.EnvEntries;
import com.jsleex.annotation.EnvEntry;
import org.w3c.dom.Document;

import javax.lang.model.element.Element;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class EnvEntriesFromElement implements XmlFromElement {
    private final AnnotationFinder annotationFinder;
    private final Document doc;

    EnvEntriesFromElement(AnnotationFinder annotationFinder, Document doc) {
        this.annotationFinder = annotationFinder;
        this.doc = doc;
    }

    public List<org.w3c.dom.Element> generate(Element element) {
        List<org.w3c.dom.Element> envEntryList = new LinkedList<>();

        annotationFinder.findAllAnnotationsOnType(element, EnvEntry.class)
                .values().stream().flatMap(Collection::stream).map((a) -> EnvEntryTransform.toXml(a, doc)).forEachOrdered(envEntryList::add);
        annotationFinder.findAllAnnotationsOnType(element, EnvEntries.class)
                .values().stream().flatMap(Collection::stream).flatMap(b -> Arrays.stream(b.value()))
                .map((a) -> EnvEntryTransform.toXml(a, doc)).forEachOrdered(envEntryList::add);

        return envEntryList.stream().map(WrapperForElement::new).distinct().map(WrapperForElement::getElement).collect(Collectors.toList());
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

            return element.getElementsByTagName("env-entry-name").item(0).getTextContent().equals(wrp.element.getElementsByTagName("env-entry-name").item(0).getTextContent());
        }

        @Override
        public int hashCode() {
            return element.getElementsByTagName("env-entry-name").item(0).getTextContent().hashCode();
        }
    }
}

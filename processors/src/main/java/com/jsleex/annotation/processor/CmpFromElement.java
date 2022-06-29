/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.CmpMethod;
import org.w3c.dom.Document;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CmpFromElement implements XmlFromElement {
    // comment should contain "@slee.cmp-method" and optionally sbb-alias-ref="VALUE"
    private static final Pattern XDOCLET_PATTERN = Pattern.compile("(?s).*@slee.cmp-method(?:\\s*sbb-alias-ref=\"(\\w*)\")?.*");
    private final AnnotationFinder annotationFinder;
    private final Document doc;
    private final Elements elementUtils;

    public CmpFromElement(ProcessingEnvironment processingEnv, Document doc) {
        this.annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
        this.elementUtils = processingEnv.getElementUtils();
        this.doc = doc;
    }

    @Override
    public List<org.w3c.dom.Element> generate(Element element) {
        List<org.w3c.dom.Element> cmpFields = new LinkedList<>();
        annotationFinder.findAllAnnotationsOnTypeMethods(element, CmpMethod.class).entrySet().stream().map(
                (a) -> CmpTransform.toXml(a.getValue(), a.getKey(), doc)
        ).filter(Optional::isPresent).map(Optional::get).forEachOrdered(cmpFields::add);
        ElementFilter.methodsIn(elementUtils.getAllMembers((TypeElement) element)).stream()
                .map((a) -> new ElementAndComment(a, elementUtils.getDocComment(a)))
                .filter((a) -> a.isCmpField())
                .map((a) -> CmpTransform.toXmlFromXDoclet(doc, a.getElement(), a.getSbbAliasName()))
                .filter(Optional::isPresent).map(Optional::get).forEachOrdered(cmpFields::add);
        return cmpFields.stream().map(WrapperForElement::new).distinct().map(WrapperForElement::getElement).collect(Collectors.toList());
    }

    static class ElementAndComment {
        private final Element element;
        private final boolean isCmpField;
        private final String sbbAliasName;

        public ElementAndComment(Element element, String comment) {
            this.element = element;
            if (comment != null) {
                final Matcher matcher = XDOCLET_PATTERN.matcher(comment);
                if (matcher.matches()) {
                    this.isCmpField = true;
                    if (matcher.groupCount() > 0 && matcher.group(1) != null) {
                        this.sbbAliasName = matcher.group(1);
                    } else {
                        this.sbbAliasName = "";
                    }
                    return;
                }
            }
            this.isCmpField = false;
            this.sbbAliasName = "";
        }

        public Element getElement() {
            return element;
        }

        public boolean isCmpField() {
            return isCmpField;
        }

        public String getSbbAliasName() {
            return sbbAliasName;
        }
    }

    //this probably can be improved
    static class WrapperForElement {
        private final org.w3c.dom.Element element;
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

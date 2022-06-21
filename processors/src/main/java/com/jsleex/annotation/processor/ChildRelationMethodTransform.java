/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.ChildRelationMethod;
import org.w3c.dom.Document;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import java.util.Optional;

public class ChildRelationMethodTransform {
    public static Optional<org.w3c.dom.Element> toXml(ChildRelationMethod childRelationMethod, Element element, Document doc) {
        if (ElementKind.METHOD.equals(element.getKind())) {
            final org.w3c.dom.Element getChildRelationMethod = doc.createElement("get-child-relation-method");
            final org.w3c.dom.Element sbbAliasRef = doc.createElement("sbb-alias-ref");
            sbbAliasRef.setTextContent(childRelationMethod.sbbAliasRef());
            getChildRelationMethod.appendChild(sbbAliasRef);
            final org.w3c.dom.Element getChildRelationMethodName = doc.createElement("get-child-relation-method-name");
            getChildRelationMethodName.setTextContent(element.getSimpleName().toString());
            getChildRelationMethod.appendChild(getChildRelationMethodName);
            final org.w3c.dom.Element defaultPriority = doc.createElement("default-priority");
            defaultPriority.setTextContent(Integer.toString(childRelationMethod.defaultPriority()));
            getChildRelationMethod.appendChild(defaultPriority);
            return Optional.of(getChildRelationMethod);
        }
        return Optional.empty();
    }
}

/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.CmpMethod;
import org.w3c.dom.Document;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import java.util.Optional;

final class CmpTransform {

    private CmpTransform() {
        //empty
    }

    static public Optional<org.w3c.dom.Element> toXml(CmpMethod cmpMethod, Element element, Document doc) {
        if (ElementKind.METHOD.equals(element.getKind())) {
            if (element.getSimpleName().toString().startsWith("get") || element.getSimpleName().toString().startsWith("set")) {
                final org.w3c.dom.Element cmpField = doc.createElement("cmp-field");
                final org.w3c.dom.Element cmpFieldName = doc.createElement("cmp-field-name");
                // remove "set" or "get" prefix
                String s = element.getSimpleName().toString().substring(3);
                // change first letter to lower case
                final char[] c = s.toCharArray();
                c[0] = Character.toLowerCase(c[0]);
                s = new String(c);
                cmpFieldName.setTextContent(s);
                cmpField.appendChild(cmpFieldName);
                if (!cmpMethod.sbbAliasRef().isEmpty()) {
                    org.w3c.dom.Element sbbAliasRef = doc.createElement("sbb-alias-ref");
                    sbbAliasRef.setTextContent(cmpMethod.sbbAliasRef());
                    cmpField.appendChild(sbbAliasRef);
                }
                return Optional.of(cmpField);
            }
        }
        return Optional.empty();
    }

    public static Optional<org.w3c.dom.Element> toXmlFromXDoclet(Document doc, Element element, String sbbAliasName) {
        if (element.getSimpleName().toString().startsWith("get") || element.getSimpleName().toString().startsWith("set")) {
            final org.w3c.dom.Element cmpField = doc.createElement("cmp-field");
            final org.w3c.dom.Element cmpFieldName = doc.createElement("cmp-field-name");
            // remove "set" or "get" prefix
            String s = element.getSimpleName().toString().substring(3);
            // change first letter to lower case
            final char[] c = s.toCharArray();
            c[0] = Character.toLowerCase(c[0]);
            s = new String(c);
            cmpFieldName.setTextContent(s);
            cmpField.appendChild(cmpFieldName);
            if (!sbbAliasName.isEmpty()) {
                org.w3c.dom.Element sbbAliasRef = doc.createElement("sbb-alias-ref");
                sbbAliasRef.setTextContent(sbbAliasName);
                cmpField.appendChild(sbbAliasRef);
            }
            return Optional.of(cmpField);
        }
        return Optional.empty();
    }
}

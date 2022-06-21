/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.Sbb;
import org.w3c.dom.Document;

import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import java.util.Set;

public class SecurityPermissionsFromElements {
    public static org.w3c.dom.Element generate(Set<? extends Element> elementSet, Document doc) {
        for (Element element : elementSet) {
            if (element.getKind().isClass() && element.getModifiers().contains(Modifier.ABSTRACT)) {
                Sbb sbbAnnotation = element.getAnnotation(com.jsleex.annotation.Sbb.class);
                if (!sbbAnnotation.securityPermissions().isEmpty()) {
                    org.w3c.dom.Element securityPermissionsElement =  doc.createElement("security-permissions");
                    org.w3c.dom.Element securityPermissionsSpecElement =  doc.createElement("security-permission-spec");
                    securityPermissionsElement.appendChild(securityPermissionsSpecElement);
                    securityPermissionsSpecElement.setTextContent(sbbAnnotation.securityPermissions());
                    return securityPermissionsElement;
                }
            }
        }
        return null;
    }
}

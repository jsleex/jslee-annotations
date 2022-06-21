/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.EjbRef;
import org.w3c.dom.Document;

public final class EjbRefTransform {
    private EjbRefTransform() {
        //empty
    }

    //<!ELEMENT ejb-ref (description?, ejb-ref-name, ejb-ref-type, home, remote)>

    public static org.w3c.dom.Element toXml(EjbRef ejbRef, Document doc) {
        final org.w3c.dom.Element result = doc.createElement("ejb-ref");
        final org.w3c.dom.Element ejbRefName = doc.createElement("ejb-ref-name");
        ejbRefName.setTextContent(ejbRef.ejbRefName());
        result.appendChild(ejbRefName);
        final org.w3c.dom.Element ejbRefType = doc.createElement("ejb-ref-type");
        ejbRefType.setTextContent(ejbRef.ejbRefType().toString());
        result.appendChild(ejbRefType);
        final org.w3c.dom.Element home = doc.createElement("home");
        home.setTextContent(ejbRef.home());
        result.appendChild(home);
        final org.w3c.dom.Element remote = doc.createElement("remote");
        remote.setTextContent(ejbRef.remote());
        result.appendChild(remote);

        return result;
    }
}

/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.LibraryRef;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class LibraryRefTransform {
    private LibraryRefTransform() {
        //empty
    }

    public static Element toXml(LibraryRef profileSpecRef, Document doc) {
        final Element libraryRefXml = doc.createElement("library-ref");
        final Element libraryName = doc.createElement("library-name");
        libraryName.setTextContent(profileSpecRef.name());
        libraryRefXml.appendChild(libraryName);
        final Element libraryVendor = doc.createElement("library-vendor");
        libraryVendor.setTextContent(profileSpecRef.vendor());
        libraryRefXml.appendChild(libraryVendor);
        final Element libraryVersion = doc.createElement("library-version");
        libraryVersion.setTextContent(profileSpecRef.version());
        libraryRefXml.appendChild(libraryVersion);
        return libraryRefXml;
    }
}

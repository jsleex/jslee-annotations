/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.RaTypeBinding;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class RaTypeBindingTransform {
    private RaTypeBindingTransform() {
        //empty
    }

    public static Element toXml(RaTypeBinding raTypeBinding, Document doc) {
        final Element resourceAdaptorTypeBinding = doc.createElement("resource-adaptor-type-binding");
        final Element raTypeRef = createRaTypeRefFromAnnotation(raTypeBinding, doc);
        resourceAdaptorTypeBinding.appendChild(raTypeRef);
        if (!raTypeBinding.activityContextInterfaceFactoryName().isEmpty()) {
            final Element aciFactoryName = doc.createElement("activity-context-interface-factory-name");
            aciFactoryName.setTextContent(raTypeBinding.activityContextInterfaceFactoryName());
            resourceAdaptorTypeBinding.appendChild(aciFactoryName);
        }
        for (int i = 0; i < Math.min(raTypeBinding.resourceAdaptorEntityLinks().length,
                     raTypeBinding.resourceAdaptorObjectNames().length); i++) {
            final Element resourceAdaptorEntityBinding = doc.createElement("resource-adaptor-entity-binding");
            final Element raObjectName = doc.createElement("resource-adaptor-object-name");
            raObjectName.setTextContent(raTypeBinding.resourceAdaptorObjectNames()[i]);
            resourceAdaptorEntityBinding.appendChild(raObjectName);
            final Element raEntityLink = doc.createElement("resource-adaptor-entity-link");
            raEntityLink.setTextContent(raTypeBinding.resourceAdaptorEntityLinks()[i]);
            resourceAdaptorEntityBinding.appendChild(raEntityLink);
            resourceAdaptorTypeBinding.appendChild(resourceAdaptorEntityBinding);
        }
        return resourceAdaptorTypeBinding;
    }

    private static Element createRaTypeRefFromAnnotation(RaTypeBinding raTypeBinding, Document doc) {
        final Element raTypeRef = doc.createElement("resource-adaptor-type-ref");
        final Element raTypeName = doc.createElement("resource-adaptor-type-name");
        raTypeName.setTextContent(raTypeBinding.resourceAdaptorTypeName());
        raTypeRef.appendChild(raTypeName);
        final Element raTypeVendor = doc.createElement("resource-adaptor-type-vendor");
        raTypeVendor.setTextContent(raTypeBinding.resourceAdaptorTypeVendor());
        raTypeRef.appendChild(raTypeVendor);
        final Element raTypeVersion = doc.createElement("resource-adaptor-type-version");
        raTypeVersion.setTextContent(raTypeBinding.resourceAdaptorTypeVersion());
        raTypeRef.appendChild(raTypeVersion);
        return raTypeRef;
    }
}

/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.SbbActivityContextAttributeAlias;
import org.w3c.dom.Document;

public final class AciAttributeAliasTransform {
    private AciAttributeAliasTransform() {
        //empty
    }

    public static org.w3c.dom.Element toXml(SbbActivityContextAttributeAlias sbbActivityContextAttributeAlias, Document doc) {
        final org.w3c.dom.Element activityContextAttributeAlias = doc.createElement("activity-context-attribute-alias");
        final org.w3c.dom.Element attributeAliasName = doc.createElement("attribute-alias-name");
        attributeAliasName.setTextContent(sbbActivityContextAttributeAlias.attributeAliasName());
        activityContextAttributeAlias.appendChild(attributeAliasName);
        for (String aciAttributeName : sbbActivityContextAttributeAlias.sbbActivityContextAttributesNames()) {
            final org.w3c.dom.Element activityContextAttributeName = doc.createElement("sbb-activity-context-attribute-name");
            activityContextAttributeName.setTextContent(aciAttributeName);
            activityContextAttributeAlias.appendChild(activityContextAttributeName);
        }
        return activityContextAttributeAlias;
    }
}

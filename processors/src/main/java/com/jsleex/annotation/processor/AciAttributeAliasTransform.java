package com.jsleex.annotation.processor;

import com.jsleex.annotation.SbbActivityContextAttributeAlias;
import com.jsleex.annotation.processor.xml.sbb.ActivityContextAttributeAlias;
import com.jsleex.annotation.processor.xml.sbb.AttributeAliasName;
import com.jsleex.annotation.processor.xml.sbb.SbbActivityContextAttributeName;

public final class AciAttributeAliasTransform {
    private AciAttributeAliasTransform() {
        //empty
    }

    public static ActivityContextAttributeAlias toXml(SbbActivityContextAttributeAlias sbbActivityContextAttributeAlias) {
        final ActivityContextAttributeAlias activityContextAttributeAlias = new ActivityContextAttributeAlias();
        final AttributeAliasName attributeAliasName = new AttributeAliasName();
        attributeAliasName.setvalue(sbbActivityContextAttributeAlias.attributeAliasName());
        activityContextAttributeAlias.setAttributeAliasName(attributeAliasName);
        for (String aciAttributeName : sbbActivityContextAttributeAlias.sbbActivityContextAttributesNames()) {
            final SbbActivityContextAttributeName activityContextAttributeName = new SbbActivityContextAttributeName();
            activityContextAttributeName.setvalue(aciAttributeName);
            activityContextAttributeAlias.getSbbActivityContextAttributeName().add(activityContextAttributeName);
        }
        return activityContextAttributeAlias;
    }
}

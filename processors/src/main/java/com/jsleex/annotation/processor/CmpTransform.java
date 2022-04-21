package com.jsleex.annotation.processor;

import com.jsleex.annotation.CmpMethod;
import com.jsleex.annotation.processor.xml.sbb.CmpField;
import com.jsleex.annotation.processor.xml.sbb.CmpFieldName;
import com.jsleex.annotation.processor.xml.sbb.SbbAliasRef;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import java.util.Optional;

final class CmpTransform {

    private CmpTransform() {
        //empty
    }

    static public Optional<CmpField> toXml(CmpMethod cmpMethod, Element element) {
        if (ElementKind.METHOD.equals(element.getKind())) {
            if (element.getSimpleName().toString().startsWith("get") || element.getSimpleName().toString().startsWith("set")) {
                final CmpField cmpField = new CmpField();
                final CmpFieldName cmpFieldName = new CmpFieldName();
                // remove "set" or "get" prefix
                String s = element.getSimpleName().toString().substring(3);
                // change first letter to lower case
                final char c[] = s.toCharArray();
                c[0] = Character.toLowerCase(c[0]);
                s = new String(c);
                cmpFieldName.setvalue(s);
                cmpField.setCmpFieldName(cmpFieldName);
                if (!cmpMethod.sbbAliasRef().isEmpty()) {
                    SbbAliasRef sbbAliasRef = new SbbAliasRef();
                    sbbAliasRef.setvalue(cmpMethod.sbbAliasRef());
                    cmpField.setSbbAliasRef(sbbAliasRef);
                }
                return Optional.of(cmpField);
            }
        }
        return Optional.empty();
    }
}

package com.jsleex.annotation.processor;

import com.jsleex.annotation.ChildRelationMethod;
import com.jsleex.annotation.processor.xml.common.DefaultPriority;
import com.jsleex.annotation.processor.xml.sbb.*;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import java.util.Optional;

public class ChildRelationMethodTransform {
    public static Optional<GetChildRelationMethod> toXml(ChildRelationMethod childRelationMethod, Element element) {
        if (ElementKind.METHOD.equals(element.getKind())) {
            final GetChildRelationMethod getChildRelationMethod = new GetChildRelationMethod();
            final GetChildRelationMethodName getChildRelationMethodName = new GetChildRelationMethodName();
            getChildRelationMethodName.setvalue(element.getSimpleName().toString());
            getChildRelationMethod.setGetChildRelationMethodName(getChildRelationMethodName);
            final SbbAliasRef sbbAliasRef = new SbbAliasRef();
            sbbAliasRef.setvalue(childRelationMethod.sbbAliasRef());
            getChildRelationMethod.setSbbAliasRef(sbbAliasRef);
            final DefaultPriority defaultPriority = new DefaultPriority();
            defaultPriority.setvalue(Integer.toString(childRelationMethod.defaultPriority()));
            getChildRelationMethod.setDefaultPriority(defaultPriority);
            return Optional.of(getChildRelationMethod);
        }
        return Optional.empty();
    }
}

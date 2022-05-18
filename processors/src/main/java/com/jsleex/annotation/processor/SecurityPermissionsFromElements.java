package com.jsleex.annotation.processor;

import com.jsleex.annotation.Sbb;
import com.jsleex.annotation.processor.xml.common.SecurityPermissionSpec;
import com.jsleex.annotation.processor.xml.common.SecurityPermissions;

import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import java.util.Set;

public class SecurityPermissionsFromElements {
    public static SecurityPermissions generate(Set<? extends Element> elementSet) {
        for (Element element : elementSet) {
            if (element.getKind().isClass() && element.getModifiers().contains(Modifier.ABSTRACT)) {
                Sbb sbbAnnotation = element.getAnnotation(com.jsleex.annotation.Sbb.class);
                if (!sbbAnnotation.securityPermissions().isEmpty()) {
                    SecurityPermissions securityPermissions = new SecurityPermissions();
                    SecurityPermissionSpec securityPermissionSpec = new SecurityPermissionSpec();
                    securityPermissionSpec.setvalue(sbbAnnotation.securityPermissions());
                    securityPermissions.setSecurityPermissionSpec(securityPermissionSpec);
                    return securityPermissions;
                }
            }
        }
        return null;
    }
}

package com.jsleex.annotation.processor;

import com.jsleex.annotation.RaTypeBinding;
import com.jsleex.annotation.processor.xml.common.ResourceAdaptorTypeName;
import com.jsleex.annotation.processor.xml.common.ResourceAdaptorTypeVendor;
import com.jsleex.annotation.processor.xml.common.ResourceAdaptorTypeVersion;
import com.jsleex.annotation.processor.xml.sbb.*;

public final class RaTypeBindingTransform {
    private RaTypeBindingTransform() {
        //empty
    }

    public static ResourceAdaptorTypeBinding toXml(RaTypeBinding raTypeBinding) {
        final ResourceAdaptorTypeBinding resourceAdaptorTypeBinding = new ResourceAdaptorTypeBinding();
        final ResourceAdaptorTypeRef raTypeRef = createRaTypeRefFromAnnotation(raTypeBinding);
        resourceAdaptorTypeBinding.setResourceAdaptorTypeRef(raTypeRef);
        if (!raTypeBinding.activityContextInterfaceFactoryName().isEmpty()) {
            final ActivityContextInterfaceFactoryName aciFactoryName = new ActivityContextInterfaceFactoryName();
            aciFactoryName.setvalue(raTypeBinding.activityContextInterfaceFactoryName());
            resourceAdaptorTypeBinding.setActivityContextInterfaceFactoryName(aciFactoryName);
        }
        for (int i = 0; i < Math.min(raTypeBinding.resourceAdaptorEntityLinks().length,
                     raTypeBinding.resourceAdaptorObjectNames().length); i++) {
            final ResourceAdaptorEntityBinding resourceAdaptorEntityBinding = new ResourceAdaptorEntityBinding();
            final ResourceAdaptorEntityLink raEntityLink = new ResourceAdaptorEntityLink();
            raEntityLink.setvalue(raTypeBinding.resourceAdaptorEntityLinks()[i]);
            resourceAdaptorEntityBinding.setResourceAdaptorEntityLink(raEntityLink);
            final ResourceAdaptorObjectName raObjectName = new ResourceAdaptorObjectName();
            raObjectName.setvalue(raTypeBinding.resourceAdaptorObjectNames()[i]);
            resourceAdaptorEntityBinding.setResourceAdaptorObjectName(raObjectName);
            resourceAdaptorTypeBinding.getResourceAdaptorEntityBinding().add(resourceAdaptorEntityBinding);
        }
        return resourceAdaptorTypeBinding;
    }

    private static ResourceAdaptorTypeRef createRaTypeRefFromAnnotation(RaTypeBinding raTypeBinding) {
        final ResourceAdaptorTypeRef raTypeRef = new ResourceAdaptorTypeRef();
        final ResourceAdaptorTypeName raTypeName = new ResourceAdaptorTypeName();
        raTypeName.setvalue(raTypeBinding.resourceAdaptorTypeName());
        raTypeRef.setResourceAdaptorTypeName(raTypeName);
        final ResourceAdaptorTypeVendor raTypeVendor = new ResourceAdaptorTypeVendor();
        raTypeVendor.setvalue(raTypeBinding.resourceAdaptorTypeVendor());
        raTypeRef.setResourceAdaptorTypeVendor(raTypeVendor);
        final ResourceAdaptorTypeVersion raTypeVersion = new ResourceAdaptorTypeVersion();
        raTypeVersion.setvalue(raTypeBinding.resourceAdaptorTypeVersion());
        raTypeRef.setResourceAdaptorTypeVersion(raTypeVersion);
        return raTypeRef;
    }
}

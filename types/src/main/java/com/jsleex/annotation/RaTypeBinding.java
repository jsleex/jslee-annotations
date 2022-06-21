/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(RaTypeBindings.class)
public @interface RaTypeBinding {
    String resourceAdaptorTypeName();

    String resourceAdaptorTypeVendor();

    String resourceAdaptorTypeVersion();

    String activityContextInterfaceFactoryName() default "";

    String[] resourceAdaptorObjectNames() default "";

    String[] resourceAdaptorEntityLinks() default "";
}

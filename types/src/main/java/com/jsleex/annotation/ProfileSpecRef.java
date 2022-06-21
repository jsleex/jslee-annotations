/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ProfileSpecRefs.class)
public @interface ProfileSpecRef {
    String profileSpecId() default "";

    String profileSpecName() default "";

    String profileSpecVendor() default "";

    String profileSpecVersion() default "";

    String profileSpecAlias() default "";
}

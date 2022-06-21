/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(SbbRefs.class)
public @interface SbbRef {
    String sbbId() default "";

    String name() default "";

    String vendor() default "";

    String version() default "";

    String alias() default "";
}

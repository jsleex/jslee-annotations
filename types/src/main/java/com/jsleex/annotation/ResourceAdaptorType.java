/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ResourceAdaptorTypes.class)
public @interface ResourceAdaptorType {
    String id();

    String name();

    String vendor();

    String version();
}

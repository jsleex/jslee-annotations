/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ResourceAdaptorInterface {
    String id();
}

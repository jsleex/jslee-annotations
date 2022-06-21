/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(SbbActivityContextAttributeAliases.class)
public @interface SbbActivityContextAttributeAlias {
    String attributeAliasName();

    String[] sbbActivityContextAttributesNames();
}

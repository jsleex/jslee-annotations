/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(EnvEntries.class)
public @interface EnvEntry {
    String envEntryName();

    /**
     * The environment entry values may be one of the following Java types: String, Character, Integer, Boolean, Double, Byte, Short, Long, and Float.
     * @return environment entry type Enum
     */
    Class envEntryType();

    String envEntryValue() default "";
}

/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.example;

import com.jsleex.annotation.EnvEntry;

@EnvEntry(envEntryName = "testinterface", envEntryType = java.lang.String.class, envEntryValue = "testinterface")
public interface TestProfileInterface extends Test2Interface, Test3Interface {
}

/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor.test;

import com.jsleex.annotation.EnvEntry;

@EnvEntry(envEntryName = "test2ainterface", envEntryType = java.lang.String.class, envEntryValue = "test2ainterface")
@EnvEntry(envEntryName = "test2binterface", envEntryType = java.lang.String.class, envEntryValue = "test2binterface")
public interface Test2Interface {
}

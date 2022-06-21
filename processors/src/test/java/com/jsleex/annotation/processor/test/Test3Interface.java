/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor.test;

import com.jsleex.annotation.EnvEntry;

@EnvEntry(envEntryName = "test3ainterface", envEntryType = java.lang.String.class, envEntryValue = "test3ainterface")
@EnvEntry(envEntryName = "test3binterface", envEntryType = java.lang.String.class, envEntryValue = "test3binterface")
// This would overwrite existing env-entry so won't be added
@EnvEntry(envEntryName = "testinterface", envEntryType = java.lang.String.class, envEntryValue = "shouldNotAddMe")
public interface Test3Interface {
}

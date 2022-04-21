package com.jsleex.annotation.example;

import com.jsleex.annotation.EnvEntry;
import com.jsleex.annotation.ProfileSpec;

@ProfileSpec(name = "TestProfile", vendor = "Test", version = "Test")
@EnvEntry(envEntryName = "test1", envEntryType = java.lang.String.class, envEntryValue = "test1")
public interface TestProfile {
}

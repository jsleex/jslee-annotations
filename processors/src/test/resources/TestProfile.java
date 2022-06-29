/*
 * JSLEE Annotations
 * Copyright (C) 2015-2022 Piotr Grabowski
 */

package profile;

import com.jsleex.annotation.example.TestProfileInterface;
import com.jsleex.annotation.example.TestProfileParent;
import com.jsleex.annotation.EnvEntry;
import com.jsleex.annotation.ProfileSpec;

@ProfileSpec(id = "Test", name = "Test", vendor = "Test", version = "Test")
@EnvEntry(envEntryName = "test1", envEntryType = java.lang.String.class, envEntryValue = "test1")
public class TestProfile extends TestProfileParent implements TestProfileInterface {
}

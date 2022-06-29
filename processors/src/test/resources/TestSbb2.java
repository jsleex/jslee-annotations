/*
 * JSLEE Annotations
 * Copyright (C) 2015-2022 Piotr Grabowski
 */

package sbb;

import com.jsleex.annotation.Sbb;
import com.jsleex.annotation.Service;
import com.jsleex.annotation.example.TestParent;

@Service(name = "Test2", vendor = "Test", version = "1.0")
@Sbb(name = "Test2", vendor = "Test", version = "1.0", reentrant = true)
public abstract class TestSbb2 extends TestParent {
}

/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.example;

import com.jsleex.annotation.CmpMethod;

public interface TestCmpInterface {
    @CmpMethod
    void shouldNotAdd();

    // Should add
    @CmpMethod
    int getInteger();

    // Shouldn't add again
    @CmpMethod
    void setInteger(int i);
}

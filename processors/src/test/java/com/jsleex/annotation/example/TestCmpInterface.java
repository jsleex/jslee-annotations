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

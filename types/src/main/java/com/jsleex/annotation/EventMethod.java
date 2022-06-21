/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventMethod {
    enum InitialEventSelectVariable {
        NONE(""),
        ACTIVITY_CONTEXT("ActivityContext"),
        ADDRESS_PROFILE("AddressProfile"),
        ADDRESS("Address"),
        EVENT_TYPE("EventType"),
        EVENT("Event");
        private final String stringValue;

        InitialEventSelectVariable(String stringValue) {
            this.stringValue = stringValue;
        }

        @Override
        public String toString() {
            return stringValue;
        }

    }

    boolean initialEvent() default false;

    boolean maskOnAttach() default false;

    boolean lastInTransaction() default true;

    String eventTypeName();

    String eventTypeVendor();

    String eventTypeVersion();

    InitialEventSelectVariable[] initialEventSelectVariable() default {};

    String initialEventSelectorMethodName() default "";

    String eventResourceOption() default "";
}

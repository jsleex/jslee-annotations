/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface EjbRef {

    public enum EjbRefType {
        ENTITY("Entity"),
        SESSION("Session");

        private final String stringValue;

        EjbRefType(String stringValue) {
            this.stringValue = stringValue;
        }

        @Override
        public String toString() {
            return stringValue;
        }
    }

    String ejbRefName();

    EjbRefType ejbRefType();

    String home();

    String remote();

    String ejbLink() default "";
}

/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

/**
 * Exception thrown when processor can't continue with processing.
 */
public class JSleeXProcessorException extends Exception {
    public JSleeXProcessorException(String message) {
        super(message);
    }

    public JSleeXProcessorException(Exception e) {
        super(e);
    }

    public JSleeXProcessorException(String message, Exception e) {
        super(message, e);
    }
}

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

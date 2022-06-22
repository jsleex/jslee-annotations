package com.jsleex.annotation.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.lang.model.SourceVersion;

public abstract class JsleeXProcessor extends AbstractProcessor {
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}

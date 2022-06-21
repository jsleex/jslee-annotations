/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import org.w3c.dom.Document;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import java.util.Collections;
import java.util.List;

public class ProfileCmpFromElement implements XmlFromElement {

    private final ProcessingEnvironment processingEnv;
    private final Document doc;

    public ProfileCmpFromElement(ProcessingEnvironment processingEnv, Document doc) {
        this.processingEnv = processingEnv;
        this.doc = doc;
    }

    @Override
    public List<org.w3c.dom.Element> generate(Element element) {
        //todo
        return Collections.emptyList();
    }
}

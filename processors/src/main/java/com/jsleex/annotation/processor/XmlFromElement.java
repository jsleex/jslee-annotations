/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import javax.lang.model.element.Element;
import java.lang.annotation.Annotation;
import java.util.List;

public interface XmlFromElement {
    List<org.w3c.dom.Element> generate(Element element);
}

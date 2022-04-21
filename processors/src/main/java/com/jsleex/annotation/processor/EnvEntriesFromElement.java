/*
 * JSLEE Annotations
 * Copyright (c) 2015 Piotr Grabowski, All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.EnvEntries;
import com.jsleex.annotation.processor.xml.common.EnvEntry;

import javax.lang.model.element.Element;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class EnvEntriesFromElement implements XmlFromElement {
    private final AnnotationFinder annotationFinder;

    EnvEntriesFromElement(AnnotationFinder annotationFinder) {
        this.annotationFinder = annotationFinder;
    }

    public List<EnvEntry> generate(Element element) {
        List<EnvEntry> envEntryList = new LinkedList<>();

        annotationFinder.findAllAnnotationsOnType(element, com.jsleex.annotation.EnvEntry.class)
                .values().stream().flatMap( a -> a.stream()).map(EnvEntryTransform::toXml).forEachOrdered(envEntryList::add);
        annotationFinder.findAllAnnotationsOnType(element, EnvEntries.class)
                .values().stream().flatMap( a -> a.stream()).flatMap( b -> Arrays.stream(b.value()))
                .map(EnvEntryTransform::toXml).forEachOrdered(envEntryList::add);

        return envEntryList.stream().distinct().collect(Collectors.toList());
    }

}

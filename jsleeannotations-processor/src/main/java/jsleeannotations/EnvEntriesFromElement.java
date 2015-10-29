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

package jsleeannotations;

import jsleeannotations.slee.EnvEntries;
import jsleeannotations.xml.common.EnvEntry;

import javax.lang.model.element.Element;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EnvEntriesFromElement implements XmlFromElement {

    private final AnnotationToXml<EnvEntry, jsleeannotations.slee.EnvEntry> annotationToXml;
    private final AnnotationFinder annotationFinder;

    EnvEntriesFromElement(AnnotationFinder annotationFinder, AnnotationToXml<EnvEntry, jsleeannotations.slee.EnvEntry> annotationToXml) {
        this.annotationFinder = annotationFinder;
        this.annotationToXml = annotationToXml;
    }

    public List<EnvEntry> generate(Element element) {
        List<EnvEntry> envEntryList = new LinkedList<>();

        Map<Element, List<jsleeannotations.slee.EnvEntry>> elementListMap = annotationFinder.findAllAnnotationsOnType(element, jsleeannotations.slee.EnvEntry.class);
        for (List<jsleeannotations.slee.EnvEntry> list : elementListMap.values()) {
            for (jsleeannotations.slee.EnvEntry envEntry : list) {
                envEntryList.add(annotationToXml.transform(envEntry));
            }
        }
        Map<Element, List<EnvEntries>> envEntriesMap = annotationFinder.findAllAnnotationsOnType(element, EnvEntries.class);
        for (List<EnvEntries> list : envEntriesMap.values()) {
            for (EnvEntries envEntries : list) {
                for (jsleeannotations.slee.EnvEntry envEntry : envEntries.value()) {
                    envEntryList.add(annotationToXml.transform(envEntry));
                }
            }
        }
        return envEntryList;
    }

}

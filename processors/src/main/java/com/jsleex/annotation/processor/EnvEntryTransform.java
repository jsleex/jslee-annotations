/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.EnvEntry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;

final class EnvEntryTransform {

    //<!ELEMENT env-entry (description?, env-entry-name, env-entry-type,
    //          env-entry-value?)>
    public static Element toXml(EnvEntry envEntry, Document doc) {
        String envEntryType;
        try {
            envEntryType = envEntry.envEntryType().getName();
        } catch (MirroredTypeException mte) {
            TypeMirror typeMirror = mte.getTypeMirror();
            envEntryType = typeMirror.toString();

        }
        final String envEntryValue = envEntry.envEntryValue().isEmpty() ? null : envEntry.envEntryValue();
        return createEnvEntryXml(envEntry.envEntryName(), envEntryType, envEntryValue, doc);
    }

    private static Element createEnvEntryXml(String name, String type, String value, Document doc) {
        final Element envEntry = doc.createElement("env-entry");
        final Element envEntryName = doc.createElement("env-entry-name");
        final Element envEntryType = doc.createElement("env-entry-type");
        final Element envEntryValue = doc.createElement("env-entry-value");
        envEntryName.setTextContent(name);
        envEntryType.setTextContent(type);
        envEntryValue.setTextContent(value);
        envEntry.appendChild(envEntryName);
        envEntry.appendChild(envEntryType);
        envEntry.appendChild(envEntryValue);

        return envEntry;
    }
}

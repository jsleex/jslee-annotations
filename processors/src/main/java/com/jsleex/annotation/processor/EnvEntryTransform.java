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

import com.jsleex.annotation.EnvEntry;
import com.jsleex.annotation.processor.xml.common.EnvEntryName;
import com.jsleex.annotation.processor.xml.common.EnvEntryType;
import com.jsleex.annotation.processor.xml.common.EnvEntryValue;

import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;

final class EnvEntryTransform {

    public static com.jsleex.annotation.processor.xml.common.EnvEntry toXml(EnvEntry envEntry) {
        String envEntryType;
        try {
            envEntryType = envEntry.envEntryType().getName();
        } catch (MirroredTypeException mte) {
            TypeMirror typeMirror = mte.getTypeMirror();
            envEntryType = typeMirror.toString();

        }
        final String envEntryValue = envEntry.envEntryValue().isEmpty() ? null : envEntry.envEntryValue();
        return createEnvEntryXml(envEntry.envEntryName(), envEntryType, envEntryValue);
    }

    private static com.jsleex.annotation.processor.xml.common.EnvEntry createEnvEntryXml(String name, String type, String value) {
        final com.jsleex.annotation.processor.xml.common.EnvEntry envEntry = new com.jsleex.annotation.processor.xml.common.EnvEntry();

        final EnvEntryName envEntryName = new EnvEntryName();
        final EnvEntryType envEntryType = new EnvEntryType();
        final EnvEntryValue envEntryValue = new EnvEntryValue();
        envEntryName.setvalue(name);
        envEntryType.setvalue(type);
        envEntryValue.setvalue(value);
        envEntry.setEnvEntryName(envEntryName);
        envEntry.setEnvEntryType(envEntryType);
        envEntry.setEnvEntryValue(envEntryValue);

        return envEntry;
    }
}

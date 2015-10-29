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

import jsleeannotations.slee.EnvEntry;

import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;

class EnvEntryToXml implements AnnotationToXml<jsleeannotations.xml.common.EnvEntry, EnvEntry> {

    @Override
    public jsleeannotations.xml.common.EnvEntry transform(EnvEntry envEntry) {
        String envEntryType;
        try {
            envEntryType = envEntry.envEntryType().getName();
        } catch (MirroredTypeException mte) {
            TypeMirror typeMirror = mte.getTypeMirror();
            envEntryType = typeMirror.toString();

        }

        String envEntryValue = envEntry.envEntryValue().isEmpty() ? null : envEntry.envEntryValue();

        return new jsleeannotations.xml.common.EnvEntry(envEntry.envEntryName(), envEntryType, envEntryValue);
    }
}

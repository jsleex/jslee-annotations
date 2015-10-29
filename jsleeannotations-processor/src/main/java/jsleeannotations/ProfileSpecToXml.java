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

import jsleeannotations.slee.ProfileSpec;
import jsleeannotations.xml.profile.Description;
import jsleeannotations.xml.profile.ProfileClasses;

public class ProfileSpecToXml implements AnnotationToXml<jsleeannotations.xml.profile.ProfileSpec, jsleeannotations.slee.ProfileSpec> {
    @Override
    public jsleeannotations.xml.profile.ProfileSpec transform(ProfileSpec profileSpecAnnotation) {
        jsleeannotations.xml.profile.ProfileSpec profileSpecXml = new jsleeannotations.xml.profile.ProfileSpec();
        profileSpecXml.setDescription(profileSpecAnnotation.description().isEmpty() ? null : new Description(profileSpecAnnotation.description()));
        return null;
    }
}

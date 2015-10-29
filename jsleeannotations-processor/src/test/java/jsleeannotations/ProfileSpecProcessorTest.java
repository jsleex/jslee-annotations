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

import com.google.common.io.Resources;
import com.google.testing.compile.JavaFileObjects;
import org.junit.Test;

import static com.google.common.truth.Truth.assertAbout;
import static com.google.testing.compile.JavaSourceSubjectFactory.javaSource;
import static javax.tools.StandardLocation.SOURCE_OUTPUT;

public class ProfileSpecProcessorTest {

    @Test
    public void testProcess() throws Exception {
        assertAbout(javaSource())
                .that(JavaFileObjects.forResource("TestProfile.java"))
                .processedWith(new ProfileSpecProcessor())
                .compilesWithoutError().and()
                .generatesFileNamed(SOURCE_OUTPUT, "", "profile-spec-jar.xml")
                .withContents(com.google.common.io.Resources.asByteSource(Resources.getResource("test-profile1.xml")));
    }
}

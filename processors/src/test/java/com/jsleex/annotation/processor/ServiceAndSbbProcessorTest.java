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

import com.google.testing.compile.Compilation;
import com.google.testing.compile.JavaFileObjects;
import org.junit.Test;

import javax.tools.StandardLocation;
import jakarta.xml.bind.JAXBException;

import static com.google.testing.compile.CompilationSubject.assertThat;
import static com.google.testing.compile.Compiler.javac;

public class ServiceAndSbbProcessorTest {
    @Test
    public void testProcess() throws JAXBException {
        Compilation compilation = javac().withProcessors(new ServiceProcessor(), new SbbProcessor())
                .compile(JavaFileObjects.forResource("TestSbb1.java"),
                         JavaFileObjects.forResource("TestSbb2.java"));
        assertThat(compilation).succeeded();
        assertThat(compilation).generatedFile(StandardLocation.CLASS_OUTPUT, "META-INF/service.xml")
                .isEqualTo(JavaFileObjects.forResource("test-service1.xml"));
        assertThat(compilation).generatedFile(StandardLocation.CLASS_OUTPUT, "META-INF/sbb-jar.xml")
                .isEqualTo(JavaFileObjects.forResource("test-sbb-jar1.xml"));
    }
}

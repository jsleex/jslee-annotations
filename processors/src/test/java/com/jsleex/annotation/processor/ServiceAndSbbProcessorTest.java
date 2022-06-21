/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.JavaFileObjects;
import org.junit.Test;

import javax.tools.StandardLocation;

import static com.google.testing.compile.CompilationSubject.assertThat;
import static com.google.testing.compile.Compiler.javac;

public class ServiceAndSbbProcessorTest {
    @Test
    public void testProcess() {
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

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

public class ProfileSpecProcessorTest {

    @Test
    public void testProcess() {
        Compilation compilation = javac().withProcessors(new ProfileSpecProcessor())
                .compile(JavaFileObjects.forResource("TestProfile.java"));
        assertThat(compilation).succeeded();
        assertThat(compilation).generatedFile(StandardLocation.CLASS_OUTPUT, "META-INF/profile-spec-jar.xml")
                .isEqualTo(JavaFileObjects.forResource("test-profile1.xml"));
    }
}

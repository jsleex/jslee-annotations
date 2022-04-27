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

import com.jsleex.annotation.processor.xml.common.*;
import com.jsleex.annotation.processor.xml.profile.*;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Set;

@SupportedAnnotationTypes(value = {"com.jsleex.annotation.ProfileSpec", "com.jsleex.annotation.ProfileSpecs"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ProfileSpecProcessor extends AbstractProcessor {
    private static final String OUTPUT_FILENAME = "META-INF/profile-spec-jar.xml";
    private static final String DOCTYPE = "<!DOCTYPE profile-spec-jar PUBLIC \"-//Sun Microsystems, Inc.//DTD JAIN SLEE Profile Specification 1.1//EN\""
            + " \"http://java.sun.com/dtd/slee-profile-spec-jar_1_1.dtd\">\n";
    private ProfileSpecJar profileSpecJar;
    private XmlFileWriter<ProfileSpecJar> xmlWriter;
    private AnnotationFinder annotationFinder;
    private ObjectFactory objectFactory = new ObjectFactory();

    private boolean isProfileSpecCreated;

    public ProfileSpecProcessor() {
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        try {
            this.xmlWriter = new XmlFileWriter<>(ProfileSpecJar.class, OUTPUT_FILENAME, DOCTYPE);
            this.profileSpecJar = objectFactory.createProfileSpecJar();
        } catch (JSleeXProcessorException e) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Unable to initialize processor.");
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
        for (TypeElement typeElement : annotations) {
            Set<? extends Element> elementSet = roundEnv.getElementsAnnotatedWith(typeElement);
            for (Element element : elementSet) {
                if (element.getKind().isClass() || element.getKind().isInterface()) {
                    com.jsleex.annotation.ProfileSpec profileSpecAnn = element.getAnnotation(com.jsleex.annotation.ProfileSpec.class);

                    ProfileSpec profileSpec = objectFactory.createProfileSpec();

                    if (!profileSpecAnn.description().isEmpty()) {
                        Description description = objectFactory.createDescription();
                        description.setvalue(profileSpecAnn.description());
                        profileSpec.setDescription(description);
                    }
                    ProfileSpecName profileName = objectFactory.createProfileSpecName();
                    profileName.setvalue(profileSpecAnn.name());
                    profileSpec.setProfileSpecName(profileName);
                    ProfileSpecVendor profileVendor = objectFactory.createProfileSpecVendor();
                    profileVendor.setvalue(profileSpecAnn.vendor());
                    profileSpec.setProfileSpecVendor(profileVendor);
                    ProfileSpecVersion profileVersion = objectFactory.createProfileSpecVersion();
                    profileVersion.setvalue(profileSpecAnn.version());
                    profileSpec.setProfileSpecVersion(profileVersion);

                    ProfileClasses profileClasses = objectFactory.createProfileClasses();
                    ProfileCmpInterface profileCmpInterface = objectFactory.createProfileCmpInterface();
                    ProfileCmpInterfaceName profileCmpInterfaceName = objectFactory.createProfileCmpInterfaceName();
                    profileCmpInterfaceName.setvalue(element.toString());
                    profileCmpInterface.setProfileCmpInterfaceName(profileCmpInterfaceName);
                    profileClasses.setProfileCmpInterface(profileCmpInterface);
                    //ugly
                    try {
                        profileSpecAnn.profileManagementInterfaceName();
                    } catch (MirroredTypeException mte) {
                        TypeMirror typeMirror = mte.getTypeMirror();
                        String className = typeMirror.toString();
                        if (!"java.lang.Class".equals(className)) {
                            ProfileManagementInterface profileManagementInterface = objectFactory.createProfileManagementInterface();
                            ProfileManagementInterfaceName profileManagementInterfaceName = objectFactory.createProfileManagementInterfaceName();
                            profileManagementInterfaceName.setvalue(typeMirror.toString());
                            profileManagementInterface.setProfileManagementInterfaceName(profileManagementInterfaceName);
                            profileClasses.setProfileManagementInterface(profileManagementInterface);
                        }
                    }
                    //ugly
                    try {
                        profileSpecAnn.profileManagementAbstractClassName();
                    } catch (MirroredTypeException mte) {
                        TypeMirror typeMirror = mte.getTypeMirror();
                        String className = typeMirror.toString();
                        if (!"java.lang.Class".equals(className)) {
                            ProfileAbstractClass profileAbstractClass = objectFactory.createProfileAbstractClass();
                            ProfileAbstractClassName profileAbstractClassName = objectFactory.createProfileAbstractClassName();
                            profileAbstractClassName.setvalue(typeMirror.toString());
                            profileAbstractClass.setProfileAbstractClassName(profileAbstractClassName);
                            profileClasses.setProfileAbstractClass(profileAbstractClass);
                        }
                    }
                    profileSpec.setProfileClasses(profileClasses);

                    profileSpecJar.getProfileSpec().add(profileSpec);
                    isProfileSpecCreated = true;

                    //todo
                    EnvEntriesFromElement envEntriesFromElement = new EnvEntriesFromElement(annotationFinder);
                    for (EnvEntry envEntry : envEntriesFromElement.generate(element)) {
                        profileSpec.getEnvEntry().add(envEntry);
                    }

                } else {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, element.getSimpleName() + " contains jsleeannotations.slee.ProfileSpec(s) annotation but is not class or interface.");
                }
            }
        }
        if (roundEnv.processingOver() && isProfileSpecCreated) {
            try {
                xmlWriter.write(processingEnv.getFiler(), profileSpecJar);
            } catch (JAXBException | IOException e) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Unable to write output file: " + OUTPUT_FILENAME);
            }
        }
        return true;

    }

}
/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;

import java.io.IOException;
import java.util.Set;

@SupportedAnnotationTypes(value = {"com.jsleex.annotation.ProfileSpec", "com.jsleex.annotation.ProfileSpecs"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ProfileSpecProcessor extends AbstractProcessor {
    private static final String OUTPUT_FILENAME = "META-INF/profile-spec-jar.xml";
    private static final String DOCTYPE_PUBLIC = "-//Sun Microsystems, Inc.//DTD JAIN SLEE Profile Specification 1.1//EN";
    private static final String DOCTYPE_SYSTEM = "http://java.sun.com/dtd/slee-profile-spec-jar_1_1.dtd";
    private XmlFileWriter xmlWriter;

    private DocumentBuilder builder;

    public ProfileSpecProcessor() {
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            this.builder = factory.newDocumentBuilder();
            this.xmlWriter = new XmlFileWriter(OUTPUT_FILENAME, DOCTYPE_PUBLIC, DOCTYPE_SYSTEM);
        } catch (JSleeXProcessorException | ParserConfigurationException e) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Unable to initialize processor.");
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        final Document doc = builder.newDocument();
        final org.w3c.dom.Element profileSpecJarElement = doc.createElement("profile-spec-jar");
        doc.appendChild(profileSpecJarElement);
        AnnotationFinder annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
        for (TypeElement typeElement : annotations) {
            Set<? extends Element> elementSet = roundEnv.getElementsAnnotatedWith(typeElement);
            for (Element element : elementSet) {
                if (element.getKind().isClass() || element.getKind().isInterface()) {
                    com.jsleex.annotation.ProfileSpec profileSpecAnn = element.getAnnotation(com.jsleex.annotation.ProfileSpec.class);
                    org.w3c.dom.Element profileSpec = doc.createElement("profile-spec");
                    if (!profileSpecAnn.description().isEmpty()) {
                        org.w3c.dom.Element description = doc.createElement("description");
                        description.setTextContent(profileSpecAnn.description());
                        profileSpec.appendChild(description);
                    }
                    org.w3c.dom.Element profileName = doc.createElement("profile-spec-name");
                    profileName.setTextContent(profileSpecAnn.name());
                    profileSpec.appendChild(profileName);
                    org.w3c.dom.Element profileVendor = doc.createElement("profile-spec-vendor");
                    profileVendor.setTextContent(profileSpecAnn.vendor());
                    profileSpec.appendChild(profileVendor);
                    org.w3c.dom.Element profileVersion = doc.createElement("profile-spec-version");
                    profileVersion.setTextContent(profileSpecAnn.version());
                    profileSpec.appendChild(profileVersion);
                    final LibraryRefsFromElement libraryRefsFromElement = new LibraryRefsFromElement(processingEnv, doc);
                    for (org.w3c.dom.Element libRefXmlElement: libraryRefsFromElement.generate(element)) {
                        profileSpec.appendChild(libRefXmlElement);
                    }
                    final ProfileSpecRefFromElement profileRefsFromElement = new ProfileSpecRefFromElement(processingEnv, doc);
                    for (org.w3c.dom.Element profRefXmlElement: profileRefsFromElement.generate(element)) {
                        profileSpec.appendChild(profRefXmlElement);
                    }
                    //todo collator
                    org.w3c.dom.Element profileClasses = doc.createElement("profile-classes");
                    org.w3c.dom.Element profileCmpInterface = doc.createElement("profile-cmp-interface");
                    org.w3c.dom.Element profileCmpInterfaceName = doc.createElement("profile-cmp-interface-name");
                    profileCmpInterfaceName.setTextContent(element.toString());
                    //todo cmp-field
                    profileCmpInterface.appendChild(profileCmpInterfaceName);
                    profileClasses.appendChild(profileCmpInterface);
                    //ugly
                    try {
                        profileSpecAnn.profileManagementInterfaceName();
                    } catch (MirroredTypeException mte) {
                        TypeMirror typeMirror = mte.getTypeMirror();
                        String className = typeMirror.toString();
                        if (!"java.lang.Class".equals(className)) {
                            org.w3c.dom.Element profileManagementInterface = doc.createElement("profile-management-interface");
                            org.w3c.dom.Element profileManagementInterfaceName = doc.createElement("profile-management-interface-name");
                            profileManagementInterfaceName.setTextContent(typeMirror.toString());
                            profileManagementInterface.appendChild(profileManagementInterfaceName);
                            profileClasses.appendChild(profileManagementInterface);
                        }
                    }
                    //ugly
                    try {
                        profileSpecAnn.profileManagementAbstractClassName();
                    } catch (MirroredTypeException mte) {
                        TypeMirror typeMirror = mte.getTypeMirror();
                        String className = typeMirror.toString();
                        if (!"java.lang.Class".equals(className)) {
                            org.w3c.dom.Element profileAbstractClass = doc.createElement("profile-abstract-class");
                            org.w3c.dom.Element profileAbstractClassName = doc.createElement("profile-abstract-class-name");
                            profileAbstractClassName.setTextContent(typeMirror.toString());
                            profileAbstractClass.appendChild(profileAbstractClassName);
                            profileClasses.appendChild(profileAbstractClass);
                        }
                    }
                    //todo profile-table-interface, profile-usage-parameters-interface
                    profileSpec.appendChild(profileClasses);
                    //todo
                    EnvEntriesFromElement envEntriesFromElement = new EnvEntriesFromElement(annotationFinder, doc);
                    for (org.w3c.dom.Element envEntry : envEntriesFromElement.generate(element)) {
                        profileSpec.appendChild(envEntry);
                    }
                    //todo query, profile-hints
                    profileSpecJarElement.appendChild(profileSpec);
                } else {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, element.getSimpleName() + " contains jsleeannotations.slee.ProfileSpec(s) annotation but is not class or interface.");
                }
            }
        }
        if (profileSpecJarElement.hasChildNodes()) {
            try {
                xmlWriter.write(processingEnv.getFiler(), doc);
            } catch (IOException | TransformerException e) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Unable to write output file: " + OUTPUT_FILENAME);
            }
        }
        return true;

    }

}
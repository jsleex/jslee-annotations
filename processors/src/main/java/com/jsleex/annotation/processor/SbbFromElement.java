/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import org.w3c.dom.Document;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;
import javax.slee.ActivityContextInterface;
import javax.slee.SbbLocalObject;
import javax.tools.Diagnostic;
import java.util.LinkedList;
import java.util.List;

public class SbbFromElement implements XmlFromElement {
    private final ProcessingEnvironment processingEnv;
    private final Document doc;

    public SbbFromElement(ProcessingEnvironment annotationFinder, Document doc) {
        this.processingEnv = annotationFinder;
        this.doc = doc;
    }

    @Override
    public List<org.w3c.dom.Element> generate(Element element) {
        List<org.w3c.dom.Element> sbbs = new LinkedList<>();
        if (element.getKind().isClass() && element.getModifiers().contains(Modifier.ABSTRACT)) {
            com.jsleex.annotation.Sbb sbbAnnotation = element.getAnnotation(com.jsleex.annotation.Sbb.class);
            org.w3c.dom.Element sbbElement = doc.createElement("sbb");
            fillInSbbComponentName(sbbAnnotation, sbbElement);
            fillInLibraryRefs(element, sbbElement);
            fillInSbbRefs(element, sbbElement);
            fillInProfileRefs(element, sbbElement);
            fillInSbbClasses(element, sbbAnnotation, sbbElement);
            fillInAddressProfileRef(sbbAnnotation, sbbElement);
            fillInEvents(element, sbbElement);
            fillInAciAttributeAliases(element, sbbElement);
            fillInEnvEntries(element, sbbElement);
            fillInRaBindings(element, sbbElement);
            fillInEjbRefs(element, sbbElement);

            sbbs.add(sbbElement);
        } else {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, element.getSimpleName() + " contains com.jsleex.annotation.Sbb annotation but it's not an abstract class.");
        }
        return sbbs;
    }

    private void fillInAciAttributeAliases(Element element, org.w3c.dom.Element sbb) {
        final AciAttributeAliasFromElement aciAttributeAliasFromElement = new AciAttributeAliasFromElement(processingEnv, doc);
        addChildElementsGeneratedByXmlFromElement(element, aciAttributeAliasFromElement, sbb);
    }

    private static void addChildElementsGeneratedByXmlFromElement(Element processedAnnotation, XmlFromElement xmlFromElementProcessor, org.w3c.dom.Element xmlElement) {
        for (org.w3c.dom.Element elementXml : xmlFromElementProcessor.generate(processedAnnotation)) {
            xmlElement.appendChild(elementXml);
        }
    }

    private void fillInEjbRefs(Element element, org.w3c.dom.Element sbb) {
        final EjbRefsFromElement ejbRefsFromElement = new EjbRefsFromElement(processingEnv, doc);
        addChildElementsGeneratedByXmlFromElement(element, ejbRefsFromElement, sbb);
    }

    private void fillInRaBindings(Element element, org.w3c.dom.Element sbb) {
        final ResourceAdaptorTypeRefsFromElement resourceAdaptorTypeRefsFromElement = new ResourceAdaptorTypeRefsFromElement(processingEnv, doc);
        addChildElementsGeneratedByXmlFromElement(element, resourceAdaptorTypeRefsFromElement, sbb);
    }

    private void fillInAddressProfileRef(com.jsleex.annotation.Sbb sbbAnnotation, org.w3c.dom.Element sbb) {
        if (!sbbAnnotation.addressProfileSpecAliasRef().isEmpty()) {
            final org.w3c.dom.Element addressProfileSpecAliasRef = doc.createElement("address-profile-spec-alias-ref");
            addressProfileSpecAliasRef.setTextContent(sbbAnnotation.addressProfileSpecAliasRef());
            sbb.appendChild(addressProfileSpecAliasRef);
        }
    }

    private void fillInLibraryRefs(Element element, org.w3c.dom.Element sbb) {
        final LibraryRefsFromElement libraryRefsFromElement = new LibraryRefsFromElement(processingEnv, doc);
        addChildElementsGeneratedByXmlFromElement(element, libraryRefsFromElement, sbb);
    }

    private void fillInEvents(Element element, org.w3c.dom.Element sbb) {
        final EventsFromElement eventsFromElement = new EventsFromElement(processingEnv, doc);
        addChildElementsGeneratedByXmlFromElement(element, eventsFromElement, sbb);
    }

    private void fillInProfileRefs(Element element, org.w3c.dom.Element sbb) {
        final ProfileSpecRefFromElement profileSpecRefFromElement = new ProfileSpecRefFromElement(processingEnv, doc);
        addChildElementsGeneratedByXmlFromElement(element, profileSpecRefFromElement, sbb);
    }

    private void fillInEnvEntries(Element element, org.w3c.dom.Element sbb) {
        final EnvEntriesFromElement envEntriesFromElement = new EnvEntriesFromElement(new AnnotationFinder(processingEnv.getTypeUtils()), doc);
        addChildElementsGeneratedByXmlFromElement(element, envEntriesFromElement, sbb);
    }

    private void fillInSbbRefs(Element element, org.w3c.dom.Element sbb) {
        for (com.jsleex.annotation.SbbRef sbbRefAnnotation : element.getAnnotationsByType(com.jsleex.annotation.SbbRef.class)) {
            final org.w3c.dom.Element sbbRef = doc.createElement("sbb-ref");
            final org.w3c.dom.Element sbbName = doc.createElement("sbb-name");
            sbbName.setTextContent(sbbRefAnnotation.name());
            sbbRef.appendChild(sbbName);
            final org.w3c.dom.Element sbbVendor = doc.createElement("sbb-vendor");
            sbbVendor.setTextContent(sbbRefAnnotation.vendor());
            sbbRef.appendChild(sbbVendor);
            final org.w3c.dom.Element sbbVersion = doc.createElement("sbb-version");
            sbbVersion.setTextContent(sbbRefAnnotation.version());
            sbbRef.appendChild(sbbVersion);
            final org.w3c.dom.Element sbbAlias = doc.createElement("sbb-alias");
            sbbAlias.setTextContent(sbbRefAnnotation.alias());
            sbbRef.appendChild(sbbAlias);
            sbb.appendChild(sbbRef);
        }
    }

//<!ELEMENT sbb-classes (description?, sbb-abstract-class, sbb-local-interface?,
//                       sbb-activity-context-interface?, sbb-usage-parameters-interface?)>
    private void fillInSbbClasses(Element element, com.jsleex.annotation.Sbb sbbAnnotation, org.w3c.dom.Element sbb) {
        final org.w3c.dom.Element sbbClasses = doc.createElement("sbb-classes");
        fillInSbbAbstractClass(element, sbbAnnotation, sbbClasses);
        fillInSbbLocalInterface(sbbAnnotation, sbbClasses);
        fillInSbbUsageParametersInterface(sbbAnnotation, sbbClasses);
        fillInSbbActivityContextInterface(sbbAnnotation, sbbClasses);
        sbb.appendChild(sbbClasses);
    }

    private void fillInSbbActivityContextInterface(com.jsleex.annotation.Sbb sbbAnnotation, org.w3c.dom.Element sbbClasses) {
        //ugly
        try {
            sbbAnnotation.sbbActivityContextInterfaceName();
        } catch (MirroredTypeException mte) {
            final TypeMirror typeMirror = mte.getTypeMirror();
            final String className = typeMirror.toString();
            if (!className.equals(ActivityContextInterface.class.getCanonicalName())) {
                final org.w3c.dom.Element sbbActivityContextInterface = doc.createElement("sbb-activity-context-interface");
                final org.w3c.dom.Element description = doc.createElement("description");
                description.setTextContent(sbbAnnotation.sbbActivityContextInterfaceDescription());
                sbbActivityContextInterface.appendChild(description);
                final org.w3c.dom.Element sbbActivityContextInterfaceName = doc.createElement("sbb-activity-context-interface-name");
                sbbActivityContextInterfaceName.setTextContent(className);
                sbbActivityContextInterface.appendChild(sbbActivityContextInterfaceName);
                sbbClasses.appendChild(sbbActivityContextInterface);
            }
        }
    }

    private void fillInSbbAbstractClass(Element element, com.jsleex.annotation.Sbb sbbAnnotation, org.w3c.dom.Element sbbClasses) {
        final org.w3c.dom.Element sbbAbstractClass = doc.createElement("sbb-abstract-class");
        final org.w3c.dom.Element sbbAbstractClassName = doc.createElement("sbb-abstract-class-name");
        sbbAbstractClassName.setTextContent(element.toString());
        sbbAbstractClass.appendChild(sbbAbstractClassName);
        if (sbbAnnotation.reentrant()) {
            sbbAbstractClass.setAttribute("reentrant", "True");
        }
        final CmpFromElement cmpFromElement = new CmpFromElement(processingEnv, doc);
        addChildElementsGeneratedByXmlFromElement(element, cmpFromElement, sbbAbstractClass);
        final ChildRelationFromElement childRelationFromElement = new ChildRelationFromElement(processingEnv, doc);
        addChildElementsGeneratedByXmlFromElement(element, childRelationFromElement, sbbAbstractClass);
        final ProfileCmpFromElement profileCmpFromElement = new ProfileCmpFromElement(processingEnv, doc);
        addChildElementsGeneratedByXmlFromElement(element, profileCmpFromElement, sbbAbstractClass);
        sbbClasses.appendChild(sbbAbstractClass);
    }

    private void fillInSbbComponentName(com.jsleex.annotation.Sbb sbbAnnotation, org.w3c.dom.Element sbb) {
        final org.w3c.dom.Element sbbName = doc.createElement("sbb-name");
        sbbName.setTextContent(sbbAnnotation.name());
        sbb.appendChild(sbbName);
        final org.w3c.dom.Element sbbVendor = doc.createElement("sbb-vendor");
        sbbVendor.setTextContent(sbbAnnotation.vendor());
        sbb.appendChild(sbbVendor);
        final org.w3c.dom.Element sbbVersion = doc.createElement("sbb-version");
        sbbVersion.setTextContent(sbbAnnotation.version());
        sbb.appendChild(sbbVersion);
    }

    private void fillInSbbUsageParametersInterface(com.jsleex.annotation.Sbb sbbAnnotation, org.w3c.dom.Element sbbClasses) {
        //ugly
        try {
            sbbAnnotation.sbbUsageParameterInterfaceName();
        } catch (MirroredTypeException mte) {
            final TypeMirror typeMirror = mte.getTypeMirror();
            final String className = typeMirror.toString();
            if (!className.equals(void.class.getCanonicalName())) {
                final org.w3c.dom.Element sbbUsageParametersInterface = doc.createElement("sbb-usage-parameters-interface");
                //todo separate usage parameters
                final org.w3c.dom.Element interfaceName = doc.createElement("sbb-usage-parameters-interface-name");
                interfaceName.setTextContent(className);
                sbbUsageParametersInterface.appendChild(interfaceName);
                sbbClasses.appendChild(sbbUsageParametersInterface);
            }
        }
    }

    private void fillInSbbLocalInterface(com.jsleex.annotation.Sbb sbbAnnotation, org.w3c.dom.Element sbbClasses) {
        //ugly
        try {
            sbbAnnotation.sbbLocalInterfaceName();
        } catch (MirroredTypeException mte) {
            final TypeMirror typeMirror = mte.getTypeMirror();
            final String className = typeMirror.toString();
            if (!SbbLocalObject.class.getCanonicalName().equals(className)) {
                final org.w3c.dom.Element sbbLocalInterface = doc.createElement("sbb-local-interface");
                final org.w3c.dom.Element sbbLocalInterfaceName = doc.createElement("sbb-local-interface-name");
                sbbLocalInterfaceName.setTextContent(className);
                sbbLocalInterface.appendChild(sbbLocalInterfaceName);
                sbbClasses.appendChild(sbbLocalInterface);
            }
        }
    }
}

package com.jsleex.annotation.processor;

import com.jsleex.annotation.ProfileSpecRef;
import com.jsleex.annotation.ProfileSpecRefs;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ProfileSpecRefFromElement implements XmlFromElement<com.jsleex.annotation.processor.xml.sbb.ProfileSpecRef, ProfileSpecRef> {
    private final ProcessingEnvironment processingEnv;

    public ProfileSpecRefFromElement(ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
    }

    @Override
    public List<com.jsleex.annotation.processor.xml.sbb.ProfileSpecRef> generate(Element element) {
        final List<com.jsleex.annotation.processor.xml.sbb.ProfileSpecRef> profileSpecRefs = new LinkedList<>();
        final AnnotationFinder annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
        annotationFinder.findAllAnnotationsOnType(element, ProfileSpecRef.class)
                .values().stream().flatMap( a -> a.stream()).map(ProfileSpecRefTransform::toXml).forEachOrdered(profileSpecRefs::add);
        annotationFinder.findAllAnnotationsOnType(element, ProfileSpecRefs.class)
                .values().stream().flatMap( a -> a.stream()).flatMap( b -> Arrays.stream(b.value()))
                .map(ProfileSpecRefTransform::toXml).forEachOrdered(profileSpecRefs::add);
        return profileSpecRefs;
    }
}

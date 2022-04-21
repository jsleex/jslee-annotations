package com.jsleex.annotation.processor;


import com.jsleex.annotation.EjbRef;
import com.jsleex.annotation.EjbRefs;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EjbRefsFromElement implements XmlFromElement<com.jsleex.annotation.processor.xml.sbb.EjbRef, EjbRef> {
    private final ProcessingEnvironment processingEnv;

    public EjbRefsFromElement(ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
    }

    @Override
    public List<com.jsleex.annotation.processor.xml.sbb.EjbRef> generate(Element element) {
        final List<com.jsleex.annotation.processor.xml.sbb.EjbRef> ejbRefs = new LinkedList<>();
        final AnnotationFinder annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
        annotationFinder.findAllAnnotationsOnType(element, EjbRef.class)
                .values().stream().flatMap( a -> a.stream()).map(EjbRefTransform::toXml).forEachOrdered(ejbRefs::add);
        annotationFinder.findAllAnnotationsOnType(element, EjbRefs.class)
                .values().stream().flatMap( a -> a.stream()).flatMap( b -> Arrays.stream(b.value()))
                .map(EjbRefTransform::toXml).forEachOrdered(ejbRefs::add);
        return ejbRefs;
    }
}

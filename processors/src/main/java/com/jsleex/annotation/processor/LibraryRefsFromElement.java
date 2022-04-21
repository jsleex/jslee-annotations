package com.jsleex.annotation.processor;

import com.jsleex.annotation.LibraryRef;
import com.jsleex.annotation.LibraryRefs;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LibraryRefsFromElement implements XmlFromElement<com.jsleex.annotation.processor.xml.common.LibraryRef, LibraryRef>{
    private final ProcessingEnvironment processingEnv;

    public LibraryRefsFromElement(ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
    }

    @Override
    public List<com.jsleex.annotation.processor.xml.common.LibraryRef> generate(Element element) {
        final List<com.jsleex.annotation.processor.xml.common.LibraryRef> libraryRefs = new LinkedList<>();
        final AnnotationFinder annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
        annotationFinder.findAllAnnotationsOnType(element, LibraryRef.class)
                .values().stream().flatMap( a -> a.stream()).map(LibraryRefTransform::toXml).forEachOrdered(libraryRefs::add);
        annotationFinder.findAllAnnotationsOnType(element, LibraryRefs.class)
                .values().stream().flatMap( a -> a.stream()).flatMap( b -> Arrays.stream(b.value()))
                .map(LibraryRefTransform::toXml).forEachOrdered(libraryRefs::add);
        return libraryRefs;
    }
}

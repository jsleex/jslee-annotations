package com.jsleex.annotation.processor;

import com.jsleex.annotation.LibraryRef;
import com.jsleex.annotation.LibraryRefs;
import com.jsleex.annotation.RaTypeBinding;
import com.jsleex.annotation.RaTypeBindings;
import com.jsleex.annotation.processor.xml.sbb.ResourceAdaptorTypeBinding;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ResourceAdaptorTypeRefsFromElement implements XmlFromElement<ResourceAdaptorTypeBinding, RaTypeBinding>{
    private final ProcessingEnvironment processingEnv;

    public ResourceAdaptorTypeRefsFromElement(ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
    }

    @Override
    public List<ResourceAdaptorTypeBinding> generate(Element element) {
        final List<ResourceAdaptorTypeBinding> resourceAdaptorTypeRefs = new LinkedList<>();
        final AnnotationFinder annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
        annotationFinder.findAllAnnotationsOnType(element, RaTypeBinding.class)
                .values().stream().flatMap( a -> a.stream()).map(RaTypeBindingTransform::toXml).forEachOrdered(resourceAdaptorTypeRefs::add);
        annotationFinder.findAllAnnotationsOnType(element, RaTypeBindings.class)
                .values().stream().flatMap( a -> a.stream()).flatMap( b -> Arrays.stream(b.value()))
                .map(RaTypeBindingTransform::toXml).forEachOrdered(resourceAdaptorTypeRefs::add);
        return resourceAdaptorTypeRefs;
    }
}

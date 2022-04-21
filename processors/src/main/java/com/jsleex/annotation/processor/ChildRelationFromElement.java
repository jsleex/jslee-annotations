package com.jsleex.annotation.processor;

import com.jsleex.annotation.ChildRelationMethod;
import com.jsleex.annotation.processor.xml.sbb.GetChildRelationMethod;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ChildRelationFromElement implements XmlFromElement<GetChildRelationMethod, ChildRelationMethod> {
    private final ProcessingEnvironment processingEnv;
    private final AnnotationFinder annotationFinder;

    public ChildRelationFromElement(ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
        this.annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
    }

    @Override
    public List<GetChildRelationMethod> generate(Element element) {
        List<GetChildRelationMethod> childRelationMethods = new LinkedList<>();
        annotationFinder.findAllAnnotationsOnTypeMethods(element, ChildRelationMethod.class).entrySet().stream().map(
                (a) -> ChildRelationMethodTransform.toXml(a.getValue(), a.getKey())
        ).filter((a) -> a.isPresent()).map(Optional::get).forEachOrdered(childRelationMethods::add);
        return childRelationMethods.stream().distinct().collect(Collectors.toList());
    }
}

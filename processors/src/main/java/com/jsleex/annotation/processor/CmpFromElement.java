package com.jsleex.annotation.processor;

import com.jsleex.annotation.CmpMethod;
import com.jsleex.annotation.processor.xml.sbb.CmpField;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CmpFromElement implements XmlFromElement<CmpField, CmpMethod> {
    private final AnnotationFinder annotationFinder;

    public CmpFromElement(ProcessingEnvironment processingEnv) {
        this.annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
    }

    @Override
    public List<CmpField> generate(Element element) {
        List<CmpField> cmpFields = new LinkedList<>();
        annotationFinder.findAllAnnotationsOnTypeMethods(element, CmpMethod.class).entrySet().stream().map(
                (a) -> CmpTransform.toXml(a.getValue(), a.getKey())
        ).filter((a) -> a.isPresent()).map(Optional::get).forEachOrdered(cmpFields::add);
        return cmpFields.stream().distinct().collect(Collectors.toList());
    }
}

package com.jsleex.annotation.processor;

import com.jsleex.annotation.SbbActivityContextAttributeAlias;
import com.jsleex.annotation.SbbActivityContextAttributeAliases;
import com.jsleex.annotation.processor.xml.sbb.ActivityContextAttributeAlias;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AciAttributeAliasFromElement implements XmlFromElement<ActivityContextAttributeAlias, SbbActivityContextAttributeAlias> {
    private final ProcessingEnvironment processingEnv;

    public AciAttributeAliasFromElement(ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
    }

    @Override
    public List<ActivityContextAttributeAlias> generate(Element element) {
        final List<com.jsleex.annotation.processor.xml.sbb.ActivityContextAttributeAlias> sbbActivityContextAttributeAliases = new LinkedList<>();
        final AnnotationFinder annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
        annotationFinder.findAllAnnotationsOnType(element, SbbActivityContextAttributeAlias.class)
                .values().stream().flatMap( a -> a.stream()).map(AciAttributeAliasTransform::toXml).forEachOrdered(sbbActivityContextAttributeAliases::add);
        annotationFinder.findAllAnnotationsOnType(element, SbbActivityContextAttributeAliases.class)
                .values().stream().flatMap( a -> a.stream()).flatMap( b -> Arrays.stream(b.value()))
                .map(AciAttributeAliasTransform::toXml).forEachOrdered(sbbActivityContextAttributeAliases::add);
        return sbbActivityContextAttributeAliases;
    }
}

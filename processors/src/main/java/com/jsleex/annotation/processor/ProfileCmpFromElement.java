package com.jsleex.annotation.processor;

import com.jsleex.annotation.ProfileCmpMethod;
import com.jsleex.annotation.processor.xml.sbb.GetProfileCmpMethod;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import java.util.Collections;
import java.util.List;

public class ProfileCmpFromElement implements XmlFromElement<GetProfileCmpMethod, ProfileCmpMethod> {

    private final ProcessingEnvironment processingEnv;

    public ProfileCmpFromElement(ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
    }

    @Override
    public List<GetProfileCmpMethod> generate(Element element) {
        //todo
        return Collections.emptyList();
    }
}

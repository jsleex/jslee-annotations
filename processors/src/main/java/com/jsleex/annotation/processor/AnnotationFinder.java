/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Types;
import java.lang.annotation.Annotation;
import java.util.*;

class AnnotationFinder {
    private final Types types;

    AnnotationFinder(Types types) {
        this.types = types;
    }

    <A extends Annotation> Map<Element, List<A>> findAllAnnotationsOnType(Element element, Class<A> annotation) {
        Map<Element, List<A>> elementListMap = new LinkedHashMap<>();
        if (element.getKind().isClass() || element.getKind().isInterface()) {
            TypeElement typeElement = (TypeElement) element;
            addAllAnnotations(elementListMap, typeElement, annotation);
        }
        return elementListMap;
    }

    private <A extends Annotation> void addAllAnnotations(Map<Element, List<A>> elementListMap, TypeElement element, Class<A> annotation) {
        A foundAnnotation = element.getAnnotation(annotation);
        if (foundAnnotation != null) {
            addToElementListMap(elementListMap, element, foundAnnotation);
        }
        addAnnotationsOnInterfaces(elementListMap, element, annotation);
        TypeMirror typeMirror = element.getSuperclass();
        if (typeMirror.getKind().equals(TypeKind.DECLARED)) {
            TypeElement superElement = (TypeElement) types.asElement(typeMirror);
            addAllAnnotations(elementListMap, superElement, annotation);
        }
    }

    <A extends Annotation> A findClassOrInterfaceAnnotation(Element element, Class<A> annotation) {
        if (element.getKind().isClass() || element.getKind().isInterface()) {
            TypeElement typeElement = (TypeElement) element;
            return findClassOrInterfaceAnnotation(typeElement, annotation);
        }
        return null;
    }

    private <A extends Annotation> void addToElementListMap(Map<Element, List<A>> elementListMap, Element element, A foundAnnotation) {
        List<A> list;
        if (elementListMap.containsKey(element)) {
            list = elementListMap.get(element);
        } else {
            list = new LinkedList<>();
            elementListMap.put(element, list);
        }
        list.add(foundAnnotation);
    }

    private <A extends Annotation> A findClassOrInterfaceAnnotation(TypeElement element, Class<A> annotation) {
        A returnedAnnotation = element.getAnnotation(annotation);
        if (returnedAnnotation == null) {
            if (element.getKind().isClass() || element.getKind().isInterface()) {
                returnedAnnotation = findAnnotationOnInterfaces(element, annotation);
                if (returnedAnnotation != null) {
                    return returnedAnnotation;
                }
                TypeMirror typeMirror = element.getSuperclass();
                if (typeMirror.getKind().equals(TypeKind.DECLARED)) {
                    TypeElement typeElement = (TypeElement) types.asElement(typeMirror);
                    return findClassOrInterfaceAnnotation(typeElement, annotation);
                }
            }
        }
        return returnedAnnotation;
    }

    <A extends Annotation> A findAnnotationOnInterfaces(TypeElement typeElement, Class<A> annotation) {
        for (TypeMirror typeMirror : typeElement.getInterfaces()) {
            if (typeMirror.getKind().equals(TypeKind.DECLARED)) {
                TypeElement element = (TypeElement) types.asElement(typeMirror);
                A returnedAnnotation = findClassOrInterfaceAnnotation(element, annotation);
                if (returnedAnnotation != null) {
                    return returnedAnnotation;
                }
            }
        }
        return null;
    }

    <A extends Annotation> void addAnnotationsOnInterfaces(Map<Element, List<A>> elementListMap, TypeElement typeElement, Class<A> annotation) {
        for (TypeMirror typeMirror : typeElement.getInterfaces()) {
            if (typeMirror.getKind().equals(TypeKind.DECLARED)) {
                TypeElement element = (TypeElement) types.asElement(typeMirror);
                addAllAnnotations(elementListMap, element, annotation);
            }
        }
    }

    <A extends Annotation> Map<Element, A> findAllAnnotationsOnTypeMethods(Element element, Class<A> annotation) {
        final Map<Element, A> map = new LinkedHashMap<>();
        if (element.getKind().isClass() || element.getKind().isInterface()) {
            TypeElement typeElement = (TypeElement) element;
            addMethodsAnnotationsMatching(typeElement, annotation, map);
            addMethodsAnnotationsOnInterfaces(typeElement, annotation, map);
            final TypeMirror typeMirror = typeElement.getSuperclass();
            if (typeMirror.getKind().equals(TypeKind.DECLARED)) {
                TypeElement superclassTypeElement = (TypeElement) types.asElement(typeMirror);
                map.putAll(findAllAnnotationsOnTypeMethods(superclassTypeElement, annotation));
            }
        }
        return map;
    }

    private <A extends Annotation> void addMethodsAnnotationsMatching(TypeElement typeElement, Class<A> annotation, Map<Element, A> map) {
        typeElement.getEnclosedElements().stream().filter(a -> ElementKind.METHOD.equals(a.getKind())).forEachOrdered(
                a -> {
                    A methodAnnotation = a.getAnnotation(annotation);
                    if (methodAnnotation != null) {
                        map.put(a, methodAnnotation);
                    }
                }
        );
    }

    <A extends Annotation> void addMethodsAnnotationsOnInterfaces(TypeElement typeElement, Class<A> annotation, Map<Element, A> elementListMap) {
        typeElement.getInterfaces().stream().filter((a) -> a.getKind().equals(TypeKind.DECLARED))
                .map((a) -> (TypeElement) types.asElement(a))
                .forEachOrdered((a) -> elementListMap.putAll(findAllAnnotationsOnTypeMethods(a, annotation)));
    }
}

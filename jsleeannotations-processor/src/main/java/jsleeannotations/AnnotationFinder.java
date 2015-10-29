/*
 * JSLEE Annotations
 * Copyright (c) 2015 Piotr Grabowski, All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */

package jsleeannotations;

import javax.lang.model.element.Element;
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
        A returnedAnnotation = null;
        for (TypeMirror typeMirror : typeElement.getInterfaces()) {
            if (typeMirror.getKind().equals(TypeKind.DECLARED)) {
                TypeElement element = (TypeElement) types.asElement(typeMirror);
                returnedAnnotation = findClassOrInterfaceAnnotation(element, annotation);

            }
            if (returnedAnnotation != null) {
                return returnedAnnotation;
            }
        }
        return returnedAnnotation;
    }

    <A extends Annotation> void addAnnotationsOnInterfaces(Map<Element, List<A>> elementListMap, TypeElement typeElement, Class<A> annotation) {
        for (TypeMirror typeMirror : typeElement.getInterfaces()) {
            if (typeMirror.getKind().equals(TypeKind.DECLARED)) {
                TypeElement element = (TypeElement) types.asElement(typeMirror);
                addAllAnnotations(elementListMap, element, annotation);
            }
        }
    }
}

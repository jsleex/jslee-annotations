/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.EventMethod;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EventsFromElement implements XmlFromElement {

    private static final String EVENT_DIRECTION_FIRE_AND_RECEIVE = "FireAndReceive";
    private final ProcessingEnvironment processingEnv;
    private final Document doc;

    public EventsFromElement(ProcessingEnvironment processingEnv, Document doc) {
        this.processingEnv = processingEnv;
        this.doc = doc;
    }

    @Override
    public List<org.w3c.dom.Element> generate(Element element) {
        final AnnotationFinder annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
        return new ArrayList<>(new ArrayList<>(annotationFinder.findAllAnnotationsOnTypeMethods(element, EventMethod.class).entrySet().stream().map(
                        (a) -> EventMethodTransform.toXml(a.getValue(), a.getKey(), doc)
                ).filter(Optional::isPresent).map(Optional::get)
                .collect(Collectors.toMap((a) -> a.getElementsByTagName("event-name").item(0).getTextContent(), Function.identity(), this::mergeEvents)).values()));
    }

    private org.w3c.dom.Element mergeEvents(org.w3c.dom.Element eventA, org.w3c.dom.Element eventB) {
        final org.w3c.dom.Element event = eventA.getOwnerDocument().createElement("event");
        if (!eventA.getAttribute("initial-event").isEmpty()) {
            event.setAttribute("initial-event", eventA.getAttribute("initial-event"));
        }
        // if event directions are different merge into a single `FireAndReceive`
        if (!eventA.getAttribute("event-direction").equals(eventB.getAttribute("event-direction"))) {
            event.setAttribute("event-direction", EVENT_DIRECTION_FIRE_AND_RECEIVE);
        } else {
            event.setAttribute("event-direction", eventA.getAttribute("event-direction"));
        }
        if (!eventA.getAttribute("mask-on-attach").isEmpty()) {
            event.setAttribute("mask-on-attach", eventA.getAttribute("mask-on-attach"));
        }
        if (!eventA.getAttribute("last-in-transaction").isEmpty()) {
            event.setAttribute("last-in-transaction", eventA.getAttribute("last-in-transaction"));
        }
        final NodeList eventNameElements = eventA.getElementsByTagName("event-name");
        while (eventNameElements.getLength() > 0) {
            event.appendChild(eventNameElements.item(0));
        }
        final NodeList eventTypeRefElements = eventA.getElementsByTagName("event-type-ref");
        while (eventTypeRefElements.getLength() > 0) {
            event.appendChild(eventTypeRefElements.item(0));
        }
        if (eventA.getElementsByTagName("initial-event-select").getLength() > 0) {
            final NodeList elements = eventA.getElementsByTagName("initial-event-select");
            while (elements.getLength() > 0) {
                event.appendChild(elements.item(0));
            }
        } else {
            final NodeList elements = eventB.getElementsByTagName("initial-event-select");
            while (elements.getLength() > 0) {
                event.appendChild(elements.item(0));
            }
        }
        if (eventA.getElementsByTagName("initial-event-selector-method-name").getLength() > 0) {
            final NodeList elements = eventA.getElementsByTagName("initial-event-selector-method-name");
            while (elements.getLength() > 0) {
                event.appendChild(elements.item(0));
            }
        } else {
            final NodeList elements = eventB.getElementsByTagName("initial-event-selector-method-name");
            while (elements.getLength() > 0) {
                event.appendChild(elements.item(0));
            }
        }
        if (eventA.getElementsByTagName("event-resource-option").getLength() > 0) {
            final NodeList elements = eventA.getElementsByTagName("event-resource-option");
            while (elements.getLength() > 0) {
                event.appendChild(elements.item(0));
            }
        } else {
            final NodeList elements = eventB.getElementsByTagName("event-resource-option");
            while (elements.getLength() > 0) {
                event.appendChild(elements.item(0));
            }
        }
        return event;
    }
}

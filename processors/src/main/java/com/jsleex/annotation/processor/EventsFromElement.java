package com.jsleex.annotation.processor;

import com.jsleex.annotation.EventMethod;
import com.jsleex.annotation.processor.xml.sbb.Event;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import java.util.*;
import java.util.stream.Collectors;

public class EventsFromElement implements XmlFromElement<Event, EventMethod> {

    private static final String EVENT_DIRECTION_FIRE_AND_RECEIVE = "FireAndReceive";
    private final ProcessingEnvironment processingEnv;

    public EventsFromElement(ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
    }

    @Override
    public List<Event> generate(Element element) {
        final AnnotationFinder annotationFinder = new AnnotationFinder(processingEnv.getTypeUtils());
        return annotationFinder.findAllAnnotationsOnTypeMethods(element, EventMethod.class).entrySet().stream().map(
                    (a) -> EventMethodTransform.toXml(a.getValue(), a.getKey())
                ).filter((a) -> a.isPresent()).map(Optional::get)
                .collect(Collectors.groupingBy(Event::getEventName,
                        Collectors.collectingAndThen(
                                Collectors.reducing((a,b) -> mergeEvents(a,b)), Optional::get))).values()
                .stream().collect(Collectors.toList());
    }

    private Event mergeEvents(Event eventA, Event eventB) {
        // if event directions are different merge into a single `FireAndReceive`
        if (!eventA.getEventDirection().equals(eventB.getEventDirection())) {
            eventA.setEventDirection(EVENT_DIRECTION_FIRE_AND_RECEIVE);
        }
        if (eventA.getEventResourceOption() == null) {
            eventA.setEventResourceOption(eventB.getEventResourceOption());
        }
        if (eventA.getInitialEventSelectorMethodName() == null) {
            eventA.setInitialEventSelectorMethodName(eventB.getInitialEventSelectorMethodName());
        }
        eventA.getInitialEventSelect().addAll(eventB.getInitialEventSelect());
        return eventA;
    }
}

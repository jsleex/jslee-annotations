package com.jsleex.annotation.processor;

import com.jsleex.annotation.EventMethod;
import com.jsleex.annotation.processor.xml.common.EventTypeName;
import com.jsleex.annotation.processor.xml.common.EventTypeRef;
import com.jsleex.annotation.processor.xml.common.EventTypeVendor;
import com.jsleex.annotation.processor.xml.common.EventTypeVersion;
import com.jsleex.annotation.processor.xml.sbb.*;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import java.util.Optional;

public class EventMethodTransform {

    public static final String EVENT_RECEIVE_METHOD_PREFIX = "on";
    public static final String EVENT_FIRE_METHOD_PREFIX = "fire";
    public static final String EVENT_DIRECTION_FIRE = "Fire";
    public static final String EVENT_DIRECTION_RECEIVE = "Receive";

    public static Optional<com.jsleex.annotation.processor.xml.sbb.Event> toXml(EventMethod eventMethod, Element element) {
        if (ElementKind.METHOD.equals(element.getKind())) {
            final com.jsleex.annotation.processor.xml.sbb.Event eventXml = new com.jsleex.annotation.processor.xml.sbb.Event();
            // initial
            if (eventMethod.initialEvent()) {
                eventXml.setInitialEvent("True");
            }
            // direction
            final boolean isFire = element.getSimpleName().toString().startsWith(EVENT_FIRE_METHOD_PREFIX);
            if (!isFire && !element.getSimpleName().toString().startsWith(EVENT_RECEIVE_METHOD_PREFIX)) {
                //throw new JSleeXProcessorException("Event method doesn't start with `on` or `fire`, method name: " + element.getSimpleName().toString());
                return Optional.empty();
            }
            eventXml.setEventDirection(isFire ? EVENT_DIRECTION_FIRE : EVENT_DIRECTION_RECEIVE);
            // mask on attach
            if (eventMethod.maskOnAttach()) {
                eventXml.setMaskOnAttach("True");
            }
            // last in transaction
            if (!eventMethod.lastInTransaction()) {
                eventXml.setLastInTransaction("False");
            }
            // description
            // event type ref
            fillInEventTypeRef(eventMethod, eventXml);
            // event name
            final EventName eventName = new EventName();
            eventName.setvalue(isFire ? element.getSimpleName().toString().substring(EVENT_FIRE_METHOD_PREFIX.length())
                                        : element.getSimpleName().toString().substring(EVENT_RECEIVE_METHOD_PREFIX.length()));
            eventXml.setEventName(eventName);
            // initial event select
            // ies variable
            for (EventMethod.InitialEventSelectVariable initialEventSelectVariable : eventMethod.initialEventSelectVariable()) {
                final InitialEventSelect initialEventSelect = new InitialEventSelect();
                initialEventSelect.setVariable(initialEventSelectVariable.toString());
                eventXml.getInitialEventSelect().add(initialEventSelect);
            }
            // ies method
            if (!eventMethod.initialEventSelectorMethodName().isEmpty()) {
                final InitialEventSelectorMethodName initialEventSelectorMethodName = new InitialEventSelectorMethodName();
                initialEventSelectorMethodName.setvalue(eventMethod.initialEventSelectorMethodName());
                eventXml.setInitialEventSelectorMethodName(initialEventSelectorMethodName);
            }
            // ies event resource option
            if (!eventMethod.eventResourceOption().isEmpty()) {
                final EventResourceOption eventResourceOption = new EventResourceOption();
                eventResourceOption.setvalue(eventMethod.eventResourceOption());
                eventXml.setEventResourceOption(eventResourceOption);
            }
            return Optional.of(eventXml);
        }
        return Optional.empty();
    }

    private static void fillInEventTypeRef(EventMethod eventMethod, Event eventXml) {
        final EventTypeRef eventTypeRef = new EventTypeRef();
        final EventTypeName eventTypeName = new EventTypeName();
        eventTypeName.setvalue(eventMethod.eventTypeName());
        eventTypeRef.setEventTypeName(eventTypeName);
        final EventTypeVendor eventTypeVendor = new EventTypeVendor();
        eventTypeVendor.setvalue(eventMethod.eventTypeVendor());
        eventTypeRef.setEventTypeVendor(eventTypeVendor);
        final EventTypeVersion eventTypeVersion = new EventTypeVersion();
        eventTypeVersion.setvalue(eventMethod.eventTypeVersion());
        eventTypeRef.setEventTypeVersion(eventTypeVersion);
        eventXml.setEventTypeRef(eventTypeRef);
    }
}

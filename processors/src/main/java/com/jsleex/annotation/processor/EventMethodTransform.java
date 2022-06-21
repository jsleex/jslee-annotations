/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.EventMethod;
import org.w3c.dom.Document;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import java.util.Optional;

public class EventMethodTransform {

    public static final String EVENT_RECEIVE_METHOD_PREFIX = "on";
    public static final String EVENT_FIRE_METHOD_PREFIX = "fire";
    public static final String EVENT_DIRECTION_FIRE = "Fire";
    public static final String EVENT_DIRECTION_RECEIVE = "Receive";

    public static Optional<org.w3c.dom.Element> toXml(EventMethod eventMethod, Element element, Document doc) {
        if (ElementKind.METHOD.equals(element.getKind())) {
            final org.w3c.dom.Element eventXml = doc.createElement("event");
            // initial
            if (eventMethod.initialEvent()) {
                eventXml.setAttribute("initial-event", "True");
            }
            // direction
            final boolean isFire = element.getSimpleName().toString().startsWith(EVENT_FIRE_METHOD_PREFIX);
            if (!isFire && !element.getSimpleName().toString().startsWith(EVENT_RECEIVE_METHOD_PREFIX)) {
                //throw new JSleeXProcessorException("Event method doesn't start with `on` or `fire`, method name: " + element.getSimpleName().toString());
                return Optional.empty();
            }
            eventXml.setAttribute("event-direction", isFire ? EVENT_DIRECTION_FIRE : EVENT_DIRECTION_RECEIVE);
            // mask on attach
            if (eventMethod.maskOnAttach()) {
                eventXml.setAttribute("mask-on-attach", "True");
            }
            // last in transaction
            if (!eventMethod.lastInTransaction()) {
                eventXml.setAttribute("last-in-transaction", "False");
            }
            // description
            // event name
            final org.w3c.dom.Element eventName = doc.createElement("event-name");
            eventName.setTextContent(isFire ? element.getSimpleName().toString().substring(EVENT_FIRE_METHOD_PREFIX.length())
                    : element.getSimpleName().toString().substring(EVENT_RECEIVE_METHOD_PREFIX.length()));
            eventXml.appendChild(eventName);
            // event type ref
            fillInEventTypeRef(eventMethod, eventXml);
            // initial event select
            // ies variable
            for (EventMethod.InitialEventSelectVariable initialEventSelectVariable : eventMethod.initialEventSelectVariable()) {
                final org.w3c.dom.Element initialEventSelect = doc.createElement("initial-event-select");
                initialEventSelect.setAttribute("variable", initialEventSelectVariable.toString());
                eventXml.appendChild(initialEventSelect);
            }
            // ies method
            if (!eventMethod.initialEventSelectorMethodName().isEmpty()) {
                final org.w3c.dom.Element initialEventSelectorMethodName = doc.createElement("initial-event-selector-method-name");
                initialEventSelectorMethodName.setTextContent(eventMethod.initialEventSelectorMethodName());
                eventXml.appendChild(initialEventSelectorMethodName);
            }
            // ies event resource option
            if (!eventMethod.eventResourceOption().isEmpty()) {
                final org.w3c.dom.Element eventResourceOption = doc.createElement("event-resource-option");
                eventResourceOption.setTextContent(eventMethod.eventResourceOption());
                eventXml.appendChild(eventResourceOption);
            }
            return Optional.of(eventXml);
        }
        return Optional.empty();
    }

    private static void fillInEventTypeRef(EventMethod eventMethod, org.w3c.dom.Element eventXml) {
        final org.w3c.dom.Element eventTypeRef = eventXml.getOwnerDocument().createElement("event-type-ref");
        final org.w3c.dom.Element eventTypeName = eventXml.getOwnerDocument().createElement("event-type-name");
        eventTypeName.setTextContent(eventMethod.eventTypeName());
        eventTypeRef.appendChild(eventTypeName);
        final org.w3c.dom.Element eventTypeVendor = eventXml.getOwnerDocument().createElement("event-type-vendor");
        eventTypeVendor.setTextContent(eventMethod.eventTypeVendor());
        eventTypeRef.appendChild(eventTypeVendor);
        final org.w3c.dom.Element eventTypeVersion = eventXml.getOwnerDocument().createElement("event-type-version");
        eventTypeVersion.setTextContent(eventMethod.eventTypeVersion());
        eventTypeRef.appendChild(eventTypeVersion);
        eventXml.appendChild(eventTypeRef);
    }
}

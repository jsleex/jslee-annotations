
package com.jsleex.annotation.processor.xml.sbb;

import java.util.ArrayList;
import java.util.List;

import com.jsleex.annotation.processor.xml.common.Description;
import com.jsleex.annotation.processor.xml.common.EventTypeRef;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "description",
    "eventName",
    "eventTypeRef",
    "initialEventSelect",
    "initialEventSelectorMethodName",
    "eventResourceOption"
})
@XmlRootElement(name = "event")
public class Event {

    @XmlAttribute(name = "event-direction", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String eventDirection;
    @XmlAttribute(name = "initial-event")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String initialEvent;
    @XmlAttribute(name = "mask-on-attach")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String maskOnAttach;
    @XmlAttribute(name = "last-in-transaction")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String lastInTransaction;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "event-name", required = true)
    protected EventName eventName;
    @XmlElement(name = "event-type-ref", required = true)
    protected EventTypeRef eventTypeRef;
    @XmlElement(name = "initial-event-select")
    protected List<InitialEventSelect> initialEventSelect;
    @XmlElement(name = "initial-event-selector-method-name")
    protected InitialEventSelectorMethodName initialEventSelectorMethodName;
    @XmlElement(name = "event-resource-option")
    protected EventResourceOption eventResourceOption;

    /**
     * Gets the value of the eventDirection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventDirection() {
        return eventDirection;
    }

    /**
     * Sets the value of the eventDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventDirection(String value) {
        this.eventDirection = value;
    }

    /**
     * Gets the value of the initialEvent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitialEvent() {
        if (initialEvent == null) {
            return "False";
        } else {
            return initialEvent;
        }
    }

    /**
     * Sets the value of the initialEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitialEvent(String value) {
        this.initialEvent = value;
    }

    /**
     * Gets the value of the maskOnAttach property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaskOnAttach() {
        if (maskOnAttach == null) {
            return "False";
        } else {
            return maskOnAttach;
        }
    }

    /**
     * Sets the value of the maskOnAttach property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaskOnAttach(String value) {
        this.maskOnAttach = value;
    }

    /**
     * Gets the value of the lastInTransaction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastInTransaction() {
        if (lastInTransaction == null) {
            return "True";
        } else {
            return lastInTransaction;
        }
    }

    /**
     * Sets the value of the lastInTransaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastInTransaction(String value) {
        this.lastInTransaction = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link Description }
     *     
     */
    public Description getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link Description }
     *     
     */
    public void setDescription(Description value) {
        this.description = value;
    }

    /**
     * Gets the value of the eventName property.
     * 
     * @return
     *     possible object is
     *     {@link EventName }
     *     
     */
    public EventName getEventName() {
        return eventName;
    }

    /**
     * Sets the value of the eventName property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventName }
     *     
     */
    public void setEventName(EventName value) {
        this.eventName = value;
    }

    /**
     * Gets the value of the eventTypeRef property.
     * 
     * @return
     *     possible object is
     *     {@link EventTypeRef }
     *     
     */
    public EventTypeRef getEventTypeRef() {
        return eventTypeRef;
    }

    /**
     * Sets the value of the eventTypeRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventTypeRef }
     *     
     */
    public void setEventTypeRef(EventTypeRef value) {
        this.eventTypeRef = value;
    }

    /**
     * Gets the value of the initialEventSelect property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the initialEventSelect property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInitialEventSelect().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InitialEventSelect }
     * 
     * 
     */
    public List<InitialEventSelect> getInitialEventSelect() {
        if (initialEventSelect == null) {
            initialEventSelect = new ArrayList<InitialEventSelect>();
        }
        return this.initialEventSelect;
    }

    /**
     * Gets the value of the initialEventSelectorMethodName property.
     * 
     * @return
     *     possible object is
     *     {@link InitialEventSelectorMethodName }
     *     
     */
    public InitialEventSelectorMethodName getInitialEventSelectorMethodName() {
        return initialEventSelectorMethodName;
    }

    /**
     * Sets the value of the initialEventSelectorMethodName property.
     * 
     * @param value
     *     allowed object is
     *     {@link InitialEventSelectorMethodName }
     *     
     */
    public void setInitialEventSelectorMethodName(InitialEventSelectorMethodName value) {
        this.initialEventSelectorMethodName = value;
    }

    /**
     * Gets the value of the eventResourceOption property.
     * 
     * @return
     *     possible object is
     *     {@link EventResourceOption }
     *     
     */
    public EventResourceOption getEventResourceOption() {
        return eventResourceOption;
    }

    /**
     * Sets the value of the eventResourceOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventResourceOption }
     *     
     */
    public void setEventResourceOption(EventResourceOption value) {
        this.eventResourceOption = value;
    }

}

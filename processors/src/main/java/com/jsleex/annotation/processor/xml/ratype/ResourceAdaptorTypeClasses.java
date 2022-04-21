
package com.jsleex.annotation.processor.xml.ratype;

import java.util.ArrayList;
import java.util.List;

import com.jsleex.annotation.processor.xml.common.Description;
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
    "activityType",
    "activityContextInterfaceFactoryInterface",
    "resourceAdaptorInterface"
})
@XmlRootElement(name = "resource-adaptor-type-classes")
public class ResourceAdaptorTypeClasses {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "activity-type")
    protected List<ActivityType> activityType;
    @XmlElement(name = "activity-context-interface-factory-interface")
    protected ActivityContextInterfaceFactoryInterface activityContextInterfaceFactoryInterface;
    @XmlElement(name = "resource-adaptor-interface")
    protected ResourceAdaptorInterface resourceAdaptorInterface;

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
     * Gets the value of the activityType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the activityType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivityType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActivityType }
     * 
     * 
     */
    public List<ActivityType> getActivityType() {
        if (activityType == null) {
            activityType = new ArrayList<ActivityType>();
        }
        return this.activityType;
    }

    /**
     * Gets the value of the activityContextInterfaceFactoryInterface property.
     * 
     * @return
     *     possible object is
     *     {@link ActivityContextInterfaceFactoryInterface }
     *     
     */
    public ActivityContextInterfaceFactoryInterface getActivityContextInterfaceFactoryInterface() {
        return activityContextInterfaceFactoryInterface;
    }

    /**
     * Sets the value of the activityContextInterfaceFactoryInterface property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityContextInterfaceFactoryInterface }
     *     
     */
    public void setActivityContextInterfaceFactoryInterface(ActivityContextInterfaceFactoryInterface value) {
        this.activityContextInterfaceFactoryInterface = value;
    }

    /**
     * Gets the value of the resourceAdaptorInterface property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceAdaptorInterface }
     *     
     */
    public ResourceAdaptorInterface getResourceAdaptorInterface() {
        return resourceAdaptorInterface;
    }

    /**
     * Sets the value of the resourceAdaptorInterface property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceAdaptorInterface }
     *     
     */
    public void setResourceAdaptorInterface(ResourceAdaptorInterface value) {
        this.resourceAdaptorInterface = value;
    }

}

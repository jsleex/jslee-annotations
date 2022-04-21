
package com.jsleex.annotation.processor.xml.ra;

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
    "resourceAdaptorClassName"
})
@XmlRootElement(name = "resource-adaptor-class")
public class ResourceAdaptorClass {

    @XmlAttribute(name = "supports-active-reconfiguration")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String supportsActiveReconfiguration;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "resource-adaptor-class-name", required = true)
    protected ResourceAdaptorClassName resourceAdaptorClassName;

    /**
     * Gets the value of the supportsActiveReconfiguration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupportsActiveReconfiguration() {
        if (supportsActiveReconfiguration == null) {
            return "False";
        } else {
            return supportsActiveReconfiguration;
        }
    }

    /**
     * Sets the value of the supportsActiveReconfiguration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupportsActiveReconfiguration(String value) {
        this.supportsActiveReconfiguration = value;
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
     * Gets the value of the resourceAdaptorClassName property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceAdaptorClassName }
     *     
     */
    public ResourceAdaptorClassName getResourceAdaptorClassName() {
        return resourceAdaptorClassName;
    }

    /**
     * Sets the value of the resourceAdaptorClassName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceAdaptorClassName }
     *     
     */
    public void setResourceAdaptorClassName(ResourceAdaptorClassName value) {
        this.resourceAdaptorClassName = value;
    }

}

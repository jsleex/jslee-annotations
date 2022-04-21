
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
    "resourceAdaptorClass",
    "resourceAdaptorUsageParametersInterface"
})
@XmlRootElement(name = "resource-adaptor-classes")
public class ResourceAdaptorClasses {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "resource-adaptor-class", required = true)
    protected ResourceAdaptorClass resourceAdaptorClass;
    @XmlElement(name = "resource-adaptor-usage-parameters-interface")
    protected ResourceAdaptorUsageParametersInterface resourceAdaptorUsageParametersInterface;

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
     * Gets the value of the resourceAdaptorClass property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceAdaptorClass }
     *     
     */
    public ResourceAdaptorClass getResourceAdaptorClass() {
        return resourceAdaptorClass;
    }

    /**
     * Sets the value of the resourceAdaptorClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceAdaptorClass }
     *     
     */
    public void setResourceAdaptorClass(ResourceAdaptorClass value) {
        this.resourceAdaptorClass = value;
    }

    /**
     * Gets the value of the resourceAdaptorUsageParametersInterface property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceAdaptorUsageParametersInterface }
     *     
     */
    public ResourceAdaptorUsageParametersInterface getResourceAdaptorUsageParametersInterface() {
        return resourceAdaptorUsageParametersInterface;
    }

    /**
     * Sets the value of the resourceAdaptorUsageParametersInterface property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceAdaptorUsageParametersInterface }
     *     
     */
    public void setResourceAdaptorUsageParametersInterface(ResourceAdaptorUsageParametersInterface value) {
        this.resourceAdaptorUsageParametersInterface = value;
    }

}

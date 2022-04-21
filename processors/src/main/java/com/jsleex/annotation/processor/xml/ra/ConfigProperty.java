
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
    "configPropertyName",
    "configPropertyType",
    "configPropertyValue"
})
@XmlRootElement(name = "config-property")
public class ConfigProperty {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "config-property-name", required = true)
    protected ConfigPropertyName configPropertyName;
    @XmlElement(name = "config-property-type", required = true)
    protected ConfigPropertyType configPropertyType;
    @XmlElement(name = "config-property-value")
    protected ConfigPropertyValue configPropertyValue;

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
     * Gets the value of the configPropertyName property.
     * 
     * @return
     *     possible object is
     *     {@link ConfigPropertyName }
     *     
     */
    public ConfigPropertyName getConfigPropertyName() {
        return configPropertyName;
    }

    /**
     * Sets the value of the configPropertyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigPropertyName }
     *     
     */
    public void setConfigPropertyName(ConfigPropertyName value) {
        this.configPropertyName = value;
    }

    /**
     * Gets the value of the configPropertyType property.
     * 
     * @return
     *     possible object is
     *     {@link ConfigPropertyType }
     *     
     */
    public ConfigPropertyType getConfigPropertyType() {
        return configPropertyType;
    }

    /**
     * Sets the value of the configPropertyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigPropertyType }
     *     
     */
    public void setConfigPropertyType(ConfigPropertyType value) {
        this.configPropertyType = value;
    }

    /**
     * Gets the value of the configPropertyValue property.
     * 
     * @return
     *     possible object is
     *     {@link ConfigPropertyValue }
     *     
     */
    public ConfigPropertyValue getConfigPropertyValue() {
        return configPropertyValue;
    }

    /**
     * Sets the value of the configPropertyValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigPropertyValue }
     *     
     */
    public void setConfigPropertyValue(ConfigPropertyValue value) {
        this.configPropertyValue = value;
    }

}

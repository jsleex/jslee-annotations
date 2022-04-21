
package com.jsleex.annotation.processor.xml.common;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Objects;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "description",
    "envEntryName",
    "envEntryType",
    "envEntryValue"
})
@XmlRootElement(name = "env-entry")
public class EnvEntry {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "env-entry-name", required = true)
    protected EnvEntryName envEntryName;
    @XmlElement(name = "env-entry-type", required = true)
    protected EnvEntryType envEntryType;
    @XmlElement(name = "env-entry-value")
    protected EnvEntryValue envEntryValue;

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
     * Gets the value of the envEntryName property.
     * 
     * @return
     *     possible object is
     *     {@link EnvEntryName }
     *     
     */
    public EnvEntryName getEnvEntryName() {
        return envEntryName;
    }

    /**
     * Sets the value of the envEntryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnvEntryName }
     *     
     */
    public void setEnvEntryName(EnvEntryName value) {
        this.envEntryName = value;
    }

    /**
     * Gets the value of the envEntryType property.
     * 
     * @return
     *     possible object is
     *     {@link EnvEntryType }
     *     
     */
    public EnvEntryType getEnvEntryType() {
        return envEntryType;
    }

    /**
     * Sets the value of the envEntryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnvEntryType }
     *     
     */
    public void setEnvEntryType(EnvEntryType value) {
        this.envEntryType = value;
    }

    /**
     * Gets the value of the envEntryValue property.
     * 
     * @return
     *     possible object is
     *     {@link EnvEntryValue }
     *     
     */
    public EnvEntryValue getEnvEntryValue() {
        return envEntryValue;
    }

    /**
     * Sets the value of the envEntryValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnvEntryValue }
     *     
     */
    public void setEnvEntryValue(EnvEntryValue value) {
        this.envEntryValue = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnvEntry)) return false;
        EnvEntry envEntry = (EnvEntry) o;
        return Objects.equals(id, envEntry.id) && Objects.equals(envEntryName, envEntry.envEntryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, envEntryName);
    }
}

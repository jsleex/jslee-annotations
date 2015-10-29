/*
 * JSLEE Annotations
 * Copyright (c) 2015 Piotr Grabowski, All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */

package jsleeannotations.xml.common;

import jsleeannotations.xml.sbb.Description;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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

    public EnvEntry() {
    }

    public EnvEntry(String envEntryName, String envEntryType, String envEntryValue) {
        this.envEntryName = new EnvEntryName(envEntryName);
        this.envEntryType = new EnvEntryType(envEntryType);
        this.envEntryValue = new EnvEntryValue(envEntryValue);
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

}

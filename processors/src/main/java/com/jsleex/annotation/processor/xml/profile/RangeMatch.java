
package com.jsleex.annotation.processor.xml.profile;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "range-match")
public class RangeMatch {

    @XmlAttribute(name = "attribute-name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String attributeName;
    @XmlAttribute(name = "from-value")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String fromValue;
    @XmlAttribute(name = "from-parameter")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String fromParameter;
    @XmlAttribute(name = "to-value")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String toValue;
    @XmlAttribute(name = "to-parameter")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String toParameter;
    @XmlAttribute(name = "collator-ref")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String collatorRef;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;

    /**
     * Gets the value of the attributeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * Sets the value of the attributeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeName(String value) {
        this.attributeName = value;
    }

    /**
     * Gets the value of the fromValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromValue() {
        return fromValue;
    }

    /**
     * Sets the value of the fromValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromValue(String value) {
        this.fromValue = value;
    }

    /**
     * Gets the value of the fromParameter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromParameter() {
        return fromParameter;
    }

    /**
     * Sets the value of the fromParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromParameter(String value) {
        this.fromParameter = value;
    }

    /**
     * Gets the value of the toValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToValue() {
        return toValue;
    }

    /**
     * Sets the value of the toValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToValue(String value) {
        this.toValue = value;
    }

    /**
     * Gets the value of the toParameter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToParameter() {
        return toParameter;
    }

    /**
     * Sets the value of the toParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToParameter(String value) {
        this.toParameter = value;
    }

    /**
     * Gets the value of the collatorRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollatorRef() {
        return collatorRef;
    }

    /**
     * Sets the value of the collatorRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollatorRef(String value) {
        this.collatorRef = value;
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

}

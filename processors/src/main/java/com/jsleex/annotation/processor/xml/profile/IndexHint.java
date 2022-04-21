
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
@XmlRootElement(name = "index-hint")
public class IndexHint {

    @XmlAttribute(name = "query-operator", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String queryOperator;
    @XmlAttribute(name = "collator-ref")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String collatorRef;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;

    /**
     * Gets the value of the queryOperator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryOperator() {
        return queryOperator;
    }

    /**
     * Sets the value of the queryOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryOperator(String value) {
        this.queryOperator = value;
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

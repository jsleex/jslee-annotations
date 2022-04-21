
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
@XmlRootElement(name = "query-options")
public class QueryOptions {

    @XmlAttribute(name = "read-only")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String readOnly;
    @XmlAttribute(name = "max-matches")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String maxMatches;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;

    /**
     * Gets the value of the readOnly property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReadOnly() {
        return readOnly;
    }

    /**
     * Sets the value of the readOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReadOnly(String value) {
        this.readOnly = value;
    }

    /**
     * Gets the value of the maxMatches property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxMatches() {
        return maxMatches;
    }

    /**
     * Sets the value of the maxMatches property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxMatches(String value) {
        this.maxMatches = value;
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

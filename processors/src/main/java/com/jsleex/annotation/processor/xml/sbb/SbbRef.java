
package com.jsleex.annotation.processor.xml.sbb;

import com.jsleex.annotation.processor.xml.common.Description;
import com.jsleex.annotation.processor.xml.common.SbbName;
import com.jsleex.annotation.processor.xml.common.SbbVendor;
import com.jsleex.annotation.processor.xml.common.SbbVersion;
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
    "sbbName",
    "sbbVendor",
    "sbbVersion",
    "sbbAlias"
})
@XmlRootElement(name = "sbb-ref")
public class SbbRef {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "sbb-name", required = true)
    protected SbbName sbbName;
    @XmlElement(name = "sbb-vendor", required = true)
    protected SbbVendor sbbVendor;
    @XmlElement(name = "sbb-version", required = true)
    protected SbbVersion sbbVersion;
    @XmlElement(name = "sbb-alias", required = true)
    protected SbbAlias sbbAlias;

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
     * Gets the value of the sbbName property.
     * 
     * @return
     *     possible object is
     *     {@link SbbName }
     *     
     */
    public SbbName getSbbName() {
        return sbbName;
    }

    /**
     * Sets the value of the sbbName property.
     * 
     * @param value
     *     allowed object is
     *     {@link SbbName }
     *     
     */
    public void setSbbName(SbbName value) {
        this.sbbName = value;
    }

    /**
     * Gets the value of the sbbVendor property.
     * 
     * @return
     *     possible object is
     *     {@link SbbVendor }
     *     
     */
    public SbbVendor getSbbVendor() {
        return sbbVendor;
    }

    /**
     * Sets the value of the sbbVendor property.
     * 
     * @param value
     *     allowed object is
     *     {@link SbbVendor }
     *     
     */
    public void setSbbVendor(SbbVendor value) {
        this.sbbVendor = value;
    }

    /**
     * Gets the value of the sbbVersion property.
     * 
     * @return
     *     possible object is
     *     {@link SbbVersion }
     *     
     */
    public SbbVersion getSbbVersion() {
        return sbbVersion;
    }

    /**
     * Sets the value of the sbbVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link SbbVersion }
     *     
     */
    public void setSbbVersion(SbbVersion value) {
        this.sbbVersion = value;
    }

    /**
     * Gets the value of the sbbAlias property.
     * 
     * @return
     *     possible object is
     *     {@link SbbAlias }
     *     
     */
    public SbbAlias getSbbAlias() {
        return sbbAlias;
    }

    /**
     * Sets the value of the sbbAlias property.
     * 
     * @param value
     *     allowed object is
     *     {@link SbbAlias }
     *     
     */
    public void setSbbAlias(SbbAlias value) {
        this.sbbAlias = value;
    }

}

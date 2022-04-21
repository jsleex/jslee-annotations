
package com.jsleex.annotation.processor.xml.ra;

import com.jsleex.annotation.processor.xml.common.Description;
import com.jsleex.annotation.processor.xml.common.ResourceAdaptorTypeName;
import com.jsleex.annotation.processor.xml.common.ResourceAdaptorTypeVendor;
import com.jsleex.annotation.processor.xml.common.ResourceAdaptorTypeVersion;
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
    "resourceAdaptorTypeName",
    "resourceAdaptorTypeVendor",
    "resourceAdaptorTypeVersion"
})
@XmlRootElement(name = "resource-adaptor-type-ref")
public class ResourceAdaptorTypeRef {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "resource-adaptor-type-name", required = true)
    protected ResourceAdaptorTypeName resourceAdaptorTypeName;
    @XmlElement(name = "resource-adaptor-type-vendor", required = true)
    protected ResourceAdaptorTypeVendor resourceAdaptorTypeVendor;
    @XmlElement(name = "resource-adaptor-type-version", required = true)
    protected ResourceAdaptorTypeVersion resourceAdaptorTypeVersion;

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
     * Gets the value of the resourceAdaptorTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceAdaptorTypeName }
     *     
     */
    public ResourceAdaptorTypeName getResourceAdaptorTypeName() {
        return resourceAdaptorTypeName;
    }

    /**
     * Sets the value of the resourceAdaptorTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceAdaptorTypeName }
     *     
     */
    public void setResourceAdaptorTypeName(ResourceAdaptorTypeName value) {
        this.resourceAdaptorTypeName = value;
    }

    /**
     * Gets the value of the resourceAdaptorTypeVendor property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceAdaptorTypeVendor }
     *     
     */
    public ResourceAdaptorTypeVendor getResourceAdaptorTypeVendor() {
        return resourceAdaptorTypeVendor;
    }

    /**
     * Sets the value of the resourceAdaptorTypeVendor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceAdaptorTypeVendor }
     *     
     */
    public void setResourceAdaptorTypeVendor(ResourceAdaptorTypeVendor value) {
        this.resourceAdaptorTypeVendor = value;
    }

    /**
     * Gets the value of the resourceAdaptorTypeVersion property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceAdaptorTypeVersion }
     *     
     */
    public ResourceAdaptorTypeVersion getResourceAdaptorTypeVersion() {
        return resourceAdaptorTypeVersion;
    }

    /**
     * Sets the value of the resourceAdaptorTypeVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceAdaptorTypeVersion }
     *     
     */
    public void setResourceAdaptorTypeVersion(ResourceAdaptorTypeVersion value) {
        this.resourceAdaptorTypeVersion = value;
    }

}

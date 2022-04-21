
package com.jsleex.annotation.processor.xml.profile;

import com.jsleex.annotation.processor.xml.common.Description;
import com.jsleex.annotation.processor.xml.common.ProfileSpecName;
import com.jsleex.annotation.processor.xml.common.ProfileSpecVendor;
import com.jsleex.annotation.processor.xml.common.ProfileSpecVersion;
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
    "profileSpecName",
    "profileSpecVendor",
    "profileSpecVersion"
})
@XmlRootElement(name = "profile-spec-ref")
public class ProfileSpecRef {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "profile-spec-name", required = true)
    protected ProfileSpecName profileSpecName;
    @XmlElement(name = "profile-spec-vendor", required = true)
    protected ProfileSpecVendor profileSpecVendor;
    @XmlElement(name = "profile-spec-version", required = true)
    protected ProfileSpecVersion profileSpecVersion;

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
     * Gets the value of the profileSpecName property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileSpecName }
     *     
     */
    public ProfileSpecName getProfileSpecName() {
        return profileSpecName;
    }

    /**
     * Sets the value of the profileSpecName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileSpecName }
     *     
     */
    public void setProfileSpecName(ProfileSpecName value) {
        this.profileSpecName = value;
    }

    /**
     * Gets the value of the profileSpecVendor property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileSpecVendor }
     *     
     */
    public ProfileSpecVendor getProfileSpecVendor() {
        return profileSpecVendor;
    }

    /**
     * Sets the value of the profileSpecVendor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileSpecVendor }
     *     
     */
    public void setProfileSpecVendor(ProfileSpecVendor value) {
        this.profileSpecVendor = value;
    }

    /**
     * Gets the value of the profileSpecVersion property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileSpecVersion }
     *     
     */
    public ProfileSpecVersion getProfileSpecVersion() {
        return profileSpecVersion;
    }

    /**
     * Sets the value of the profileSpecVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileSpecVersion }
     *     
     */
    public void setProfileSpecVersion(ProfileSpecVersion value) {
        this.profileSpecVersion = value;
    }

}

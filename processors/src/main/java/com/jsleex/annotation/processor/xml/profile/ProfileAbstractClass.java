
package com.jsleex.annotation.processor.xml.profile;

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
    "profileAbstractClassName"
})
@XmlRootElement(name = "profile-abstract-class")
public class ProfileAbstractClass {

    @XmlAttribute(name = "reentrant")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String reentrant;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "profile-abstract-class-name", required = true)
    protected ProfileAbstractClassName profileAbstractClassName;

    /**
     * Gets the value of the reentrant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReentrant() {
        if (reentrant == null) {
            return "False";
        } else {
            return reentrant;
        }
    }

    /**
     * Sets the value of the reentrant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReentrant(String value) {
        this.reentrant = value;
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
     * Gets the value of the profileAbstractClassName property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileAbstractClassName }
     *     
     */
    public ProfileAbstractClassName getProfileAbstractClassName() {
        return profileAbstractClassName;
    }

    /**
     * Sets the value of the profileAbstractClassName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileAbstractClassName }
     *     
     */
    public void setProfileAbstractClassName(ProfileAbstractClassName value) {
        this.profileAbstractClassName = value;
    }

}

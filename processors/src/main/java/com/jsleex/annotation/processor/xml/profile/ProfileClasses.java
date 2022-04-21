
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
    "profileCmpInterface",
    "profileLocalInterface",
    "profileManagementInterface",
    "profileAbstractClass",
    "profileTableInterface",
    "profileUsageParametersInterface"
})
@XmlRootElement(name = "profile-classes")
public class ProfileClasses {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "profile-cmp-interface", required = true)
    protected ProfileCmpInterface profileCmpInterface;
    @XmlElement(name = "profile-local-interface")
    protected ProfileLocalInterface profileLocalInterface;
    @XmlElement(name = "profile-management-interface")
    protected ProfileManagementInterface profileManagementInterface;
    @XmlElement(name = "profile-abstract-class")
    protected ProfileAbstractClass profileAbstractClass;
    @XmlElement(name = "profile-table-interface")
    protected ProfileTableInterface profileTableInterface;
    @XmlElement(name = "profile-usage-parameters-interface")
    protected ProfileUsageParametersInterface profileUsageParametersInterface;

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
     * Gets the value of the profileCmpInterface property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileCmpInterface }
     *     
     */
    public ProfileCmpInterface getProfileCmpInterface() {
        return profileCmpInterface;
    }

    /**
     * Sets the value of the profileCmpInterface property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileCmpInterface }
     *     
     */
    public void setProfileCmpInterface(ProfileCmpInterface value) {
        this.profileCmpInterface = value;
    }

    /**
     * Gets the value of the profileLocalInterface property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileLocalInterface }
     *     
     */
    public ProfileLocalInterface getProfileLocalInterface() {
        return profileLocalInterface;
    }

    /**
     * Sets the value of the profileLocalInterface property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileLocalInterface }
     *     
     */
    public void setProfileLocalInterface(ProfileLocalInterface value) {
        this.profileLocalInterface = value;
    }

    /**
     * Gets the value of the profileManagementInterface property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileManagementInterface }
     *     
     */
    public ProfileManagementInterface getProfileManagementInterface() {
        return profileManagementInterface;
    }

    /**
     * Sets the value of the profileManagementInterface property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileManagementInterface }
     *     
     */
    public void setProfileManagementInterface(ProfileManagementInterface value) {
        this.profileManagementInterface = value;
    }

    /**
     * Gets the value of the profileAbstractClass property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileAbstractClass }
     *     
     */
    public ProfileAbstractClass getProfileAbstractClass() {
        return profileAbstractClass;
    }

    /**
     * Sets the value of the profileAbstractClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileAbstractClass }
     *     
     */
    public void setProfileAbstractClass(ProfileAbstractClass value) {
        this.profileAbstractClass = value;
    }

    /**
     * Gets the value of the profileTableInterface property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileTableInterface }
     *     
     */
    public ProfileTableInterface getProfileTableInterface() {
        return profileTableInterface;
    }

    /**
     * Sets the value of the profileTableInterface property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileTableInterface }
     *     
     */
    public void setProfileTableInterface(ProfileTableInterface value) {
        this.profileTableInterface = value;
    }

    /**
     * Gets the value of the profileUsageParametersInterface property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileUsageParametersInterface }
     *     
     */
    public ProfileUsageParametersInterface getProfileUsageParametersInterface() {
        return profileUsageParametersInterface;
    }

    /**
     * Sets the value of the profileUsageParametersInterface property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileUsageParametersInterface }
     *     
     */
    public void setProfileUsageParametersInterface(ProfileUsageParametersInterface value) {
        this.profileUsageParametersInterface = value;
    }

}

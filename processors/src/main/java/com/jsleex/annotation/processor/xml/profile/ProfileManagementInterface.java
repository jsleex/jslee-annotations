
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
    "profileManagementInterfaceName"
})
@XmlRootElement(name = "profile-management-interface")
public class ProfileManagementInterface {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "profile-management-interface-name", required = true)
    protected ProfileManagementInterfaceName profileManagementInterfaceName;

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
     * Gets the value of the profileManagementInterfaceName property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileManagementInterfaceName }
     *     
     */
    public ProfileManagementInterfaceName getProfileManagementInterfaceName() {
        return profileManagementInterfaceName;
    }

    /**
     * Sets the value of the profileManagementInterfaceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileManagementInterfaceName }
     *     
     */
    public void setProfileManagementInterfaceName(ProfileManagementInterfaceName value) {
        this.profileManagementInterfaceName = value;
    }

}

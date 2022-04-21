
package com.jsleex.annotation.processor.xml.sbb;

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
    "profileSpecAliasRef",
    "getProfileCmpMethodName"
})
@XmlRootElement(name = "get-profile-cmp-method")
public class GetProfileCmpMethod {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "profile-spec-alias-ref", required = true)
    protected ProfileSpecAliasRef profileSpecAliasRef;
    @XmlElement(name = "get-profile-cmp-method-name", required = true)
    protected GetProfileCmpMethodName getProfileCmpMethodName;

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
     * Gets the value of the profileSpecAliasRef property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileSpecAliasRef }
     *     
     */
    public ProfileSpecAliasRef getProfileSpecAliasRef() {
        return profileSpecAliasRef;
    }

    /**
     * Sets the value of the profileSpecAliasRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileSpecAliasRef }
     *     
     */
    public void setProfileSpecAliasRef(ProfileSpecAliasRef value) {
        this.profileSpecAliasRef = value;
    }

    /**
     * Gets the value of the getProfileCmpMethodName property.
     * 
     * @return
     *     possible object is
     *     {@link GetProfileCmpMethodName }
     *     
     */
    public GetProfileCmpMethodName getGetProfileCmpMethodName() {
        return getProfileCmpMethodName;
    }

    /**
     * Sets the value of the getProfileCmpMethodName property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetProfileCmpMethodName }
     *     
     */
    public void setGetProfileCmpMethodName(GetProfileCmpMethodName value) {
        this.getProfileCmpMethodName = value;
    }

}

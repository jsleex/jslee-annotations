
package com.jsleex.annotation.processor.xml.sbb;

import com.jsleex.annotation.processor.xml.common.DefaultPriority;
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
    "sbbAliasRef",
    "getChildRelationMethodName",
    "defaultPriority"
})
@XmlRootElement(name = "get-child-relation-method")
public class GetChildRelationMethod {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "sbb-alias-ref", required = true)
    protected SbbAliasRef sbbAliasRef;
    @XmlElement(name = "get-child-relation-method-name", required = true)
    protected GetChildRelationMethodName getChildRelationMethodName;
    @XmlElement(name = "default-priority", required = true)
    protected DefaultPriority defaultPriority;

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
     * Gets the value of the sbbAliasRef property.
     * 
     * @return
     *     possible object is
     *     {@link SbbAliasRef }
     *     
     */
    public SbbAliasRef getSbbAliasRef() {
        return sbbAliasRef;
    }

    /**
     * Sets the value of the sbbAliasRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SbbAliasRef }
     *     
     */
    public void setSbbAliasRef(SbbAliasRef value) {
        this.sbbAliasRef = value;
    }

    /**
     * Gets the value of the getChildRelationMethodName property.
     * 
     * @return
     *     possible object is
     *     {@link GetChildRelationMethodName }
     *     
     */
    public GetChildRelationMethodName getGetChildRelationMethodName() {
        return getChildRelationMethodName;
    }

    /**
     * Sets the value of the getChildRelationMethodName property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetChildRelationMethodName }
     *     
     */
    public void setGetChildRelationMethodName(GetChildRelationMethodName value) {
        this.getChildRelationMethodName = value;
    }

    /**
     * Gets the value of the defaultPriority property.
     * 
     * @return
     *     possible object is
     *     {@link DefaultPriority }
     *     
     */
    public DefaultPriority getDefaultPriority() {
        return defaultPriority;
    }

    /**
     * Sets the value of the defaultPriority property.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultPriority }
     *     
     */
    public void setDefaultPriority(DefaultPriority value) {
        this.defaultPriority = value;
    }

}

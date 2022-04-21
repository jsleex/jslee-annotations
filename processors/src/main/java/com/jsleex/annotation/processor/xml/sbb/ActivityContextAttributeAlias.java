
package com.jsleex.annotation.processor.xml.sbb;

import java.util.ArrayList;
import java.util.List;

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
    "attributeAliasName",
    "sbbActivityContextAttributeName"
})
@XmlRootElement(name = "activity-context-attribute-alias")
public class ActivityContextAttributeAlias {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "attribute-alias-name", required = true)
    protected AttributeAliasName attributeAliasName;
    @XmlElement(name = "sbb-activity-context-attribute-name")
    protected List<SbbActivityContextAttributeName> sbbActivityContextAttributeName;

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
     * Gets the value of the attributeAliasName property.
     * 
     * @return
     *     possible object is
     *     {@link AttributeAliasName }
     *     
     */
    public AttributeAliasName getAttributeAliasName() {
        return attributeAliasName;
    }

    /**
     * Sets the value of the attributeAliasName property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeAliasName }
     *     
     */
    public void setAttributeAliasName(AttributeAliasName value) {
        this.attributeAliasName = value;
    }

    /**
     * Gets the value of the sbbActivityContextAttributeName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the sbbActivityContextAttributeName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSbbActivityContextAttributeName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SbbActivityContextAttributeName }
     * 
     * 
     */
    public List<SbbActivityContextAttributeName> getSbbActivityContextAttributeName() {
        if (sbbActivityContextAttributeName == null) {
            sbbActivityContextAttributeName = new ArrayList<SbbActivityContextAttributeName>();
        }
        return this.sbbActivityContextAttributeName;
    }

}

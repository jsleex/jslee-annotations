
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

import java.util.Objects;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "description",
    "cmpFieldName",
    "sbbAliasRef"
})
@XmlRootElement(name = "cmp-field")
public class CmpField {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "cmp-field-name", required = true)
    protected CmpFieldName cmpFieldName;
    @XmlElement(name = "sbb-alias-ref")
    protected SbbAliasRef sbbAliasRef;

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
     * Gets the value of the cmpFieldName property.
     * 
     * @return
     *     possible object is
     *     {@link CmpFieldName }
     *     
     */
    public CmpFieldName getCmpFieldName() {
        return cmpFieldName;
    }

    /**
     * Sets the value of the cmpFieldName property.
     * 
     * @param value
     *     allowed object is
     *     {@link CmpFieldName }
     *     
     */
    public void setCmpFieldName(CmpFieldName value) {
        this.cmpFieldName = value;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CmpField)) return false;
        CmpField cmpField = (CmpField) o;
        return Objects.equals(id, cmpField.id) && Objects.equals(cmpFieldName, cmpField.cmpFieldName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cmpFieldName);
    }
}


package com.jsleex.annotation.processor.xml.profile;

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
import jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "description",
    "cmpFieldName",
    "indexHint"
})
@XmlRootElement(name = "cmp-field")
public class CmpField {

    @XmlAttribute(name = "unique")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String unique;
    @XmlAttribute(name = "unique-collator-ref")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String uniqueCollatorRef;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "cmp-field-name", required = true)
    protected CmpFieldName cmpFieldName;
    @XmlElement(name = "index-hint")
    protected List<IndexHint> indexHint;

    /**
     * Gets the value of the unique property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnique() {
        if (unique == null) {
            return "False";
        } else {
            return unique;
        }
    }

    /**
     * Sets the value of the unique property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnique(String value) {
        this.unique = value;
    }

    /**
     * Gets the value of the uniqueCollatorRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniqueCollatorRef() {
        return uniqueCollatorRef;
    }

    /**
     * Sets the value of the uniqueCollatorRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniqueCollatorRef(String value) {
        this.uniqueCollatorRef = value;
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
     * Gets the value of the indexHint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the indexHint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndexHint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IndexHint }
     * 
     * 
     */
    public List<IndexHint> getIndexHint() {
        if (indexHint == null) {
            indexHint = new ArrayList<IndexHint>();
        }
        return this.indexHint;
    }

}

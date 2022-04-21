
package com.jsleex.annotation.processor.xml.sbb;

import java.util.ArrayList;
import java.util.List;

import com.jsleex.annotation.processor.xml.common.Description;
import com.jsleex.annotation.processor.xml.common.SecurityPermissions;
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
    "sbb",
    "securityPermissions"
})
@XmlRootElement(name = "sbb-jar")
public class SbbJar {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(required = true)
    protected List<Sbb> sbb;
    @XmlElement(name = "security-permissions")
    protected SecurityPermissions securityPermissions;

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
     * Gets the value of the sbb property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the sbb property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSbb().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Sbb }
     * 
     * 
     */
    public List<Sbb> getSbb() {
        if (sbb == null) {
            sbb = new ArrayList<Sbb>();
        }
        return this.sbb;
    }

    /**
     * Gets the value of the securityPermissions property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityPermissions }
     *     
     */
    public SecurityPermissions getSecurityPermissions() {
        return securityPermissions;
    }

    /**
     * Sets the value of the securityPermissions property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityPermissions }
     *     
     */
    public void setSecurityPermissions(SecurityPermissions value) {
        this.securityPermissions = value;
    }

}


package com.jsleex.annotation.processor.xml.ra;

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
    "resourceAdaptor",
    "securityPermissions"
})
@XmlRootElement(name = "resource-adaptor-jar")
public class ResourceAdaptorJar {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "resource-adaptor", required = true)
    protected List<ResourceAdaptor> resourceAdaptor;
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
     * Gets the value of the resourceAdaptor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the resourceAdaptor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResourceAdaptor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceAdaptor }
     * 
     * 
     */
    public List<ResourceAdaptor> getResourceAdaptor() {
        if (resourceAdaptor == null) {
            resourceAdaptor = new ArrayList<ResourceAdaptor>();
        }
        return this.resourceAdaptor;
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


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
    "sbbLocalInterfaceName"
})
@XmlRootElement(name = "sbb-local-interface")
public class SbbLocalInterface {

    @XmlAttribute(name = "isolate-security-permissions")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isolateSecurityPermissions;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "sbb-local-interface-name", required = true)
    protected SbbLocalInterfaceName sbbLocalInterfaceName;

    /**
     * Gets the value of the isolateSecurityPermissions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsolateSecurityPermissions() {
        if (isolateSecurityPermissions == null) {
            return "False";
        } else {
            return isolateSecurityPermissions;
        }
    }

    /**
     * Sets the value of the isolateSecurityPermissions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsolateSecurityPermissions(String value) {
        this.isolateSecurityPermissions = value;
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
     * Gets the value of the sbbLocalInterfaceName property.
     * 
     * @return
     *     possible object is
     *     {@link SbbLocalInterfaceName }
     *     
     */
    public SbbLocalInterfaceName getSbbLocalInterfaceName() {
        return sbbLocalInterfaceName;
    }

    /**
     * Sets the value of the sbbLocalInterfaceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link SbbLocalInterfaceName }
     *     
     */
    public void setSbbLocalInterfaceName(SbbLocalInterfaceName value) {
        this.sbbLocalInterfaceName = value;
    }

}

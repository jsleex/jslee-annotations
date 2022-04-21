
package com.jsleex.annotation.processor.xml.lib;

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
    "jarName",
    "securityPermissions"
})
@XmlRootElement(name = "jar")
public class Jar {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "jar-name", required = true)
    protected JarName jarName;
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
     * Gets the value of the jarName property.
     * 
     * @return
     *     possible object is
     *     {@link JarName }
     *     
     */
    public JarName getJarName() {
        return jarName;
    }

    /**
     * Sets the value of the jarName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JarName }
     *     
     */
    public void setJarName(JarName value) {
        this.jarName = value;
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

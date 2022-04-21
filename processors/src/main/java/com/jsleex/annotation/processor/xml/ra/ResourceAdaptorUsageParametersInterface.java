
package com.jsleex.annotation.processor.xml.ra;

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
    "resourceAdaptorUsageParametersInterfaceName",
    "usageParameter"
})
@XmlRootElement(name = "resource-adaptor-usage-parameters-interface")
public class ResourceAdaptorUsageParametersInterface {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "resource-adaptor-usage-parameters-interface-name", required = true)
    protected ResourceAdaptorUsageParametersInterfaceName resourceAdaptorUsageParametersInterfaceName;
    @XmlElement(name = "usage-parameter")
    protected List<UsageParameter> usageParameter;

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
     * Gets the value of the resourceAdaptorUsageParametersInterfaceName property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceAdaptorUsageParametersInterfaceName }
     *     
     */
    public ResourceAdaptorUsageParametersInterfaceName getResourceAdaptorUsageParametersInterfaceName() {
        return resourceAdaptorUsageParametersInterfaceName;
    }

    /**
     * Sets the value of the resourceAdaptorUsageParametersInterfaceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceAdaptorUsageParametersInterfaceName }
     *     
     */
    public void setResourceAdaptorUsageParametersInterfaceName(ResourceAdaptorUsageParametersInterfaceName value) {
        this.resourceAdaptorUsageParametersInterfaceName = value;
    }

    /**
     * Gets the value of the usageParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the usageParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsageParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UsageParameter }
     * 
     * 
     */
    public List<UsageParameter> getUsageParameter() {
        if (usageParameter == null) {
            usageParameter = new ArrayList<UsageParameter>();
        }
        return this.usageParameter;
    }

}

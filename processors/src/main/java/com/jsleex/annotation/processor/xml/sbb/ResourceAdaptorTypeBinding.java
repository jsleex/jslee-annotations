
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
    "resourceAdaptorTypeRef",
    "activityContextInterfaceFactoryName",
    "resourceAdaptorEntityBinding"
})
@XmlRootElement(name = "resource-adaptor-type-binding")
public class ResourceAdaptorTypeBinding {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "resource-adaptor-type-ref", required = true)
    protected ResourceAdaptorTypeRef resourceAdaptorTypeRef;
    @XmlElement(name = "activity-context-interface-factory-name")
    protected ActivityContextInterfaceFactoryName activityContextInterfaceFactoryName;
    @XmlElement(name = "resource-adaptor-entity-binding")
    protected List<ResourceAdaptorEntityBinding> resourceAdaptorEntityBinding;

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
     * Gets the value of the resourceAdaptorTypeRef property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceAdaptorTypeRef }
     *     
     */
    public ResourceAdaptorTypeRef getResourceAdaptorTypeRef() {
        return resourceAdaptorTypeRef;
    }

    /**
     * Sets the value of the resourceAdaptorTypeRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceAdaptorTypeRef }
     *     
     */
    public void setResourceAdaptorTypeRef(ResourceAdaptorTypeRef value) {
        this.resourceAdaptorTypeRef = value;
    }

    /**
     * Gets the value of the activityContextInterfaceFactoryName property.
     * 
     * @return
     *     possible object is
     *     {@link ActivityContextInterfaceFactoryName }
     *     
     */
    public ActivityContextInterfaceFactoryName getActivityContextInterfaceFactoryName() {
        return activityContextInterfaceFactoryName;
    }

    /**
     * Sets the value of the activityContextInterfaceFactoryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityContextInterfaceFactoryName }
     *     
     */
    public void setActivityContextInterfaceFactoryName(ActivityContextInterfaceFactoryName value) {
        this.activityContextInterfaceFactoryName = value;
    }

    /**
     * Gets the value of the resourceAdaptorEntityBinding property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the resourceAdaptorEntityBinding property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResourceAdaptorEntityBinding().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceAdaptorEntityBinding }
     * 
     * 
     */
    public List<ResourceAdaptorEntityBinding> getResourceAdaptorEntityBinding() {
        if (resourceAdaptorEntityBinding == null) {
            resourceAdaptorEntityBinding = new ArrayList<ResourceAdaptorEntityBinding>();
        }
        return this.resourceAdaptorEntityBinding;
    }

}

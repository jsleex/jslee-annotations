
package com.jsleex.annotation.processor.xml.sbb;

import java.util.ArrayList;
import java.util.List;

import com.jsleex.annotation.processor.xml.common.*;
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
    "sbbName",
    "sbbVendor",
    "sbbVersion",
    "sbbAlias",
    "libraryRef",
    "sbbRef",
    "profileSpecRef",
    "sbbClasses",
    "addressProfileSpecAliasRef",
    "event",
    "activityContextAttributeAlias",
    "envEntry",
    "resourceAdaptorTypeBinding",
    "ejbRef"
})
@XmlRootElement(name = "sbb")
public class Sbb {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "sbb-name", required = true)
    protected SbbName sbbName;
    @XmlElement(name = "sbb-vendor", required = true)
    protected SbbVendor sbbVendor;
    @XmlElement(name = "sbb-version", required = true)
    protected SbbVersion sbbVersion;
    @XmlElement(name = "sbb-alias")
    protected SbbAlias sbbAlias;
    @XmlElement(name = "library-ref")
    protected List<LibraryRef> libraryRef;
    @XmlElement(name = "sbb-ref")
    protected List<SbbRef> sbbRef;
    @XmlElement(name = "profile-spec-ref")
    protected List<ProfileSpecRef> profileSpecRef;
    @XmlElement(name = "sbb-classes", required = true)
    protected SbbClasses sbbClasses;
    @XmlElement(name = "address-profile-spec-alias-ref")
    protected AddressProfileSpecAliasRef addressProfileSpecAliasRef;
    protected List<Event> event;
    @XmlElement(name = "activity-context-attribute-alias")
    protected List<ActivityContextAttributeAlias> activityContextAttributeAlias;
    @XmlElement(name = "env-entry")
    protected List<EnvEntry> envEntry;
    @XmlElement(name = "resource-adaptor-type-binding")
    protected List<ResourceAdaptorTypeBinding> resourceAdaptorTypeBinding;
    @XmlElement(name = "ejb-ref")
    protected List<EjbRef> ejbRef;

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
     * Gets the value of the sbbName property.
     * 
     * @return
     *     possible object is
     *     {@link SbbName }
     *     
     */
    public SbbName getSbbName() {
        return sbbName;
    }

    /**
     * Sets the value of the sbbName property.
     * 
     * @param value
     *     allowed object is
     *     {@link SbbName }
     *     
     */
    public void setSbbName(SbbName value) {
        this.sbbName = value;
    }

    /**
     * Gets the value of the sbbVendor property.
     * 
     * @return
     *     possible object is
     *     {@link SbbVendor }
     *     
     */
    public SbbVendor getSbbVendor() {
        return sbbVendor;
    }

    /**
     * Sets the value of the sbbVendor property.
     * 
     * @param value
     *     allowed object is
     *     {@link SbbVendor }
     *     
     */
    public void setSbbVendor(SbbVendor value) {
        this.sbbVendor = value;
    }

    /**
     * Gets the value of the sbbVersion property.
     * 
     * @return
     *     possible object is
     *     {@link SbbVersion }
     *     
     */
    public SbbVersion getSbbVersion() {
        return sbbVersion;
    }

    /**
     * Sets the value of the sbbVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link SbbVersion }
     *     
     */
    public void setSbbVersion(SbbVersion value) {
        this.sbbVersion = value;
    }

    /**
     * Gets the value of the sbbAlias property.
     * 
     * @return
     *     possible object is
     *     {@link SbbAlias }
     *     
     */
    public SbbAlias getSbbAlias() {
        return sbbAlias;
    }

    /**
     * Sets the value of the sbbAlias property.
     * 
     * @param value
     *     allowed object is
     *     {@link SbbAlias }
     *     
     */
    public void setSbbAlias(SbbAlias value) {
        this.sbbAlias = value;
    }

    /**
     * Gets the value of the libraryRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the libraryRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLibraryRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LibraryRef }
     * 
     * 
     */
    public List<LibraryRef> getLibraryRef() {
        if (libraryRef == null) {
            libraryRef = new ArrayList<LibraryRef>();
        }
        return this.libraryRef;
    }

    /**
     * Gets the value of the sbbRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the sbbRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSbbRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SbbRef }
     * 
     * 
     */
    public List<SbbRef> getSbbRef() {
        if (sbbRef == null) {
            sbbRef = new ArrayList<SbbRef>();
        }
        return this.sbbRef;
    }

    /**
     * Gets the value of the profileSpecRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the profileSpecRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProfileSpecRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProfileSpecRef }
     * 
     * 
     */
    public List<ProfileSpecRef> getProfileSpecRef() {
        if (profileSpecRef == null) {
            profileSpecRef = new ArrayList<ProfileSpecRef>();
        }
        return this.profileSpecRef;
    }

    /**
     * Gets the value of the sbbClasses property.
     * 
     * @return
     *     possible object is
     *     {@link SbbClasses }
     *     
     */
    public SbbClasses getSbbClasses() {
        return sbbClasses;
    }

    /**
     * Sets the value of the sbbClasses property.
     * 
     * @param value
     *     allowed object is
     *     {@link SbbClasses }
     *     
     */
    public void setSbbClasses(SbbClasses value) {
        this.sbbClasses = value;
    }

    /**
     * Gets the value of the addressProfileSpecAliasRef property.
     * 
     * @return
     *     possible object is
     *     {@link AddressProfileSpecAliasRef }
     *     
     */
    public AddressProfileSpecAliasRef getAddressProfileSpecAliasRef() {
        return addressProfileSpecAliasRef;
    }

    /**
     * Sets the value of the addressProfileSpecAliasRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressProfileSpecAliasRef }
     *     
     */
    public void setAddressProfileSpecAliasRef(AddressProfileSpecAliasRef value) {
        this.addressProfileSpecAliasRef = value;
    }

    /**
     * Gets the value of the event property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the event property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Event }
     * 
     * 
     */
    public List<Event> getEvent() {
        if (event == null) {
            event = new ArrayList<Event>();
        }
        return this.event;
    }

    /**
     * Gets the value of the activityContextAttributeAlias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the activityContextAttributeAlias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivityContextAttributeAlias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActivityContextAttributeAlias }
     * 
     * 
     */
    public List<ActivityContextAttributeAlias> getActivityContextAttributeAlias() {
        if (activityContextAttributeAlias == null) {
            activityContextAttributeAlias = new ArrayList<ActivityContextAttributeAlias>();
        }
        return this.activityContextAttributeAlias;
    }

    /**
     * Gets the value of the envEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the envEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnvEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnvEntry }
     * 
     * 
     */
    public List<EnvEntry> getEnvEntry() {
        if (envEntry == null) {
            envEntry = new ArrayList<EnvEntry>();
        }
        return this.envEntry;
    }

    /**
     * Gets the value of the resourceAdaptorTypeBinding property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the resourceAdaptorTypeBinding property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResourceAdaptorTypeBinding().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceAdaptorTypeBinding }
     * 
     * 
     */
    public List<ResourceAdaptorTypeBinding> getResourceAdaptorTypeBinding() {
        if (resourceAdaptorTypeBinding == null) {
            resourceAdaptorTypeBinding = new ArrayList<ResourceAdaptorTypeBinding>();
        }
        return this.resourceAdaptorTypeBinding;
    }

    /**
     * Gets the value of the ejbRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the ejbRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEjbRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EjbRef }
     * 
     * 
     */
    public List<EjbRef> getEjbRef() {
        if (ejbRef == null) {
            ejbRef = new ArrayList<EjbRef>();
        }
        return this.ejbRef;
    }

}
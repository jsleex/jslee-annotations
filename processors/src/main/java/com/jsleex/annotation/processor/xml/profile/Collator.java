
package com.jsleex.annotation.processor.xml.profile;

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
    "collatorAlias",
    "localeLanguage",
    "localeCountry",
    "localeVariant"
})
@XmlRootElement(name = "collator")
public class Collator {

    @XmlAttribute(name = "strength")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String strength;
    @XmlAttribute(name = "decomposition")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String decomposition;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "collator-alias", required = true)
    protected CollatorAlias collatorAlias;
    @XmlElement(name = "locale-language", required = true)
    protected LocaleLanguage localeLanguage;
    @XmlElement(name = "locale-country")
    protected LocaleCountry localeCountry;
    @XmlElement(name = "locale-variant")
    protected LocaleVariant localeVariant;

    /**
     * Gets the value of the strength property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrength() {
        return strength;
    }

    /**
     * Sets the value of the strength property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrength(String value) {
        this.strength = value;
    }

    /**
     * Gets the value of the decomposition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDecomposition() {
        return decomposition;
    }

    /**
     * Sets the value of the decomposition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDecomposition(String value) {
        this.decomposition = value;
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
     * Gets the value of the collatorAlias property.
     * 
     * @return
     *     possible object is
     *     {@link CollatorAlias }
     *     
     */
    public CollatorAlias getCollatorAlias() {
        return collatorAlias;
    }

    /**
     * Sets the value of the collatorAlias property.
     * 
     * @param value
     *     allowed object is
     *     {@link CollatorAlias }
     *     
     */
    public void setCollatorAlias(CollatorAlias value) {
        this.collatorAlias = value;
    }

    /**
     * Gets the value of the localeLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link LocaleLanguage }
     *     
     */
    public LocaleLanguage getLocaleLanguage() {
        return localeLanguage;
    }

    /**
     * Sets the value of the localeLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocaleLanguage }
     *     
     */
    public void setLocaleLanguage(LocaleLanguage value) {
        this.localeLanguage = value;
    }

    /**
     * Gets the value of the localeCountry property.
     * 
     * @return
     *     possible object is
     *     {@link LocaleCountry }
     *     
     */
    public LocaleCountry getLocaleCountry() {
        return localeCountry;
    }

    /**
     * Sets the value of the localeCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocaleCountry }
     *     
     */
    public void setLocaleCountry(LocaleCountry value) {
        this.localeCountry = value;
    }

    /**
     * Gets the value of the localeVariant property.
     * 
     * @return
     *     possible object is
     *     {@link LocaleVariant }
     *     
     */
    public LocaleVariant getLocaleVariant() {
        return localeVariant;
    }

    /**
     * Sets the value of the localeVariant property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocaleVariant }
     *     
     */
    public void setLocaleVariant(LocaleVariant value) {
        this.localeVariant = value;
    }

}

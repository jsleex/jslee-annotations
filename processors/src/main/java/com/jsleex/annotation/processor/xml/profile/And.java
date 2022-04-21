
package com.jsleex.annotation.processor.xml.profile;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
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
    "compareOrRangeMatchOrLongestPrefixMatchOrHasPrefixOrAndOrOrOrNot"
})
@XmlRootElement(name = "and")
public class And {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    @XmlElements({
        @XmlElement(name = "compare", type = Compare.class),
        @XmlElement(name = "range-match", type = RangeMatch.class),
        @XmlElement(name = "longest-prefix-match", type = LongestPrefixMatch.class),
        @XmlElement(name = "has-prefix", type = HasPrefix.class),
        @XmlElement(name = "and", type = And.class),
        @XmlElement(name = "or", type = Or.class),
        @XmlElement(name = "not", type = Not.class)
    })
    protected List<Object> compareOrRangeMatchOrLongestPrefixMatchOrHasPrefixOrAndOrOrOrNot;

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
     * Gets the value of the compareOrRangeMatchOrLongestPrefixMatchOrHasPrefixOrAndOrOrOrNot property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the compareOrRangeMatchOrLongestPrefixMatchOrHasPrefixOrAndOrOrOrNot property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompareOrRangeMatchOrLongestPrefixMatchOrHasPrefixOrAndOrOrOrNot().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link And }
     * {@link Compare }
     * {@link HasPrefix }
     * {@link LongestPrefixMatch }
     * {@link Not }
     * {@link Or }
     * {@link RangeMatch }
     * 
     * 
     */
    public List<Object> getCompareOrRangeMatchOrLongestPrefixMatchOrHasPrefixOrAndOrOrOrNot() {
        if (compareOrRangeMatchOrLongestPrefixMatchOrHasPrefixOrAndOrOrOrNot == null) {
            compareOrRangeMatchOrLongestPrefixMatchOrHasPrefixOrAndOrOrOrNot = new ArrayList<Object>();
        }
        return this.compareOrRangeMatchOrLongestPrefixMatchOrHasPrefixOrAndOrOrOrNot;
    }

}

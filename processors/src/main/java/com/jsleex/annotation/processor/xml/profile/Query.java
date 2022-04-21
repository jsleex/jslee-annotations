
package com.jsleex.annotation.processor.xml.profile;

import java.util.ArrayList;
import java.util.List;

import com.jsleex.annotation.processor.xml.common.Description;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
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
    "queryOptions",
    "queryParameter",
    "compareOrRangeMatchOrLongestPrefixMatchOrHasPrefixOrAndOrOrOrNot"
})
@XmlRootElement(name = "query")
public class Query {

    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    protected Description description;
    @XmlElement(name = "query-options")
    protected QueryOptions queryOptions;
    @XmlElement(name = "query-parameter")
    protected List<QueryParameter> queryParameter;
    @XmlElements({
        @XmlElement(name = "compare", required = true, type = Compare.class),
        @XmlElement(name = "range-match", required = true, type = RangeMatch.class),
        @XmlElement(name = "longest-prefix-match", required = true, type = LongestPrefixMatch.class),
        @XmlElement(name = "has-prefix", required = true, type = HasPrefix.class),
        @XmlElement(name = "and", required = true, type = And.class),
        @XmlElement(name = "or", required = true, type = Or.class),
        @XmlElement(name = "not", required = true, type = Not.class)
    })
    protected List<Object> compareOrRangeMatchOrLongestPrefixMatchOrHasPrefixOrAndOrOrOrNot;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     * Gets the value of the queryOptions property.
     * 
     * @return
     *     possible object is
     *     {@link QueryOptions }
     *     
     */
    public QueryOptions getQueryOptions() {
        return queryOptions;
    }

    /**
     * Sets the value of the queryOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryOptions }
     *     
     */
    public void setQueryOptions(QueryOptions value) {
        this.queryOptions = value;
    }

    /**
     * Gets the value of the queryParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the queryParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQueryParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QueryParameter }
     * 
     * 
     */
    public List<QueryParameter> getQueryParameter() {
        if (queryParameter == null) {
            queryParameter = new ArrayList<QueryParameter>();
        }
        return this.queryParameter;
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

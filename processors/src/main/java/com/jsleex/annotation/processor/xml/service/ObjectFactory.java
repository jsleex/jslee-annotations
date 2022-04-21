
package com.jsleex.annotation.processor.xml.service;

import com.jsleex.annotation.processor.xml.common.*;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.jsleex.annotation.processor.xml.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.jsleex.annotation.processor.xml.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceName }
     * 
     */
    public ServiceName createServiceName() {
        return new ServiceName();
    }

    /**
     * Create an instance of {@link ServiceXml }
     * 
     */
    public ServiceXml createServiceXml() {
        return new ServiceXml();
    }

    /**
     * Create an instance of {@link Description }
     * 
     */
    public Description createDescription() {
        return new Description();
    }

    /**
     * Create an instance of {@link Service }
     * 
     */
    public Service createService() {
        return new Service();
    }

    /**
     * Create an instance of {@link DefaultPriority }
     * 
     */
    public DefaultPriority createDefaultPriority() {
        return new DefaultPriority();
    }

    /**
     * Create an instance of {@link RootSbb }
     * 
     */
    public RootSbb createRootSbb() {
        return new RootSbb();
    }

    /**
     * Create an instance of {@link SbbName }
     * 
     */
    public SbbName createSbbName() {
        return new SbbName();
    }

    /**
     * Create an instance of {@link SbbVendor }
     * 
     */
    public SbbVendor createSbbVendor() {
        return new SbbVendor();
    }

    /**
     * Create an instance of {@link SbbVersion }
     * 
     */
    public SbbVersion createSbbVersion() {
        return new SbbVersion();
    }

    /**
     * Create an instance of {@link AddressProfileTable }
     * 
     */
    public AddressProfileTable createAddressProfileTable() {
        return new AddressProfileTable();
    }

    /**
     * Create an instance of {@link ServiceVendor }
     * 
     */
    public ServiceVendor createServiceVendor() {
        return new ServiceVendor();
    }

    /**
     * Create an instance of {@link ServiceVersion }
     * 
     */
    public ServiceVersion createServiceVersion() {
        return new ServiceVersion();
    }

}

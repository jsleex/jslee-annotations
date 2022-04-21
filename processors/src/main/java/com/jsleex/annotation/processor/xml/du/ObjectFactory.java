
package com.jsleex.annotation.processor.xml.du;

import com.jsleex.annotation.processor.xml.common.Description;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.jsleex.annotation.processor.xml.du package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.jsleex.annotation.processor.xml.du
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceXml }
     * 
     */
    public ServiceXml createServiceXml() {
        return new ServiceXml();
    }

    /**
     * Create an instance of {@link DeployableUnit }
     * 
     */
    public DeployableUnit createDeployableUnit() {
        return new DeployableUnit();
    }

    /**
     * Create an instance of {@link Description }
     * 
     */
    public Description createDescription() {
        return new Description();
    }

    /**
     * Create an instance of {@link Jar }
     * 
     */
    public Jar createJar() {
        return new Jar();
    }

}

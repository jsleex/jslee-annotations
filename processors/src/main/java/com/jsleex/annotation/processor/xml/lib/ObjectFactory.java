
package com.jsleex.annotation.processor.xml.lib;

import com.jsleex.annotation.processor.xml.common.*;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.jsleex.annotation.processor.xml.lib package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.jsleex.annotation.processor.xml.lib
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LibraryVendor }
     * 
     */
    public LibraryVendor createLibraryVendor() {
        return new LibraryVendor();
    }

    /**
     * Create an instance of {@link SecurityPermissions }
     * 
     */
    public SecurityPermissions createSecurityPermissions() {
        return new SecurityPermissions();
    }

    /**
     * Create an instance of {@link Description }
     * 
     */
    public Description createDescription() {
        return new Description();
    }

    /**
     * Create an instance of {@link SecurityPermissionSpec }
     * 
     */
    public SecurityPermissionSpec createSecurityPermissionSpec() {
        return new SecurityPermissionSpec();
    }

    /**
     * Create an instance of {@link JarName }
     * 
     */
    public JarName createJarName() {
        return new JarName();
    }

    /**
     * Create an instance of {@link Library }
     * 
     */
    public Library createLibrary() {
        return new Library();
    }

    /**
     * Create an instance of {@link LibraryName }
     * 
     */
    public LibraryName createLibraryName() {
        return new LibraryName();
    }

    /**
     * Create an instance of {@link LibraryVersion }
     * 
     */
    public LibraryVersion createLibraryVersion() {
        return new LibraryVersion();
    }

    /**
     * Create an instance of {@link LibraryRef }
     * 
     */
    public LibraryRef createLibraryRef() {
        return new LibraryRef();
    }

    /**
     * Create an instance of {@link Jar }
     * 
     */
    public Jar createJar() {
        return new Jar();
    }

    /**
     * Create an instance of {@link LibraryJar }
     * 
     */
    public LibraryJar createLibraryJar() {
        return new LibraryJar();
    }

}

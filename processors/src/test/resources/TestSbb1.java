/*
 * JSLEE Annotations
 * Copyright (C) 2015-2022 Piotr Grabowski
 */

package sbb;

import com.jsleex.annotation.*;
import com.jsleex.annotation.Sbb;
import com.jsleex.annotation.example.TestLocalInterface;
import com.jsleex.annotation.example.TestSbbUsage;
import com.jsleex.annotation.example.TestXDocletParent;

import javax.slee.*;

@Service(name = "Test", vendor = "Test", version = "1.0")
@Sbb(name = "Test", vendor = "Test", version = "1.0", sbbLocalInterfaceName = TestLocalInterface.class,
     sbbUsageParameterInterfaceName = TestSbbUsage.class,
     securityPermissions = "\n" +
             "grant {\n" +
             "    permission java.lang.RuntimePermission \"accessDeclaredMembers\";\n" +
             "};\n")
@LibraryRef(name = "ExampleLibrary", vendor = "Test", version = "1.0")
@RaTypeBinding(resourceAdaptorTypeName = "ExampleRA", resourceAdaptorTypeVendor = "Test", resourceAdaptorTypeVersion = "1.0",
        resourceAdaptorEntityLinks = "test-entity", resourceAdaptorObjectNames = "test-object")
@SbbRef(name = "ExampleChild", vendor = "Test", version = "1.0", alias = "exampleChildSbb")
@EjbRef(ejbRefName = "ExampleEjb", ejbRefType = EjbRef.EjbRefType.ENTITY, home = "com.jsleex.ejb.ExampleEJB", remote = "remote", ejbLink = "ejbLink")
@SbbActivityContextAttributeAlias(attributeAliasName = "alias", sbbActivityContextAttributesNames = "example")
public abstract class TestSbb1 extends TestXDocletParent {
    @EventMethod(eventTypeName = "ExampleEvent", eventTypeVendor = "Test", eventTypeVersion = "1.0",
            initialEventSelectVariable = { EventMethod.InitialEventSelectVariable.ACTIVITY_CONTEXT, EventMethod.InitialEventSelectVariable.EVENT},
            initialEvent = true)
    public void onExampleEvent(Object event, ActivityContextInterface aci) {

    }

    @EventMethod(eventTypeName = "ExampleEvent", eventTypeVendor = "Test", eventTypeVersion = "1.0")
    public abstract void fireExampleEvent(Object event, ActivityContextInterface aci, Address address);

    @ChildRelationMethod(sbbAliasRef = "exampleChildSbb")
    public abstract ChildRelation getExampleChildSbb();
}

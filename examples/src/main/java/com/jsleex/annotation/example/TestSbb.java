/*
 * JSLEE Annotations
 * Copyright (C) 2015-2022 Piotr Grabowski
 */

package com.jsleex.annotation.example;

import com.jsleex.annotation.*;
import com.jsleex.annotation.Sbb;

import javax.slee.*;

@Service(name = "TestService", vendor = "TestVendor", version = "TestVersion")
@Sbb(name = "TestSbb", vendor = "TestVendor", version = "TestVersion")
@SbbRef(name = "ExampleChild", vendor = "TestVendor", version = "TestVersion", alias = "exampleChild")
@EnvEntry(envEntryName = "test1", envEntryType = java.lang.String.class, envEntryValue = "test1")
@ProfileSpecRef(profileSpecName = "ExampleProfile", profileSpecVendor = "TestVendor", profileSpecVersion = "TestVersion")
@LibraryRef(name = "ExampleLibrary", vendor = "Test", version = "1.0")
@RaTypeBinding(resourceAdaptorTypeName = "ExampleRA", resourceAdaptorTypeVendor = "Test", resourceAdaptorTypeVersion = "1.0",
        resourceAdaptorEntityLinks = "test-entity", resourceAdaptorObjectNames = "test-object")
public abstract class TestSbb implements javax.slee.Sbb {

    // JSLEE SBB required methods
    @Override
    public void setSbbContext(SbbContext sbbContext) {
        //empty
    }

    @Override
    public void unsetSbbContext() {
        //empty
    }

    @Override
    public void sbbCreate() throws CreateException {
        //empty
    }

    @Override
    public void sbbPostCreate() throws CreateException {
        //empty
    }

    @Override
    public void sbbActivate() {
        //empty
    }

    @Override
    public void sbbPassivate() {
        //empty
    }

    @Override
    public void sbbLoad() {
        //empty
    }

    @Override
    public void sbbStore() {
        //empty
    }

    @Override
    public void sbbRemove() {
        //empty
    }

    @Override
    public void sbbExceptionThrown(Exception e, Object o, ActivityContextInterface activityContextInterface) {
        //empty
    }

    @Override
    public void sbbRolledBack(RolledBackContext rolledBackContext) {
        //empty
    }

    // Some CMP fields

    @CmpMethod
    public abstract int getCountOfExample();
    public abstract void setCountOfExample(int count);

    @CmpMethod
    public abstract String getSomeString();
    public abstract void setSomeString(String someString);

    @ChildRelationMethod(sbbAliasRef = "exampleChild")
    public abstract ChildRelation getExampleChild();

    @EventMethod(eventTypeName = "ExampleEvent", eventTypeVendor = "Test", eventTypeVersion = "1.0",
            initialEventSelectVariable = { EventMethod.InitialEventSelectVariable.ACTIVITY_CONTEXT, EventMethod.InitialEventSelectVariable.EVENT},
            initialEvent = true)
    public void onExampleEvent(Object event, ActivityContextInterface aci) {

    }

    @EventMethod(eventTypeName = "ExampleEvent", eventTypeVendor = "Test", eventTypeVersion = "1.0")
    public abstract void fireExampleEvent(Object event, ActivityContextInterface aci, Address address);
}

/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.example;

import javax.slee.*;

public abstract class TestParent implements Sbb, TestCmpInterface {
    @Override
    public void setSbbContext(SbbContext sbbContext) {

    }

    @Override
    public void unsetSbbContext() {

    }

    @Override
    public void sbbCreate() throws CreateException {

    }

    @Override
    public void sbbPostCreate() throws CreateException {

    }

    @Override
    public void sbbActivate() {

    }

    @Override
    public void sbbPassivate() {

    }

    @Override
    public void sbbLoad() {

    }

    @Override
    public void sbbStore() {

    }

    @Override
    public void sbbRemove() {

    }

    @Override
    public void sbbExceptionThrown(Exception e, Object o, ActivityContextInterface activityContextInterface) {

    }

    @Override
    public void sbbRolledBack(RolledBackContext rolledBackContext) {

    }
}

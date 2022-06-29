package com.jsleex.annotation.example;

import javax.slee.ActivityContextInterface;

public abstract class TestXDocletParent extends TestParent {

    /** @slee.cmp-method */
    public abstract int getCount();

    /** @slee.cmp-method */
    public abstract void setCount(int count);

    /** ACI CMP method for local
     * SLEE CMP Method
     * @slee.cmp-method
     */
    public abstract void setAci_local(ActivityContextInterface local);

    /** ACI CMP method for local
     * SLEE CMP Method
     * @slee.cmp-method
     */
    public abstract ActivityContextInterface getAci_local();
}

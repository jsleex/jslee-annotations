package com.jsleex.annotation.processor;

import com.jsleex.annotation.EjbRef;
import com.jsleex.annotation.processor.xml.sbb.EjbRefName;
import com.jsleex.annotation.processor.xml.sbb.EjbRefType;
import com.jsleex.annotation.processor.xml.sbb.Home;
import com.jsleex.annotation.processor.xml.sbb.Remote;

public final class EjbRefTransform {
    private EjbRefTransform() {
        //empty
    }

    public static com.jsleex.annotation.processor.xml.sbb.EjbRef toXml(EjbRef ejbRef) {
        final com.jsleex.annotation.processor.xml.sbb.EjbRef result = new com.jsleex.annotation.processor.xml.sbb.EjbRef();
        final EjbRefName ejbRefName = new EjbRefName();
        ejbRefName.setvalue(ejbRef.ejbRefName());
        result.setEjbRefName(ejbRefName);
        final EjbRefType ejbRefType = new EjbRefType();
        ejbRefType.setvalue(ejbRef.ejbRefType().toString());
        result.setEjbRefType(ejbRefType);
        final Home home = new Home();
        home.setvalue(ejbRef.home());
        result.setHome(home);
        final Remote remote = new Remote();
        remote.setvalue(ejbRef.remote());
        result.setRemote(remote);

        return result;
    }
}

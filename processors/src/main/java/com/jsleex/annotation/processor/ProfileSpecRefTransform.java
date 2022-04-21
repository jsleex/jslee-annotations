package com.jsleex.annotation.processor;

import com.jsleex.annotation.ProfileSpecRef;
import com.jsleex.annotation.processor.xml.sbb.ProfileSpecAlias;
import com.jsleex.annotation.processor.xml.common.ProfileSpecName;
import com.jsleex.annotation.processor.xml.common.ProfileSpecVendor;
import com.jsleex.annotation.processor.xml.common.ProfileSpecVersion;

public final class ProfileSpecRefTransform {
    private ProfileSpecRefTransform() {
        //empty
    }

    public static com.jsleex.annotation.processor.xml.sbb.ProfileSpecRef toXml(ProfileSpecRef profileSpecRef) {
        com.jsleex.annotation.processor.xml.sbb.ProfileSpecRef profileSpecRefXml = new com.jsleex.annotation.processor.xml.sbb.ProfileSpecRef();
        final ProfileSpecName profileSpecName = new ProfileSpecName();
        profileSpecName.setvalue(profileSpecRef.profileSpecName());
        profileSpecRefXml.setProfileSpecName(profileSpecName);
        final ProfileSpecVendor profileSpecVendor = new ProfileSpecVendor();
        profileSpecVendor.setvalue(profileSpecRef.profileSpecVendor());
        profileSpecRefXml.setProfileSpecVendor(profileSpecVendor);
        final ProfileSpecVersion profileSpecVersion = new ProfileSpecVersion();
        profileSpecVersion.setvalue(profileSpecRef.profileSpecVersion());
        profileSpecRefXml.setProfileSpecVersion(profileSpecVersion);
        if (!profileSpecRef.profileSpecAlias().isEmpty()) {
            final ProfileSpecAlias profileSpecAlias = new ProfileSpecAlias();
            profileSpecAlias.setvalue(profileSpecRef.profileSpecAlias());
            profileSpecRefXml.setProfileSpecAlias(profileSpecAlias);
        }
        return profileSpecRefXml;
    }
}

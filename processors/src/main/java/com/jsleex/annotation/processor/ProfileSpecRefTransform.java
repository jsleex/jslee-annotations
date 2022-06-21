/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import com.jsleex.annotation.ProfileSpecRef;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class ProfileSpecRefTransform {
    private ProfileSpecRefTransform() {
        //empty
    }

    public static Element toXml(ProfileSpecRef profileSpecRef, Document doc) {
        final Element profileSpecRefXml = doc.createElement("profile-spec-ref");
        final Element profileSpecName = doc.createElement("profile-spec-name");
        profileSpecName.setTextContent(profileSpecRef.profileSpecName());
        profileSpecRefXml.appendChild(profileSpecName);
        final Element profileSpecVendor = doc.createElement("profile-spec-vendor");
        profileSpecVendor.setTextContent(profileSpecRef.profileSpecVendor());
        profileSpecRefXml.appendChild(profileSpecVendor);
        final Element profileSpecVersion = doc.createElement("profile-spec-version");
        profileSpecVersion.setTextContent(profileSpecRef.profileSpecVersion());
        profileSpecRefXml.appendChild(profileSpecVersion);
        if (!profileSpecRef.profileSpecAlias().isEmpty()) {
            final Element profileSpecAlias = doc.createElement("profile-spec-alias");
            profileSpecAlias.setTextContent(profileSpecRef.profileSpecAlias());
            profileSpecRefXml.appendChild(profileSpecAlias);
        }
        return profileSpecRefXml;
    }
}

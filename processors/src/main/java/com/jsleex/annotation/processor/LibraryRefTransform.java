package com.jsleex.annotation.processor;

import com.jsleex.annotation.LibraryRef;
import com.jsleex.annotation.processor.xml.common.LibraryName;
import com.jsleex.annotation.processor.xml.common.LibraryVendor;
import com.jsleex.annotation.processor.xml.common.LibraryVersion;

public class LibraryRefTransform {
    private LibraryRefTransform() {
        //empty
    }

    public static com.jsleex.annotation.processor.xml.common.LibraryRef toXml(LibraryRef profileSpecRef) {
        final com.jsleex.annotation.processor.xml.common.LibraryRef libraryRefXml = new com.jsleex.annotation.processor.xml.common.LibraryRef();
        final LibraryName libraryName = new LibraryName();
        libraryName.setvalue(profileSpecRef.name());
        libraryRefXml.setLibraryName(libraryName);
        final LibraryVendor libraryVendor = new LibraryVendor();
        libraryVendor.setvalue(profileSpecRef.vendor());
        libraryRefXml.setLibraryVendor(libraryVendor);
        final LibraryVersion libraryVersion = new LibraryVersion();
        libraryVersion.setvalue(profileSpecRef.version());
        libraryRefXml.setLibraryVersion(libraryVersion);
        return libraryRefXml;
    }
}

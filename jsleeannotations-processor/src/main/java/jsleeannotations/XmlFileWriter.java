/*
 * JSLEE Annotations
 * Copyright (c) 2015 Piotr Grabowski, All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */

package jsleeannotations;

import javax.annotation.processing.Filer;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.Writer;

class XmlFileWriter<T> {
    private final String doctype;
    private final JAXBContext context;
    private final Marshaller marshaller;
    private final String outputFilename;

    XmlFileWriter(Class<T> xmlObjectsClass, String outputFilename, String doctype) throws JAXBException {
        this.outputFilename = outputFilename;
        this.doctype = doctype;
        context = JAXBContext.newInstance(xmlObjectsClass);
        marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        marshaller.setProperty("jaxb.encoding", "UTF-8");
    }

    void write(Filer filer, T objectToWrite) throws IOException, JAXBException {
        FileObject fileObject = filer.createResource(StandardLocation.SOURCE_OUTPUT, "", outputFilename, null);
        try (Writer writer = fileObject.openWriter()) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + doctype);
            marshaller.marshal(objectToWrite, writer);
        }
    }
}

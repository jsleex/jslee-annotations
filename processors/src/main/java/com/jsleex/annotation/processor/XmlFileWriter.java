/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation.processor;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

class XmlFileWriter {
    private final String outputFilename;
    private final Transformer transformer;

    XmlFileWriter(String outputFilename, String doctypePublic, String doctypeSystem) throws JSleeXProcessorException {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            this.transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, doctypePublic);
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctypeSystem);
        } catch (TransformerConfigurationException e) {
            throw new JSleeXProcessorException("Unable to initialize XML writer.", e);
        }
        this.outputFilename = outputFilename;
    }

    void write(Filer filer, Document doc) throws TransformerException, IOException {
        final FileObject fileObject = filer.createResource(StandardLocation.CLASS_OUTPUT, "", outputFilename);
        try (final Writer writer = fileObject.openWriter()) {
            doc.setXmlStandalone(true);
            final DOMSource source = new DOMSource(doc);
            final StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
        }
    }
}

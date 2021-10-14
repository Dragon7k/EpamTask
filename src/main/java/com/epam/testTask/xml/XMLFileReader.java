package com.epam.testTask.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLFileReader {
    private final String fileName;

    public XMLFileReader(String fileName) {
        this.fileName = fileName;
    }

    public Document buildDocument() throws ParserConfigurationException, IOException, SAXException {
        File file = new File(fileName);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        return documentBuilderFactory.newDocumentBuilder().parse(file);
    }

    public NodeList prepare() {
        try {
            Document document = buildDocument();
            if (document != null) {
                Node rootNode = document.getFirstChild();
                if (rootNode != null) {
                    return rootNode.getChildNodes();
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return null;
    }
}

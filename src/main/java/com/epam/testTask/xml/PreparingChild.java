package com.epam.testTask.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class PreparingChild {
    private String fileName;
    private NodeList rootChild;
    public PreparingChild(String fileName) {
        this.fileName = fileName;
    }
    public NodeList getRootChild() {
        return rootChild;
    }
    public void prepare() {
        Node rootNode;
        Document document;

        XMLFileReader xmlFileReader = new XMLFileReader(fileName);
        try {
            document = xmlFileReader.buildDocument();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
            return;
        }
        if (document != null) {
            rootNode = document.getFirstChild();
        } else {
            return;
        }
        if (rootNode != null) {
            rootChild = rootNode.getChildNodes();
        } else {
            return;
        }
    }
}

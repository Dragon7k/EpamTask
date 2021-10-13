package com.epam.testTask.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class PreparingChild {
    private static Node rootNode = null;
    private static NodeList rootChild = null;
    private static Document document = null;

    public static NodeList prepare(){

        XMLFileReader xmlFileReader = new XMLFileReader("src/main/resources/input.xml");
        try {
            document = xmlFileReader.buildDocument();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        if (document != null) {
            rootNode = document.getFirstChild();
        }
        if (rootNode != null) {
            rootChild = rootNode.getChildNodes();
        }

        return rootChild;

    }
}

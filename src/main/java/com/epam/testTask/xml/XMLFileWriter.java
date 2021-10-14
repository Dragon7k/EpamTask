package com.epam.testTask.xml;

import com.epam.testTask.model.Company;
import com.epam.testTask.model.Device;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLFileWriter {
    private Company company;
    private String fileOut;

    public XMLFileWriter(Company company,String fileOut) {
        this.company = company;
        this.fileOut = fileOut;
    }

    public void toXML(){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document out = docBuilder.newDocument();
            Element rootElem = out.createElement("Devices");
            out.appendChild(rootElem);
            if(company.getDevices()!=null){
                for (Device dev : company.getDevices()) {
                    rootElem.appendChild(createNode(dev, dev.getClass().getSimpleName(), out));
                }
            }else{
                return;
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource dom = new DOMSource(out);
            StreamResult result = new StreamResult(new File(fileOut));
            transformer.transform(dom, result);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private Element createNode(Device device, String name, Document doc){
        Element out = doc.createElement(name);
        Attr cost = doc.createAttribute("cost");
        cost.setValue(device.getCost()*company.getEmployee() + "");
        out.setAttributeNode(cost);
        Attr weight = doc.createAttribute("weight");
        weight.setValue(device.getWeight()*company.getEmployee() + "");
        out.setAttributeNode(weight);
        return out;
    }
}

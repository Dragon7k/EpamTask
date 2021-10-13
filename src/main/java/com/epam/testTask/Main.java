package com.epam.testTask;

import com.epam.testTask.model.Company;
import com.epam.testTask.xml.DOMParser;
import com.epam.testTask.xml.PreparingChild;
import com.epam.testTask.xml.XMLFileWriter;
import org.w3c.dom.NodeList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NodeList rootChild = new PreparingChild("src/main/resources/input.xml").prepare();
        DOMParser domParser = new DOMParser();
        if (rootChild != null) {
            domParser.parseDevices(rootChild);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("count of employee: ");
        Company company = new Company(scanner.nextInt(), domParser.getDeviceList());
        new XMLFileWriter(company,"src/main/resources/output.xml").toXML();
    }
}

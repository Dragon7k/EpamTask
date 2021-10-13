package com.epam.testTask.xml;

import com.epam.testTask.model.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMParser {

    private List<Device> deviceList = new ArrayList<>();
    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void parseDevices(NodeList rootChild) {
        NodeList childNode;
        for (int i = 0; i < rootChild.getLength(); i++) {
            Node root = rootChild.item(i);
            if (root.getNodeType() == Node.ELEMENT_NODE) {
                childNode = root.getChildNodes();
                switch (root.getNodeName()) {
                    case "Phone" -> deviceList.add(setValue(new Phone(), childNode));
                    case "DesktopComputer" -> deviceList.add(setValue(new DesktopComputer(), childNode));
                    case "Tablet" -> deviceList.add(setValue(new Tablet(), childNode));
                }
            }
        }
    }

    public Device setValue(Device device, NodeList root) {
        for (int i = 0; i < root.getLength(); i++) {
            Node childNode = root.item(i);
            switch (childNode.getNodeName()) {
                case "name" -> device.setName(childNode.getTextContent());
                case "cost" -> device.setCost(Integer.parseInt(childNode.getTextContent()));
                case "weight" -> device.setWeight(Integer.parseInt(childNode.getTextContent()));
                case "model" -> {
                    if (device instanceof Phone) {
                        ((Phone) device).setModel(childNode.getTextContent());
                    }
                }
                case "cpuModel" -> {
                    if (device instanceof Computer) {
                        ((Computer) device).setCpuModel(childNode.getTextContent());
                    }
                }
                case "gpuModel" -> {
                    if (device instanceof DesktopComputer) {
                        ((DesktopComputer) device).setGpuModel(childNode.getTextContent());
                    }
                }
                case "resolution" -> {
                    if (device instanceof Tablet) {
                        ((Tablet) device).setResolution(Integer.parseInt(childNode.getTextContent()));
                    }
                }
            }
        }
        return device;
    }
}

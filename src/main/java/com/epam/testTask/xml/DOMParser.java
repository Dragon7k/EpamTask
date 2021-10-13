package com.epam.testTask.xml;

import com.epam.testTask.model.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMParser {
    private NodeList childNode;
    private List<Device> deviceList = new ArrayList<>();
    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void parseDevices(NodeList rootChild) {
        for (int i = 0; i < rootChild.getLength(); i++) {
            if (rootChild.item(i).getNodeType() == Node.ELEMENT_NODE) {
                childNode = rootChild.item(i).getChildNodes();
                switch (rootChild.item(i).getNodeName()) {
                    case "Phone" ->    deviceList.add(setValue(new Phone(), childNode));
                    case "DesktopComputer" ->  deviceList.add(setValue(new DesktopComputer(), childNode));
                    case "Tablet" ->deviceList.add(setValue(new Tablet(), childNode));
                }
            }
        }
    }

    public Device setValue(Device device, NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            switch (nodeList.item(i).getNodeName()) {
                case "name" -> device.setName(childNode.item(i).getTextContent());
                case "cost" -> device.setCost(Integer.parseInt(childNode.item(i).getTextContent()));
                case "weight" -> device.setWeight(Integer.parseInt(childNode.item(i).getTextContent()));
                case "model" -> {
                    if (device instanceof Phone) {
                        ((Phone) device).setModel(childNode.item(i).getTextContent());
                    }
                }
                case "cpuModel" -> {
                    if (device instanceof Computer) {
                        ((Computer) device).setCpuModel(childNode.item(i).getTextContent());
                    }
                }
                case "gpuModel" -> {
                    if (device instanceof DesktopComputer) {
                        ((DesktopComputer) device).setGpuModel(childNode.item(i).getTextContent());
                    }
                }
                case "resolution" -> {
                    if (device instanceof Tablet) {
                        ((Tablet) device).setResolution(Integer.parseInt(childNode.item(i).getTextContent()));
                    }
                }
            }
        }
        return device;
    }
}

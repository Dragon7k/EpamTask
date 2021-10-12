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

    public void parceDevices(NodeList rootChild) {

        for (int i = 0; i < rootChild.getLength(); i++) {

            if (rootChild.item(i).getNodeType() == Node.ELEMENT_NODE) {

                childNode = rootChild.item(i).getChildNodes();
                switch (rootChild.item(i).getNodeName()) {
                    case "Phone" ->  /*for (int j = 0; j < childNode.getLength(); j++) {
                            if (childNode.item(j).getNodeType() == Node.ELEMENT_NODE) {

                                switch (childNode.item(j).getNodeName()) {
                                    case "name" -> phone.setName(childNode.item(j).getTextContent());
                                    case "cost" -> phone.setCost(Integer.parseInt(childNode.item(j).getTextContent()));
                                    case "weight" -> phone.setWeight(Integer.parseInt(childNode.item(j).getTextContent()));
                                    case "model" -> phone.setModel(childNode.item(j).getTextContent());
                                }

                            }

                        }*/  deviceList.add(setValue(new Phone(), childNode));

                    case "DesktopComputer" -> /* DesktopComputer desktopComputer = new DesktopComputer();

                        childNode = rootChild.item(i).getChildNodes();
                        setValue(desktopComputer,childNode);*//* for (int j = 0; j < childNode.getLength(); j++) {
                            if (childNode.item(j).getNodeType() == Node.ELEMENT_NODE) {
                                setValue(desktopComputer,childNode);
                                switch (childNode.item(j).getNodeName()) {
                                    case "cpuModel" -> desktopComputer.setCpuModel(childNode.item(j).getTextContent());
                                    case "gpuModel" -> desktopComputer.setGpuModel(childNode.item(j).getTextContent());
                                }

                            }
                        }*/ deviceList.add(setValue(new DesktopComputer(), childNode));

                    case "Tablet" ->/*for (int j = 0; j < childNode.getLength(); j++) {
                            if (childNode.item(j).getNodeType() == Node.ELEMENT_NODE) {
                                setValue(tablet,childNode);
                                switch (childNode.item(j).getNodeName()) {
                                    case "cpuModel" -> tablet.setCpuModel(childNode.item(j).getTextContent());
                                    case "resolution" -> tablet.setResolution(Integer.parseInt(childNode.item(j).getTextContent()));
                                }
                            }

                        }*/deviceList.add(setValue(new Tablet(), childNode));

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

package com.epam.testTask.xml;

import com.epam.testTask.model.DesktopComputer;
import com.epam.testTask.model.Device;
import com.epam.testTask.model.Phone;
import com.epam.testTask.model.Tablet;
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

    public List<Device> parceDevices(NodeList rootChild) {

        for (int i = 0; i < rootChild.getLength(); i++) {

            if (rootChild.item(i).getNodeType() == Node.ELEMENT_NODE) {
                /*System.out.println(rootChild.item(i).getNodeName());*/
                switch (rootChild.item(i).getNodeName()) {
                    case "Phone":

                        Phone phone = new Phone();
                        childNode = rootChild.item(i).getChildNodes();
                        for (int j = 0; j < childNode.getLength(); j++) {
                            if (childNode.item(j).getNodeType() == Node.ELEMENT_NODE) {

                                switch (childNode.item(j).getNodeName()) {

                                    case "name":
                                        phone.setName(childNode.item(j).getTextContent());
                                        break;
                                    case "coast":
                                        phone.setCoast(Integer.parseInt(childNode.item(j).getTextContent()));
                                        break;
                                    case "weight":
                                        phone.setWeight(Integer.parseInt(childNode.item(j).getTextContent()));
                                        break;
                                    case "model":
                                        phone.setModel(childNode.item(j).getTextContent());
                                        break;

                                }

                            }

                        }
                        deviceList.add(phone);
                        break;

                    case "DesktopComputer":
                        DesktopComputer desktopComputer = new DesktopComputer();
                        childNode = rootChild.item(i).getChildNodes();
                        for (int j = 0; j < childNode.getLength(); j++) {
                            if (childNode.item(j).getNodeType() == Node.ELEMENT_NODE) {
                                switch (childNode.item(j).getNodeName()) {

                                    case "name":
                                        desktopComputer.setName(childNode.item(j).getTextContent());
                                        break;
                                    case "coast":
                                        desktopComputer.setCoast(Integer.parseInt(childNode.item(j).getTextContent()));
                                        break;
                                    case "weight":
                                        desktopComputer.setWeight(Integer.parseInt(childNode.item(j).getTextContent()));
                                        break;
                                    case "cpuModel":
                                        desktopComputer.setCpuModel(childNode.item(j).getTextContent());
                                        break;
                                    case "gpuModel":
                                        desktopComputer.setGpuModel(childNode.item(j).getTextContent());
                                        break;

                                }

                            }
                        }
                        deviceList.add(desktopComputer);
                        break;

                    case "Tablet":
                        Tablet tablet = new Tablet();
                        childNode = rootChild.item(i).getChildNodes();
                        for (int j = 0; j < childNode.getLength(); j++) {
                            if (childNode.item(j).getNodeType() == Node.ELEMENT_NODE) {
                                switch (childNode.item(j).getNodeName()) {

                                    case "name":
                                        tablet.setName(childNode.item(j).getTextContent());
                                        break;
                                    case "coast":
                                        tablet.setCoast(Integer.parseInt(childNode.item(j).getTextContent()));
                                        break;
                                    case "weight":
                                        tablet.setWeight(Integer.parseInt(childNode.item(j).getTextContent()));
                                        break;
                                    case "cpuModel":
                                        tablet.setCpuModel(childNode.item(j).getTextContent());
                                        break;
                                    case "gpuModel":
                                        tablet.setResolution(Integer.parseInt(childNode.item(j).getTextContent()));
                                        break;

                                }
                            }

                        }
                        deviceList.add(tablet);
                        break;

                }
            }

        }


        return deviceList;
    }

}

package com.epam.testTask.model;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private int employee;
    private List<Device> devices;

    public Company(int employee, List<Device> devices) {
        this.employee = employee;
        this.devices = devices;
    }

    public int getEmployee() {
        return employee;
    }

    public List<Device> getDevices() {
        return devices;
    }

}

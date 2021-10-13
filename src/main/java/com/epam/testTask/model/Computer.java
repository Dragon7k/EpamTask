package com.epam.testTask.model;

public class Computer extends Device {

    private String cpuModel;

    public Computer() {
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }
}

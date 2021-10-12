package com.epam.testTask.model;

public class Computer extends Device{

    private String cpuModel;

    public Computer(String name, int coast, int weight,String cpuModel) {
        super(name, coast, weight);
        this.cpuModel=cpuModel;
    }

    public Computer() {
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }
}

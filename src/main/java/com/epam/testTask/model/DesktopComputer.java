package com.epam.testTask.model;


public class DesktopComputer extends Computer {
    private String gpuModel;

    public DesktopComputer(String name, int coast, int weight, String cpuModel, String gpuModel) {
        super(name, coast, weight, cpuModel);
        this.gpuModel=gpuModel;
    }

    public DesktopComputer() {
    }

    public String getGpuModel() {
        return gpuModel;
    }

    public void setGpuModel(String gpuModel) {
        this.gpuModel = gpuModel;
    }
}

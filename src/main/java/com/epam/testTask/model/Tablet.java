package com.epam.testTask.model;


public class Tablet extends Computer {
    private int resolution;
    public Tablet(String name, int coast, int weight, String cpuModel, int resolution) {
        super(name, coast, weight, cpuModel);
        this.resolution= resolution;
    }

    public Tablet() {
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }
}

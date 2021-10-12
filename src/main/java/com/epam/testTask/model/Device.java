package com.epam.testTask.model;


public abstract class Device {
    protected String name;
    protected int coast;
    protected int weight;

    public Device(String name, int coast, int weight) {
        super();
        this.name = name;
        this.coast = coast;
        this.weight = weight;
    }

    public Device() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoast() {
        return coast;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

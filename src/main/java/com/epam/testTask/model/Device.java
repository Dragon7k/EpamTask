package com.epam.testTask.model;


public abstract class Device {
    protected String name;
    protected int cost;
    protected int weight;

    public Device(String name, int cost, int weight) {
        super();
        this.name = name;
        this.cost = cost;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

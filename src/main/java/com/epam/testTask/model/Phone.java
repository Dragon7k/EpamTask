package com.epam.testTask.model;

public class Phone extends Device{
    private String model;

    public Phone(String name, int coast, int weight, String model) {
        super(name, coast, weight);
        this.model=model;
    }

    public Phone() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

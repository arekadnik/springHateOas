package com.example.demo.model;

import org.springframework.hateoas.RepresentationModel;

public class Car extends RepresentationModel {
    private long carID;
    private String brand;
    private String model;
    private Color color;

    public long getCarID() {
        return carID;
    }

    public void setCarID(long carID) {
        this.carID = carID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Car() {
    }

    public Car(long carID, String brand, String model, Color color) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }
}

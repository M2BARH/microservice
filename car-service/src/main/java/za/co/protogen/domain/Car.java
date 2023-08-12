package za.co.protogen.domain;

import java.util.ArrayList;

// Car entity
public class Car {

    private String make;
    private String model;
    private int year;
    private String color;
    private String engine;
    private String transmission;
    private String fuelType;
    private double mileage;
    private String vin;
    private double price;
    private double ownerId;
    private ArrayList<String> features;

    // null args constructor
    public Car() {
    }

    // start of getters and setters methods for Car entity
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(double ownerId) {
        this.ownerId = ownerId;
    }

    public ArrayList<String> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<String> features) {
        this.features = features;
    }
    // end of getters and setters

    // toString method which, help format the printed results in Application class
    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", mileage=" + mileage +
                ", vin='" + vin + '\'' +
                ", price=" + price +
                ", ownerId=" + ownerId +
                ", features=" + features +
                '}';
    }
}

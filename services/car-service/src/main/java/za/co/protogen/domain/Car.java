package za.co.protogen.domain;

import jakarta.persistence.*;

import java.util.ArrayList;

// Car entity
@Entity
@Table(name = "car")
public class Car {


    @Id
    @SequenceGenerator(name = "car-sequence", sequenceName = "car-sequence", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    @Column(name = "vin")
    private String vin;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "car_year")
    private int carYear;
    @Column(name = "color")
    private String color;
    @Column(name = "engine")
    private String engine;
    @Column(name = "transmission")
    private String transmission;
    @Column(name = "fuel_type")
    private String fuelType;
    @Column(name = "mileage")
    private double mileage;
    @Column(name = "price")
    private double price;
    @Column(name = "owner_id")
    private double ownerId;
    @Column(name = "features")
    private ArrayList<String> features;

    public Car(Long id, String vin, String make, String model, int carYear,
               String color, String engine, String transmission, String fuelType,
               double mileage, double price, double ownerId, ArrayList<String> features) {
        this.id = id;
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.carYear = carYear;
        this.color = color;
        this.engine = engine;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.mileage = mileage;
        this.price = price;
        this.ownerId = ownerId;
        this.features = features;
    }

    // null args constructor
    public Car() {
    }

    // start of getters and setters methods for Car entity
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
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
        return "Car: {" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", carYear=" + carYear + '\'' +
                ", color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", mileage=" + mileage +
                ", vin='" + vin + '\'' +
                ", price=" + price + '\'' +
                ", ownerId=" + ownerId + '\'' +
                ", features=" + features +
                '}';
    }
}

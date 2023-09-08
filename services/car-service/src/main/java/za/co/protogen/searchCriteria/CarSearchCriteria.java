package za.co.protogen.searchCriteria;

import io.swagger.models.auth.In;
import jakarta.persistence.Column;

import java.util.ArrayList;

public class CarSearchCriteria {
    private Long id;
    private String vin;
    private String make;
    private String model;
    private Integer carYear;
    private String color;
    private String engine;
    private String transmission;
    private String fuelType;
    private Double mileage;
    private Double price;
    private Double ownerId;
    private ArrayList<String> features;

    public void setId(Long id) {
        this.id = id;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCarYear(Integer carYear) {
        this.carYear = carYear;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setOwnerId(Double ownerId) {
        this.ownerId = ownerId;
    }

    public void setFeatures(ArrayList<String> features) {
        this.features = features;
    }

    public Long getId() {
        return id;
    }

    public String getVin() {
        return vin;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Integer getCarYear() {
        return carYear;
    }

    public String getColor() {
        return color;
    }

    public String getEngine() {
        return engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getFuelType() {
        return fuelType;
    }

    public Double getMileage() {
        return mileage;
    }

    public Double getPrice() {
        return price;
    }

    public Double getOwnerId() {
        return ownerId;
    }

    public ArrayList<String> getFeatures() {
        return features;
    }
}

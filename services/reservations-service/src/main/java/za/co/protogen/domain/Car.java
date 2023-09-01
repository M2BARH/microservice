package za.co.protogen.domain;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private Long id;
    private String vin;
    private String make;
    private String model;
    private int carYear;
    private String color;
    private String engine;
    private String transmission;
    private String fuelType;
    private double mileage;
    private double price;
    private double ownerId;
    private ArrayList<String> features;
}

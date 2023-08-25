package za.co.protogen.core;

import za.co.protogen.domain.Car;
import za.co.protogen.searchCriteria.CarSearchCriteria;

import java.util.List;

// CarService interface implemented by CarServiceImpl class
public interface CarService {

    // interface method that are implemented in CarServiceImpl class
    void addCar(Car car); // add car object to a cars list

    void removeCar(String vin); // remove car object from cars list

    Car getCarById(Long id); // get car by its unique identifier(id)

    Car getCarByVin(String vin); // get car by its unique identifier(vin)

    List<Car> getAllCars(); // retrieve a list of all cars in a car list

    List<Car> getCarsByMake(String make); // retrieve a list of identified by make in a car list

    List<Car> getCarByYear(int carYear); // retrieve a list of identified by year in a car list

    List<Car> getCarsByColor(String color); // retrieve a list of identified by color in a car list

    void updateCar(String vin, Car updatedCar); // update the car attributes for a car identified by vin

    double calculateAverageMileage(); // calculate average mileage of all cars within a cars list

    Car findCheapestCar(); // retrieve a cheapest car in a cars list

    Car findMostExpensiveCar(); // retrieve a most expensive car in a cars list

    Car findNewestCar(); // retrieve the newest can in a cars list

    Car findOldestCar(); // retrieve the oldest can in a cars list

    List<Car> searchCars(CarSearchCriteria criteria);  // retrieve a list of all cars identified by given attributes
}

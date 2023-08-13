package za.co.protogen.core.impl;

import org.springframework.stereotype.Service;
import za.co.protogen.core.CarService;
import za.co.protogen.domain.Car;
import za.co.protogen.utility.Constants;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// CarService class which implements the car service interface
@Service
public class CarServiceImpl implements CarService {

    @Override
    public void addCar(Car car) {
        Constants.cars.add(car);
    }

    @Override
    public void removeCar(String vin) {
        Constants.cars.removeIf(car -> car.getVin().equals(vin));
    }

    @Override
    public Car getCarById(String vin) {
        return Constants.cars.stream().filter(car -> car.getVin().equals(vin)).findFirst().orElse(null);
    }

    @Override
    public List<Car> getAllCars() {
        return Constants.cars;
    }

    @Override
    public List<Car> getCarsByMake(String make) {
        return Constants.cars.stream().filter(car -> car.getMake().toLowerCase().equalsIgnoreCase(make)).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarByYear(int year) {
        return Constants.cars.stream().filter(car -> car.getYear() == year).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarByColor(String color) {
        return Constants.cars.stream().filter(car -> car.getColor().toLowerCase().equalsIgnoreCase(color)).collect(Collectors.toList());
    }

    @Override
    public void updateCar(String vin, Car updatedCar) {
        Car existingCar = getCarById(vin);
        if (existingCar != null) {
            existingCar.setMake(updatedCar.getMake());
            existingCar.setModel(updatedCar.getModel());
            existingCar.setYear(updatedCar.getYear());
            existingCar.setColor(updatedCar.getColor());
            existingCar.setEngine(updatedCar.getEngine());
            existingCar.setTransmission(updatedCar.getTransmission());
            existingCar.setFuelType(updatedCar.getFuelType());
            existingCar.setMileage(updatedCar.getMileage());
            existingCar.setVin(updatedCar.getVin());
            existingCar.setPrice(updatedCar.getPrice());
            existingCar.setOwnerId(updatedCar.getOwnerId());
            existingCar.setFeatures(updatedCar.getFeatures());
        }
    }

    @Override
    public double calculateAverageMileage() {
        double totalMileage = Constants.cars.stream().mapToDouble(Car::getMileage).sum();
        return  totalMileage / Constants.cars.size();
    }

    @Override
    public Car findCheapestCar() {
        return Constants.cars.stream().min(Comparator.comparingDouble(Car::getPrice)).orElse(null);
    }

    @Override
    public Car findMostExpensiveCar() {
        return Constants.cars.stream().max(Comparator.comparingDouble(Car::getPrice)).orElse(null);
    }

    @Override
    public Car findNewestCar() {
        return Constants.cars.stream().max(Comparator.comparingInt(Car::getYear)).orElse(null);
    }

    @Override
    public Car findOldestCar() {
        return Constants.cars.stream().min(Comparator.comparingInt(Car::getYear)).orElse(null);
    }

    @Override
    public List<Car> searchCars(String make, String model, int year, String color, String engine, String transmission, String fuelType, int mileage, int ownerId, double minPrice, double maxPrice) {
        return Constants.cars.stream().filter(car -> car.getMake().toLowerCase().equalsIgnoreCase(make) ||
                car.getModel().toLowerCase().equalsIgnoreCase(model) ||
                car.getYear() == year ||
                car.getColor().toLowerCase().equalsIgnoreCase(color) ||
                car.getEngine().toLowerCase().equalsIgnoreCase(engine) ||
                car.getTransmission().toLowerCase().equalsIgnoreCase(transmission) ||
                car.getFuelType().toLowerCase().equalsIgnoreCase(fuelType) ||
                car.getMileage() == mileage ||
                car.getOwnerId() == ownerId ||
                car.getPrice() >= minPrice ||
                car.getPrice() <= maxPrice).collect(Collectors.toList());
    }
}

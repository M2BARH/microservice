package za.co.protogen.core.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.protogen.core.CarService;
import za.co.protogen.domain.Car;
import za.co.protogen.persistence.repository.CarRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// CarService class which implements the car service interface
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void removeCar(String vin) {
        boolean exists = carRepository.existsById(vin);
        if (!exists) {// remove car identified by vin, if it exists
            throw  new IllegalStateException("Car with vin " + vin + " does not exist");
        }
        carRepository.deleteById(vin);
    }

    @Override
    public Car getCarById(String vin) {
        return carRepository.findById(vin).orElse(null);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getCarsByMake(String make) {
        return carRepository.findByMake(make);
    }

    @Override
    public List<Car> getCarByYear(int year) {
        return carRepository.findByYear(year);
    }

    @Override
    public List<Car> getCarByColor(String color) {
        return carRepository.findByColor(color);
    }

    @Override
    public void updateCar(String vin, Car updatedCar) {
        Car existingCar = getCarById(vin);
        if (existingCar != null) {
            existingCar.setMake(updatedCar.getMake());
            existingCar.setModel(updatedCar.getModel());
            existingCar.set_year(updatedCar.get_year());
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
        List<Car> allCars = carRepository.findAll();
        double totalMileage = allCars.stream().mapToDouble(Car::getMileage).sum();
        return  totalMileage / allCars.size();
    }

    @Override
    public Car findCheapestCar() {
        List<Car> allCars = carRepository.findAll();
        return allCars.stream().min(Comparator.comparingDouble(Car::getPrice)).orElse(null);
    }

    @Override
    public Car findMostExpensiveCar() {
        List<Car> allCars = carRepository.findAll();
        return allCars.stream().max(Comparator.comparingDouble(Car::getPrice)).orElse(null);
    }

    @Override
    public Car findNewestCar() {
        List<Car> allCars = carRepository.findAll();
        return allCars.stream().max(Comparator.comparingInt(Car::get_year)).orElse(null);
    }

    @Override
    public Car findOldestCar() {
        List<Car> allCars = carRepository.findAll();
        return allCars.stream().min(Comparator.comparingInt(Car::get_year)).orElse(null);
    }

    @Override
    public List<Car> searchCars(String make, String model, int year, String color, String engine, String transmission,
                                String fuelType, int mileage, int ownerId, double minPrice, double maxPrice) {
        List<Car> allCars = carRepository.findAll();
        return allCars.stream().filter(car -> car.getMake().toLowerCase().equalsIgnoreCase(make) ||
                car.getModel().toLowerCase().equalsIgnoreCase(model) ||
                car.get_year() == year ||
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

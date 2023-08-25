package za.co.protogen.core.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import za.co.protogen.core.CarService;
import za.co.protogen.domain.Car;
import za.co.protogen.exception.CarNotFoundException;
import za.co.protogen.persistence.repository.CarRepository;
import za.co.protogen.searchCriteria.CarSearchCriteria;
import za.co.protogen.specifications.CarSpecifications;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// CarService class which implements the car service interface
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void removeCar(String vin) {
        Car car = carRepository.findByVin(vin);
        if (car == null) {// remove car identified by vin, if it exists
            throw  new IllegalStateException("Car with vin " + vin + " does not exist");
        }
        carRepository.delete(car);
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
    }

    @Override
    public Car getCarByVin(String vin) {
        return carRepository.findByVin(vin);
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
    public List<Car> getCarByYear(int carYear) {
        return carRepository.findByCarYear(carYear);
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return carRepository.findByColor(color);
    }

    @Override
    public void updateCar(String vin, Car updatedCar) {
        Car existingCar = getCarByVin(vin);
        if (existingCar != null) {
            existingCar.setMake(updatedCar.getMake());
            existingCar.setModel(updatedCar.getModel());
            existingCar.setCarYear(updatedCar.getCarYear());
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
        return allCars.stream().max(Comparator.comparingInt(Car::getCarYear)).orElse(null);
    }

    @Override
    public Car findOldestCar() {
        List<Car> allCars = carRepository.findAll();
        return allCars.stream().min(Comparator.comparingInt(Car::getCarYear)).orElse(null);
    }

    @Override
    public List<Car> searchCars(CarSearchCriteria criteria) {
        Specification<Car> spec = CarSpecifications.builderSpecification(criteria);
        return carRepository.findAll(spec);
    }
}

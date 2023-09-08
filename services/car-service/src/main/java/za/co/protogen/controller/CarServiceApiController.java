package za.co.protogen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.protogen.controller.models.CarsApi;
import za.co.protogen.controller.models.CarDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import za.co.protogen.adapter.CarMapper;
import za.co.protogen.core.impl.CarServiceImpl;
import za.co.protogen.domain.Car;
import za.co.protogen.searchCriteria.CarSearchCriteria;

import java.util.List;

@RestController
@RefreshScope
@RequiredArgsConstructor
@RequestMapping
public class CarServiceApiController implements CarsApi {

    private final CarServiceImpl carServiceImpl;
    private final CarMapper carMapper;
    private final Logger logger = LoggerFactory.getLogger(CarServiceApiController.class);

    @Override
    public ResponseEntity<Void> createCar(CarDTO carDTO) {
        logger.info("Adding a car to the database");
        carServiceImpl.addCar(carMapper.dtoToCar(carDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<List<CarDTO>> getAllCars() {
        logger.info("Fetching all cars from the database");
        return ResponseEntity.ok(carMapper.carToDTO(carServiceImpl.getAllCars()));
    }

    @Override
    public ResponseEntity<List<CarDTO>> getCarByCarYear(Integer carYear) {
        logger.info("Fetching all cars identified by year: " + carYear + ",  from the database");
        return ResponseEntity.ok(carMapper.carToDTO(carServiceImpl.getCarByYear(carYear)));
    }

    @Override
    public ResponseEntity<List<CarDTO>> getCarByColor(String color) {
        logger.info("Fetching all cars identified by color: " + color + ",  from the database");
        return ResponseEntity.ok(carMapper.carToDTO(carServiceImpl.getCarsByColor(color)));
    }

    @Override
    public ResponseEntity<List<CarDTO>> getCarByMake(String make) {
        logger.info("Fetching all cars identified by make: " + make + ",  from the database");
        return ResponseEntity.ok(carMapper.carToDTO(carServiceImpl.getCarsByMake(make)));
    }

    @Override
    public ResponseEntity<CarDTO> getCarById(Long id) {
        logger.info("Fetching a car identified by the id: " + id + ", from the database");
        return ResponseEntity.ok(carMapper.carToDTO(carServiceImpl.getCarById(id)));
    }

    @Override
    public ResponseEntity<CarDTO> getCarByVin(String vin) {
        logger.info("Fetching a car identified by the vin: " + vin + ", from the database");
        return ResponseEntity.ok(carMapper.carToDTO(carServiceImpl.getCarByVin(vin)));
    }

    @Override
    public ResponseEntity<Void> removeCar(String vin) {
        logger.info("Removing a car identified by the vin: " + vin + ", from the database");
        carServiceImpl.removeCar(vin);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<List<CarDTO>>
    searchCar(Long id, String vin, String make,
              String model, Integer carYear, String color,
              String engine, String transmission, String fuelType, Double mileage,
              Double price, Double ownerId, List features) {
        logger.info("Searching for a car from the database");
        CarSearchCriteria criteria = new CarSearchCriteria();
        criteria.setId(id);
        criteria.setVin(vin);
        criteria.setMake(make);
        criteria.setModel(model);
        criteria.setCarYear(carYear);
        criteria.setColor(color);
        criteria.setEngine(engine);
        criteria.setTransmission(transmission);
        criteria.setFuelType(fuelType);
        criteria.setMileage(mileage);
        criteria.setPrice(price);
        criteria.setOwnerId(ownerId);

        List<Car> cars = carServiceImpl.searchCars(criteria);
        List<CarDTO> carDTOs = carMapper.carToDTO(cars);
        return ResponseEntity.ok(carDTOs);
    }

    @Override
    public ResponseEntity<Void> updateCar(String vin, CarDTO carDTO) {
        logger.info("Fetching a car identified by vin: " + vin + " and updating it");
        carServiceImpl.updateCar(vin, carMapper.dtoToCar(carDTO));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}

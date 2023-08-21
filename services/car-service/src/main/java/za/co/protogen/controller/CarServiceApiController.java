package za.co.protogen.controller;

import com.example.carservice.api.CarsApi;
import com.example.carservice.models.CarDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import za.co.protogen.adapter.CarMapper;
import za.co.protogen.core.impl.CarServiceImpl;
import za.co.protogen.domain.Car;

import java.util.List;

@RestController
@RefreshScope
@RequiredArgsConstructor
public class CarServiceApiController implements CarsApi {

    private final CarServiceImpl carServiceImpl;
    private final CarMapper carMapper;
    private final Logger logger = LoggerFactory.getLogger(CarServiceApiController.class);

    @Override
    public ResponseEntity<Void> createCar(CarDTO carDTO) {
        logger.info("Adding a car to the database");
        Car car = carMapper.dtoToCar(carDTO);
        carServiceImpl.addCar(car);
        return null;
    }

    @Override
    public ResponseEntity<List<CarDTO>> getAllCars() {
        logger.info("Fetching all cars from the database");
        List<Car> car =  carServiceImpl.getAllCars();
        List<CarDTO> carDTO = carMapper.carToDTO(car);
        return ResponseEntity.ok(carDTO);
    }

    @Override
    public ResponseEntity<List<CarDTO>> getCarByCarYear(Integer carYear) {
        logger.info("Fetching all cars identified by year: " + carYear + ",  from the database");
        List<Car> car =  carServiceImpl.getCarByYear(carYear);
        List<CarDTO> carDTO = carMapper.carToDTO(car);
        return ResponseEntity.ok(carDTO);
    }

    @Override
    public ResponseEntity<List<CarDTO>> getCarByColor(String color) {
        logger.info("Fetching all cars identified by color: " + color + ",  from the database");
        List<Car> car =  carServiceImpl.getCarsByColor(color);
        List<CarDTO> carDTO = carMapper.carToDTO(car);
        return ResponseEntity.ok(carDTO);
    }

    @Override
    public ResponseEntity<List<CarDTO>> getCarByMake(String make) {
        logger.info("Fetching all cars identified by make: " + make + ",  from the database");
        List<Car> car =  carServiceImpl.getCarsByMake(make);
        List<CarDTO> carDTO = carMapper.carToDTO(car);
        return ResponseEntity.ok(carDTO);
    }

    @Override
    public ResponseEntity<CarDTO> getCarByVin(String vin) {
        logger.info("Fetching a car identified by the vin: " + vin + ", from the database");
        Car car =  carServiceImpl.getCarById(vin);
        CarDTO carDTO = carMapper.carToDTO(car);
        return ResponseEntity.ok(carDTO);
    }

    @Override
    public ResponseEntity<Void> removeCar(String vin) {
        logger.info("Removing a car identified by the vin: " + vin + ", from the database");
        carServiceImpl.removeCar(vin);
        return null;
    }

    @Override
    public ResponseEntity<Void> updateCar(String vin, CarDTO carDTO) {
        logger.info("Fetching a car identified by vin: " + vin + " and updating it");
        Car car = carServiceImpl.getCarById(vin);
        carServiceImpl.updateCar(vin, car);
        return null;
    }

}

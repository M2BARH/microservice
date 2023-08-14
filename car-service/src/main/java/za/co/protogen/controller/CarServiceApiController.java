package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import za.co.protogen.core.impl.CarServiceImpl;
import za.co.protogen.domain.Car;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarServiceApiController {

    private final CarServiceImpl carServiceImpl;

    @Autowired
    public CarServiceApiController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @PostMapping
    public  void addCar(@RequestBody Car car) {
        carServiceImpl.addCar(car);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carServiceImpl.getAllCars();
    }

    @GetMapping("/{vin}")
    public Car getCarById(@PathVariable String vin) {
        return carServiceImpl.getCarById(vin);
    }

    @PutMapping
    public void updatedCar(@RequestBody String vin, Car car) {
        carServiceImpl.updateCar(vin, car);
    }

    @DeleteMapping("/{vin}")
    public void removeCar(String vin) {
        carServiceImpl.removeCar(vin);
    }
}

package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import za.co.protogen.core.CarService;
import za.co.protogen.domain.Car;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarServiceApiController {

    private final CarService carService;

    @Autowired
    public CarServiceApiController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public  void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{vin}")
    public Car getCarById(@PathVariable String vin) {
        return carService.getCarById(vin);
    }

    @PutMapping
    public void updatedCar(@RequestBody String vin, Car car) {
        carService.updateCar(vin, car);
    }

    @DeleteMapping("/{vin}")
    public void removeCar(String vin) {
        carService.removeCar(vin);
    }
}

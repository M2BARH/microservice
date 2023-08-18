package za.co.protogen.controller;

import com.example.carservice.api.CarsApi;
import com.example.carservice.models.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.protogen.adapter.CarMapper;
import za.co.protogen.core.impl.CarServiceImpl;
import za.co.protogen.domain.Car;

import java.util.List;

@RestController
@RequestMapping("/cars")
//@RequiredArgsConstructor
public class CarServiceApiController implements CarsApi {

    @Autowired
    private final CarServiceImpl carServiceImpl;
    @Autowired
    private final CarMapper carMapper;

    @Autowired
    public CarServiceApiController(CarServiceImpl carServiceImpl, CarMapper carMapper) {
        this.carServiceImpl = carServiceImpl;
        this.carMapper = carMapper;
    }

    @Override
    public ResponseEntity<Void> createCar(CarDTO carDTO) {
        Car car = carMapper.dtoToCar(carDTO);
        carServiceImpl.addCar(car);
        return null;
    }

    @Override
    public ResponseEntity<List<CarDTO>> getAllCars() {
        List<Car> car =  carServiceImpl.getAllCars();
        List<CarDTO> carDTO = carMapper.carToDTO(car);
        return ResponseEntity.ok(carDTO);
    }

    @Override
    public ResponseEntity<List<CarDTO>> getCarByColor(String color) {
        List<Car> car =  carServiceImpl.getCarsByColor(color);
        List<CarDTO> carDTO = carMapper.carToDTO(car);
        return ResponseEntity.ok(carDTO);
    }

    @Override
    public ResponseEntity<List<CarDTO>> getCarByMake(String make) {
        List<Car> car =  carServiceImpl.getCarsByMake(make);
        List<CarDTO> carDTO = carMapper.carToDTO(car);
        return ResponseEntity.ok(carDTO);
    }

    @Override
    public ResponseEntity<CarDTO> getCarByVin(String vin) {
        Car car =  carServiceImpl.getCarById(vin);
        CarDTO carDTO = carMapper.carToDTO(car);
        return ResponseEntity.ok(carDTO);
    }

    @Override
    public ResponseEntity<Void> removeCar(String vin) {

        return null;
    }

    @Override
    public ResponseEntity<Void> updateCar(String vin, CarDTO carDTO) {
        Car car = carServiceImpl.getCarById(vin);
        carServiceImpl.updateCar(vin, car);
        return null;
    }

}

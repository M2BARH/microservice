package za.co.protogen;

import za.co.protogen.core.CarService;
import za.co.protogen.core.impl.CarServiceImpl;
import za.co.protogen.domain.Car;
import za.co.protogen.utility.Constant;

public class Application {

    public static void main(String[] args) {
        CarService carService = new CarServiceImpl(Constant.cars);

        System.out.println("All cars:");
        for (Car car : carService.getAllCars()) {
            System.out.println(car.toString());
        }

        String cheapestCar = String.valueOf(carService.findCheapestCar());
        System.out.println(cheapestCar);
    }
}
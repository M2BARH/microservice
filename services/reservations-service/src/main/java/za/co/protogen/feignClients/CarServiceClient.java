package za.co.protogen.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import za.co.protogen.domain.Car;

@FeignClient(value = "car-service", url = "http://localhost:9102/cars/id")
public interface CarServiceClient {

    @GetMapping("/{id}")
    Car getCar(@PathVariable("id") Long carId);
}

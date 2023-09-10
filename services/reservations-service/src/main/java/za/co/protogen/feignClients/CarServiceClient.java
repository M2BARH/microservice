package za.co.protogen.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import za.co.protogen.domain.Car;

@FeignClient(name = "CAR-SERVICE")
public interface CarServiceClient {

    @GetMapping("/cars/id/{id}")
    Car getCar(@PathVariable("id") Long carId);
}

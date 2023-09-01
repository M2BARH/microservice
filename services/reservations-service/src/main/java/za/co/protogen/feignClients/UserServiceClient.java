package za.co.protogen.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import za.co.protogen.domain.User;

@FeignClient(value = "user-service", url = "http://localhost:9101/users")
public interface UserServiceClient {

    @GetMapping("/{id}")
    User getUser(@PathVariable("id") Long useId);
}

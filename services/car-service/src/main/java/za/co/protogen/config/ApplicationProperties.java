package za.co.protogen.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.protogen.persistence.repository.CarRepository;

import static za.co.protogen.utility.Constants.cars;

@Configuration
public class ApplicationProperties {

    @Bean
    CommandLineRunner run(CarRepository carRepository) {
        return (args -> {
            carRepository.saveAll(cars);
        });
    }
}

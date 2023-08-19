package za.co.protogen.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import za.co.protogen.persistance.repository.ReservationRepository;

import static za.co.protogen.utility.Constants.reservations;

@Component
public class ApplicationProperties {

    @Bean
    CommandLineRunner run(ReservationRepository reservationRepository) {
        return (args -> {
            reservationRepository.saveAll(reservations);
        });
    }
}

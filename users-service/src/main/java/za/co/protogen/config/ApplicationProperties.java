package za.co.protogen.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.protogen.persistance.repository.UserRepository;

import static za.co.protogen.utility.Constants.users;

@Configuration
public class ApplicationProperties {

    @Bean
    CommandLineRunner run(UserRepository userRepository) {
        return (args -> {
            userRepository.saveAll(users);
        });
    }
}

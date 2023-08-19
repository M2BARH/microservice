package za.co.protogen.protogen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ProtogenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProtogenApplication.class, args);
	}

}

package com.dreamseeker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dreamseeker.models.entity.Dwelling;
import com.dreamseeker.models.services.DwellingService;

@SpringBootApplication
public class CondoAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(CondoAdminApplication.class, args);
	}
	
	private static final Logger log = LoggerFactory.getLogger(CondoAdminApplication.class);
	
	@Bean
	public CommandLineRunner demo(DwellingService service) {
		return (args) -> {
			service.addPerson(new Dwelling(5, "A", 100000));
			log.info("How many people?: " + service.count());
			
			for (Dwelling dwelling : service.getAll()) {
				log.info(dwelling.toString());
			}
		};
		}


}

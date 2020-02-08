package com.dreamseeker;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SuppressWarnings("restriction")
@SpringBootApplication
public class CondoAdminApplication {

	public static void main(String[] args) {
		Application.launch(JavaFxApplication.class, args);
	}
	
	/*private static final Logger log = LoggerFactory.getLogger(CondoAdminApplication.class);
	
	@Bean
	public CommandLineRunner demo(DwellingService service) {
		return (args) -> {
			service.addPerson(new Dwelling(5, "A", 100000));
			log.info("How many people?: " + service.count());
			
			for (Dwelling dwelling : service.getAll()) {
				log.info(dwelling.toString());
			}
			
			log.info(service.getDwellingById("A").toString());
		};
		}*/


}

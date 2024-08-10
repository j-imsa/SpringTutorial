package be.jimsa.springtutorial;

import be.jimsa.springtutorial.ws.services.VehicleService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringTutorialApplication {

    public static void main(String[] args) {
        // SpringApplication.run(SpringTutorialApplication.class, args);
        var context = new AnnotationConfigApplicationContext(SpringTutorialApplication.class);

        VehicleService vehicleService = context.getBean(VehicleService.class);

        vehicleService.doneSomething();
    }

}

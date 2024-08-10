package be.jimsa.springtutorial;

import be.jimsa.springtutorial.ws.beans.Vehicle;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringTutorialApplication {

    public static void main(String[] args) {
        // SpringApplication.run(SpringTutorialApplication.class, args);
        var context = new AnnotationConfigApplicationContext(SpringTutorialApplication.class);

        Vehicle vehicle1 = context.getBean("vehicle2", Vehicle.class);
        Vehicle vehicle2 = context.getBean("MustangVehicle", Vehicle.class);

        System.out.println(vehicle1.name());
        System.out.println(vehicle2.name());
    }

}

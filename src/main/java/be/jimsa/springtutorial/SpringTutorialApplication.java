package be.jimsa.springtutorial;

import be.jimsa.springtutorial.ws.beans.Vehicle;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringTutorialApplication {

    public static void main(String[] args) {
        // SpringApplication.run(SpringTutorialApplication.class, args);
        var context = new AnnotationConfigApplicationContext(SpringTutorialApplication.class);

        context.registerBean("AudiBean", Vehicle.class, () -> new Vehicle("BMW"));

        Vehicle vehicle = context.getBean("AudiBean", Vehicle.class);

        System.out.println(vehicle.getName());

        // output:
        // Vehicle init
        // Vehicle init
        // BMW
    }

}

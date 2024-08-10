package be.jimsa.springtutorial;

import be.jimsa.springtutorial.ws.beans.Vehicle;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringTutorialApplication {

    public static void main(String[] args) {
        // SpringApplication.run(SpringTutorialApplication.class, args);
        var context = new ClassPathXmlApplicationContext("beans.xml");

        Vehicle vehicle = context.getBean(Vehicle.class);

        System.out.println(vehicle.getName());

    }

}

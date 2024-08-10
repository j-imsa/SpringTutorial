package be.jimsa.springtutorial;

import be.jimsa.springtutorial.ws.beans.Person;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringTutorialApplication {

    public static void main(String[] args) {
        // SpringApplication.run(SpringTutorialApplication.class, args);
        var context = new AnnotationConfigApplicationContext(SpringTutorialApplication.class);

//        Vehicle vehicle = context.getBean(Vehicle.class);
        Person person = context.getBean(Person.class);

//        System.out.println(vehicle);
        System.out.println(person);

    }

}

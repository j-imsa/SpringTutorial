package be.jimsa.springtutorial;

import be.jimsa.springtutorial.ws.beans.Person;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringTutorialApplication {

    public static void main(String[] args) {
        // SpringApplication.run(SpringTutorialApplication.class, args);
        var context = new AnnotationConfigApplicationContext(SpringTutorialApplication.class);

        Person person1 = context.getBean(Person.class);
        Person person2 = context.getBean(Person.class);

        System.out.println(person1.getClass().hashCode());
        System.out.println(person2.getClass().hashCode());

    }

}

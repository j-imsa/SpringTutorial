package be.jimsa.springtutorial.ws.configs;

import be.jimsa.springtutorial.ws.beans.Person;
import be.jimsa.springtutorial.ws.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Vehicle vehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Mustang");
        return vehicle;
    }

    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("John");
        person.setVehicle(vehicle()); // wiring beans using method call
        return person;
    }
}

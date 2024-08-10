package be.jimsa.springtutorial.ws.configs;

import be.jimsa.springtutorial.ws.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    public Vehicle vehicle1() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Audi");
        return vehicle;
    }

    @Bean
    @Primary
    public Vehicle vehicle2() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Ferrari");
        return vehicle;
    }
}

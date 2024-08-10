package be.jimsa.springtutorial.ws.configs;

import be.jimsa.springtutorial.ws.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    @Primary
    Vehicle vehicle1() {
        return new Vehicle("Audi");
    }

    @Bean
    Vehicle vehicle2() {
        return new Vehicle("Ferrari");
    }

    @Bean(name = "MustangVehicle")
    Vehicle vehicle3() {
        return new Vehicle("Mustang");
    }
}

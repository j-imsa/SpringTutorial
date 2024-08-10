package be.jimsa.springtutorial.ws.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Person {
    private String name;

    private final Vehicle vehicle;

    // @Autowired
    public Person(Vehicle vehicle2) {
        this.vehicle = vehicle2;
    }

}

package be.jimsa.springtutorial.ws.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@Component
public class Person {
    private String name;
    private final Vehicle vehicle;

    @Autowired
    public Person(@Qualifier("vehicle1") Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}

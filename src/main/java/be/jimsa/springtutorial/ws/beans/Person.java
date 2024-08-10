package be.jimsa.springtutorial.ws.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class Person {
    private String name;

    @Autowired
    private Vehicle vehicle;


}

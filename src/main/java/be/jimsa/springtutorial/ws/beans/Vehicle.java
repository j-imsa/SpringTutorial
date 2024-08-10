package be.jimsa.springtutorial.ws.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Vehicle {
    private String name;
}

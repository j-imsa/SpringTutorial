package be.jimsa.springtutorial.ws.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON) // race condition, immutable
public class Person {
    private String name;
    private final Vehicle vehicle;

    @Autowired
    public Person(@Qualifier("vehicle1") Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}

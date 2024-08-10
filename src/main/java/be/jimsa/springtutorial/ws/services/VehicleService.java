package be.jimsa.springtutorial.ws.services;

import be.jimsa.springtutorial.ws.aspects.MethodLogAspect;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    public void doSomething() {
        System.out.println("VehicleService is doing something!");
    }

    @MethodLogAspect
    public void doneSomething() {
        System.out.println("VehicleService done something!");
    }
}

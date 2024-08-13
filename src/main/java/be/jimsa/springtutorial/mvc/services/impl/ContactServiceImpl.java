package be.jimsa.springtutorial.mvc.services.impl;

import be.jimsa.springtutorial.mvc.services.ContactService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Slf4j
@Service
@RequestScope
@Getter
@Setter
public class ContactServiceImpl implements ContactService {
    private int counter = 0;

    public ContactServiceImpl() {
        log.info("ContactServiceImpl Bean initialized");
    }

    @Override
    public int getCount() {
        return this.counter;
    }

    @Override
    public int increaseCounter(int increment) {
        this.counter += increment;
        return getCount();
    }
}

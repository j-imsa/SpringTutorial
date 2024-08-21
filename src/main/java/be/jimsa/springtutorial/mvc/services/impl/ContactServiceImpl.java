package be.jimsa.springtutorial.mvc.services.impl;

import be.jimsa.springtutorial.mvc.configs.AppProps;
import be.jimsa.springtutorial.mvc.services.ContactService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Data
public class ContactServiceImpl implements ContactService {

    @Value("${app.test.val}")
    private int val;

    private final Environment environment;

    private final AppProps appProps;

    public ContactServiceImpl(Environment environment, AppProps appProps) {
        this.environment = environment;
        this.appProps = appProps;

        log.info("page size from app.properties file: {}", appProps.getPageSize());
        log.info("page size from app.properties file content: {}", appProps.getContent().get("pageSize"));
        log.info("page size from app.properties file first unit: {}", appProps.getUnit().getFirst());

        log.info("@Value: {}", val);
        log.info("Environment: {}", environment.getProperty("app.test.msg"));
    }
}

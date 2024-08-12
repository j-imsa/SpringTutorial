package be.jimsa.springtutorial.mvc.services.impl;

import be.jimsa.springtutorial.mvc.models.requests.UserRequest;
import be.jimsa.springtutorial.mvc.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public List<String> getProfessions() {
        return List.of("Developer", "Tester", "Architect");
    }

    @Override
    public void manageUserInfo(UserRequest user) {
        // Validation
        // Db
        // ...

        log.info("User is {}", user);

    }

}

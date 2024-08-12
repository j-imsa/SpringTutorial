package be.jimsa.springtutorial.mvc.services;

import be.jimsa.springtutorial.mvc.models.requests.UserRequest;

import java.util.List;

public interface UserService {
    List<String> getProfessions();
    void manageUserInfo(UserRequest user);
}

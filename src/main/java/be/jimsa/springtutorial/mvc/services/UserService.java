package be.jimsa.springtutorial.mvc.services;

import be.jimsa.springtutorial.mvc.models.requests.UserRequest;
import be.jimsa.springtutorial.mvc.models.responses.UserResponse;

import java.util.List;

public interface UserService {
    List<String> getProfessions();

    void manageUserInfo(UserRequest user);

    List<UserResponse> getMathData();

    List<UserResponse> getEnglishData();

    List<UserResponse> getAllData();
}

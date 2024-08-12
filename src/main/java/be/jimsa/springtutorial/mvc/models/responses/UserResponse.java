package be.jimsa.springtutorial.mvc.models.responses;

import lombok.Data;

@Data
public class UserResponse {
    private String name;
    private String email;
    private String id;
}

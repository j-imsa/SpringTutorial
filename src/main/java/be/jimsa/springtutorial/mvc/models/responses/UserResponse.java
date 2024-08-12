package be.jimsa.springtutorial.mvc.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    private String name;
    private String email;
    private String id;
}

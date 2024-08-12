package be.jimsa.springtutorial.mvc.models.requests;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private String gender;
    private String note;
    private boolean married;
    private String birthday;
    private String profession;
}

package be.jimsa.springtutorial.mvc.models.requests;

import be.jimsa.springtutorial.mvc.validations.PasswordValidator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest {

    @NotBlank(message = "Name can not be blank")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 chars")
    private String name;

    @Email(message = "Email must be in the correct format of an e-mail")
    private String email;

    @PasswordValidator
    private String password;

    private String gender;
    private String note;
    private boolean married;
    private String birthday;
    private String profession;
}

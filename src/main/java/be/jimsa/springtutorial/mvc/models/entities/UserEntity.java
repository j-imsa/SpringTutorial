package be.jimsa.springtutorial.mvc.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GenerationType.SEQUENCE
    private long id;

    @NotBlank(message = "Name can not be blank")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 chars")
    private String name;

    @Email(message = "Email must be in the correct format of an e-mail")
    private String email;

    private String password;
}

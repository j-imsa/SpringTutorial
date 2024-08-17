package be.jimsa.springtutorial.mvc.validations.impl;

import be.jimsa.springtutorial.mvc.validations.PasswordValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator, String> {

    private List<String> weakPasswords;

    @Override
    public void initialize(PasswordValidator constraintAnnotation) {
        weakPasswords = Arrays.asList(
                "123",
                "1234",
                "12345"
        );
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return weakPasswords.stream().noneMatch(weakPassword -> weakPassword.equals(value));
    }
}

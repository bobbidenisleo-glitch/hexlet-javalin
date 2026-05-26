package org.example.hexlet.dto.users;

import java.util.List;
import java.util.Map;
import io.javalin.validation.ValidationError;

public class BuildUserPage {
    private String firstName;
    private String lastName;
    private String email;
    private Map<String, List<ValidationError<Object>>> errors;

    public BuildUserPage() {
    }

    public BuildUserPage(String firstName, String lastName, String email, 
                         Map<String, List<ValidationError<Object>>> errors) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.errors = errors;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Map<String, List<ValidationError<Object>>> getErrors() {
        return errors;
    }
}

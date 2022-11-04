package com.example.demodds.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDTO implements Validator {
    private int id;

    @NotEmpty
    @Size(min = 5, max = 45)
    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 45)
    private String lastName;

    @NotEmpty
    private String phoneNumber;


    @Min(18)
    private int age;

    @NotEmpty
    private String email;

    public UserDTO() {
    }

    public UserDTO(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;

        if (!userDTO.getFirstName().matches("\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*")) {
            errors.rejectValue("firstName", "first-name", "Name must not have number");
        }

        if (!userDTO.getLastName().matches("[a-zA-Z]+")) {
            errors.rejectValue("lastName", "last-name", "Name must not have number");
        }

        if (!userDTO.getPhoneNumber().matches("[0]\\d{9}")) {
            errors.rejectValue("phoneNumber", "phone-number", "Phone number must not have alphabet");
        }

        if (!userDTO.getEmail().matches("\\w+@\\w+\\.\\w+")) {
            errors.rejectValue("email", "email-validate", "Mail must be in valid");
        }
    }
}

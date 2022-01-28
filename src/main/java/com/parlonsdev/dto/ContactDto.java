package com.parlonsdev.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ContactDto {

    @NotBlank
    @Size(max = 50)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @NotBlank
    @Size(max = 80)
    private String email;

    @NotBlank
    @Size(max = 300)
    private String message;

    public ContactDto() {
    }

    public ContactDto(@NotBlank @Size(max = 50) String firstName, @NotBlank @Size(max = 50) String lastName,
                      @NotBlank @Size(max = 80) String email, @NotBlank @Size(max = 300) String message) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.message = message;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.parlonsdev.dto;

import org.hibernate.annotations.NaturalId;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeDto {

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @Email
    @NaturalId
    @Size(max = 80)
    private String email;

    @NotNull
    @Size(max = 15)
    private String phoneNumber;

    @NotNull
    @Size(max = 128)
    private String address;

    public EmployeeDto(@NotNull @Size(min = 3, max = 50) String name,
                       @NotNull @Email @Size(max = 80) String email,
                       @NotNull @Size(max = 15) String phoneNumber,
                       @NotNull @Size(max = 128) String address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

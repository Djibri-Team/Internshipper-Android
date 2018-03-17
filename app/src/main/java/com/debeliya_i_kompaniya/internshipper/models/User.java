package com.debeliya_i_kompaniya.internshipper.models;

import com.debeliya_i_kompaniya.internshipper.enums.UserRole;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserRole userRole;


    public User(String firstName, String lastName, String email, String password, UserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
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

    public String getPassword() {
        return password;
    }

    public UserRole getUserRole() {
        return userRole;
    }
}

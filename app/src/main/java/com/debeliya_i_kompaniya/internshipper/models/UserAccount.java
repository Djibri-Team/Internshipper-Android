package com.debeliya_i_kompaniya.internshipper.models;

import com.debeliya_i_kompaniya.internshipper.enums.UserRole;

public class UserAccount {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String userPassword;
    private String description;
    private UserRole userRole;

    public UserAccount(int id, String firstName, String lastName, String email, String password, String description, String userRole) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userPassword = password;
        this.description = description;
        this.userRole = UserRole.StringToUserRole(userRole);
    }

    public UserAccount(String firstName, String lastName, String email, String password, String description, String userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userPassword = password;
        this.email = email;
        this.description = description;
        this.userRole = UserRole.StringToUserRole(userRole);

    }

    public UserAccount(String firstName, String lastName, String email, String password, String userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userPassword = password;
        this.userRole = UserRole.StringToUserRole(userRole);
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
        return userPassword;
    }

    public String getDescription() {
        return description;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + userPassword + '\'' +
                ", description='" + description + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}

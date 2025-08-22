package com.seiryu.ecommerce.backend_ecommerce.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private Long cellphone;
    private String password;
    private UserType userType;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    public User() {
    }

    public User(String userName, String firstName, String lastName, String email, String address, Long cellphone,
            String password, UserType userType, LocalDateTime dateCreated, LocalDateTime dateUpdated) {

        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.cellphone = cellphone;
        this.password = password;
        this.userType = userType;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
                + ", email=" + email + ", address=" + address + ", cellphone=" + cellphone + ", password=" + password
                + ", userType=" + userType + ", dateCreated=" + dateCreated + "]";
    }

}

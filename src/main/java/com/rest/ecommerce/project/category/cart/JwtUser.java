package com.rest.ecommerce.project.category.cart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "user")
public class JwtUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;
    private @NotBlank String username;
    @JsonIgnore
    private @NotBlank String email;
    @JsonIgnore
    private @NotBlank String password;
    @JsonIgnore
    private @NotBlank String phoneNumber;
    @JsonIgnore
    private @NotBlank boolean loggedIn;


//    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<address> address;

    public List<address> getAddress() {
        return address;
    }

    public void setAddress(List<address> address) {
        this.address = address;
    }

    public JwtUser(long id, String username, String email, String password, String phoneNumber, boolean loggedIn) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.loggedIn = loggedIn;
    }

    public JwtUser() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }


    @Override
    public String toString() {
        return "JwtUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", loggedIn=" + loggedIn +
                ", address=" + address +
                '}';
    }
}

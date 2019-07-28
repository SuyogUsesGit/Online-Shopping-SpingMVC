package com.suyoggaikwad.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
public class Customer {
    private int id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

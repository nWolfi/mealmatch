package com.example.mealmatch.user;

public class CreateUserDto {
    private String email;
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password_hash) {
        this.password = password_hash;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

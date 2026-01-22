package com.example.mealmatch.user;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "user_id", updatable = false, nullable = false)
    private String userId;

    @Column(name = "email")
    private String email;
    private String passwordHash;

    @Column(name = "password_hash")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPasswordHash(String password) {
        this.passwordHash = password;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}

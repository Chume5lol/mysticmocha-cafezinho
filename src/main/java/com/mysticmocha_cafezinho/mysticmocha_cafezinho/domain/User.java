package com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String fistName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Department department;

    @Column(nullable = false)
    private LocalDateTime lastLogin;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean enable;

    public User(Integer id, String fistName, String lastName, Department department, LocalDateTime lastLogin,
            String password, Boolean enable) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.department = department;
        this.lastLogin = lastLogin;
        this.password = password;
        this.enable = enable;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    
}

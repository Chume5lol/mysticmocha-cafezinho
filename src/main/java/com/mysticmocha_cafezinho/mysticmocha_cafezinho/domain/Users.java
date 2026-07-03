package com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Users implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fistName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String email;

    @JoinColumn(name = "department_id")
    @ManyToOne
    private Department department;

    @Column
    private LocalDateTime lastLogin;

    @Column(nullable = false)
    private String password;

    @Column
    @Enumerated
    private UserRole userRole;

    @Column
    private Boolean enable;

    

    
    public void setId(Long id) {
        this.id = id;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void setEnable() {
        this.enable = true;
    }


    public Users() {
    }

    public Users(Long id, String fistName, String lastName, String nickname, String email, Department department,
            LocalDateTime lastLogin, String password, UserRole userRole) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.email = email;
        this.department = department;
        this.lastLogin = lastLogin;
        this.password = password;
        this.userRole = userRole;
        this.enable = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return nickname;
    }

    @Override
    public String getPassword() {
        return password;
    }

    
}

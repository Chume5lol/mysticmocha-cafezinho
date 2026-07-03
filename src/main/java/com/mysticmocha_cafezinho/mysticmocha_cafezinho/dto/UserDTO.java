package com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Department;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Users;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.enums.UserRole;

import lombok.Getter;

@Getter
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String nickname;
    private String email;
    private Long department;
    private String password;
    private UserRole userRole;


    public UserDTO() {
    }

    public UserDTO(Long id, String firstName, String lastName, String nickname, String email, Long department, String password,
            UserRole userRole) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.email = email;
        this.department = department;
        this.password = password;
        this.userRole = userRole;
    }

    public UserDTO toDTO(Users u) {
        return new UserDTO(
            u.getId(),
            u.getFistName(),
            u.getLastName(),
            u.getNickname(),
            u.getEmail(),
            u.getDepartment().getId(),
            u.getPassword(),
            u.getUserRole());
    }
    
}

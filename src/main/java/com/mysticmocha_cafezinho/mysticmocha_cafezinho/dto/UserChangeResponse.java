package com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto;

import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserChangeResponse{
    private Long id;
    private String firstName;
    private String lastName;
    private String nickname;
    private String email;
    private Long department;
    private Set<Long> categories;
    private String userRole;
    private Boolean status;

    public UserChangeResponse() {
    }

    public UserChangeResponse(Long id, String firstName, String lastName, String nickname, String email,
            Long department, Set<Long> categories, String userRole, Boolean status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.email = email;
        this.department = department;
        this.categories = categories;
        this.userRole = userRole;
        this.status = status;
    }

    
    
}
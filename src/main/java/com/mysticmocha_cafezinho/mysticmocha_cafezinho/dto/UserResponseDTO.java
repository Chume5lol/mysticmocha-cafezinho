package com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto;

public record UserResponseDTO(
    Long id,
    String firstName,
    String lastName,
    String nickname,
    String email,
    String department,
    String userRoles,
    String lastLogin,
    Boolean status
) 
{}

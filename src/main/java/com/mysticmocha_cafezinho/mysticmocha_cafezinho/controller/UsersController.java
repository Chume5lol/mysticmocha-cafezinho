package com.mysticmocha_cafezinho.mysticmocha_cafezinho.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Users;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.UserDTO;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Users> registerUser(@RequestBody UserDTO userDTO) {
        userService.registerUser(userDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication authentication) {
        return ResponseEntity.ok(authentication.getAuthorities());
    }
}

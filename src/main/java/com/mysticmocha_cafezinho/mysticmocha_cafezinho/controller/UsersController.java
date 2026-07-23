package com.mysticmocha_cafezinho.mysticmocha_cafezinho.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Users;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.UserDTO;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.UserResponseDTO;
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

    @GetMapping("/findAll")
    public ResponseEntity<List<UserResponseDTO>> allUsers(Authentication authentication, @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber, @RequestParam(name = "quantityItens", required = false, defaultValue = "10") int quantityItens) {

        List<UserResponseDTO> users = userService.findAll(pageNumber, quantityItens);


        return ResponseEntity.ok(users);
    }

    @GetMapping("/countUsers")
    public ResponseEntity<Long> counterUsers() {

        return ResponseEntity.ok(userService.countAllUsers());
    }
}

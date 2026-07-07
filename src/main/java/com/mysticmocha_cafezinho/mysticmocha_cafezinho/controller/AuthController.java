package com.mysticmocha_cafezinho.mysticmocha_cafezinho.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.LoginRequest;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("authenticate")
    public String authenticate(@RequestBody LoginRequest request) {
        return authenticationService.authenticate(request);
    }
}

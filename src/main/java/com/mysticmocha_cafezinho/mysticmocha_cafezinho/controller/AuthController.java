package com.mysticmocha_cafezinho.mysticmocha_cafezinho.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.LoginRequest;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.LoginResponse;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("authenticate")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest request) {

        String token = authenticationService.authenticate(request);
        return ResponseEntity.ok(new LoginResponse(token));
    }
}

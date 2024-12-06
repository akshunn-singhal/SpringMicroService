package com.harman.auth.service.controller;

import com.harman.auth.service.dto.UserCredential;
import com.harman.auth.service.service.JwtService;
import com.harman.auth.service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UserService service;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserCredential credential) {
        if (isValidUser(credential)) {
            return ResponseEntity.ok(generateJWT(credential));
        }
        return ResponseEntity.status(401).body("Invalid User");
    }

    @PostMapping("/token")
    public ResponseEntity<Void> validate(@RequestBody String token) {
        return ResponseEntity.status(jwtService.isTokenValid(token) ? 200 : 400).build();
    }

    private String generateJWT(UserCredential credential) {
        return jwtService.generateToken(credential);
    }

    private boolean isValidUser(UserCredential credential) {
        return service.validateUser(credential);
    }


}

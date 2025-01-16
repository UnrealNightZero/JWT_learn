package com.example.demo.controller;

import com.example.demo.authentication.AuthenticationRequest;
import com.example.demo.authentication.AuthenticationResponse;
import com.example.demo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/register_M")
    public ResponseEntity<AuthenticationResponse> register_M(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register_M(request));
    }

}
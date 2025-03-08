package com.TasksProjectTest.TasksProjectTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TasksProjectTest.TasksProjectTest.dto.AuthenticationRequest;
import com.TasksProjectTest.TasksProjectTest.dto.AuthenticationResponse;
import com.TasksProjectTest.TasksProjectTest.service.auth.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // Allow requests from everywhere
public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse response = authenticationService.login(request);
        return ResponseEntity.ok(response);
    }
}

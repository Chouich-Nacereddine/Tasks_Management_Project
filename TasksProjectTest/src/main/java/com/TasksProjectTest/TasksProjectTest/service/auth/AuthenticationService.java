package com.TasksProjectTest.TasksProjectTest.service.auth;

import com.TasksProjectTest.TasksProjectTest.dto.AuthenticationRequest;
import com.TasksProjectTest.TasksProjectTest.dto.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse login(AuthenticationRequest request);
}
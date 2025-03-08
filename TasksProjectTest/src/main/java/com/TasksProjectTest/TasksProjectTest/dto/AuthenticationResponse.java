package com.TasksProjectTest.TasksProjectTest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Data
public class AuthenticationResponse {
    private String token;
    private String role; // I will need that to redirecte the user to the correct page in the frontend

}

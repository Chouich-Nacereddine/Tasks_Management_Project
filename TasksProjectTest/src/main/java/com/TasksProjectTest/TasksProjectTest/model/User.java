package com.TasksProjectTest.TasksProjectTest.model;

import com.TasksProjectTest.TasksProjectTest.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity // This tells Hibernate ORM to make a table for us out of this class.
@Data // Lombok annotation to generate some methods for us like getters and setters
@Table(name = "users")
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // We can add more fields here like name, age .... but since this is just for
    // the Job test, I did add only the necessary ones.
}

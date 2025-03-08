package com.TasksProjectTest.TasksProjectTest.model;

import com.TasksProjectTest.TasksProjectTest.enums.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity // This tells Hibernate ORM to make a table for us out of this class.
@Data // Lombok annotation to generate some methods for us like getters and setters
@AllArgsConstructor
@RequiredArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status; // This is the status of the task that is declared in the ../enums package

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userInCharge; // I use this to refer to the user that shoold do the task

    // Also here We can add more fields .... but since this is just for
    // the Job test, I did add only the necessary ones.

}

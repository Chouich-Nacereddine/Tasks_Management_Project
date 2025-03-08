package com.TasksProjectTest.TasksProjectTest.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.TasksProjectTest.TasksProjectTest.enums.TaskStatus;
import com.TasksProjectTest.TasksProjectTest.model.Task;
import com.TasksProjectTest.TasksProjectTest.model.User;
import com.TasksProjectTest.TasksProjectTest.repository.TaskRepository;
import com.TasksProjectTest.TasksProjectTest.repository.UserRepository;

import java.util.List;

@Configuration
public class TaskSeeder {
    @Bean
    public ApplicationRunner loadTasks(TaskRepository taskRepository, UserRepository userRepository) {
        return _ -> {
            if (taskRepository.count() == 0) {
                User user1 = userRepository.findFirstByEmail("admin@example.com");
                User user2 = userRepository.findFirstByEmail("user2@example.com");
                User user3 = userRepository.findFirstByEmail("user3@example.com");
                User user4 = userRepository.findFirstByEmail("user4@example.com");

                if (user1 != null && user2 != null) {
                    List<Task> tasks = List.of(
                            new Task(null, "Task 1", "Description 1", TaskStatus.NOT_STARTED, user2),
                            new Task(null, "Task 2", "Description 2", TaskStatus.IN_PROGRESS, user4),
                            new Task(null, "Task 3", "Description 3", TaskStatus.DONE, user2),
                            new Task(null, "Task 4", "Description 4", TaskStatus.NOT_STARTED, user2),
                            new Task(null, "Task 5", "Description 5", TaskStatus.IN_PROGRESS, user3),
                            new Task(null, "Task 6", "Description 6", TaskStatus.DONE, user3),
                            new Task(null, "Task 7", "Description 7", TaskStatus.NOT_STARTED, user4),
                            new Task(null, "Task 8", "Description 8", TaskStatus.IN_PROGRESS, user4),
                            new Task(null, "Task 9", "Description 9", TaskStatus.DONE, user3),
                            new Task(null, "Task 10", "Description 10", TaskStatus.NOT_STARTED, user2));
                    taskRepository.saveAll(tasks);
                }
            }
        };
    }
}

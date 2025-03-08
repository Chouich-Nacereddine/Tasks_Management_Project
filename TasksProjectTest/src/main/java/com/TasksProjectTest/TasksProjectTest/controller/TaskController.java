package com.TasksProjectTest.TasksProjectTest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TasksProjectTest.TasksProjectTest.model.Task;
import com.TasksProjectTest.TasksProjectTest.model.User;
import com.TasksProjectTest.TasksProjectTest.service.TaskService;
import com.TasksProjectTest.TasksProjectTest.service.UserServiceImpl;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*") // Allow requests from everywhere

public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UserServiceImpl userService;

    // Get all tasks
    // @Secured("ADMIN")
    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/user_tasks")
    public List<Task> getTasksForUser(
            @RequestParam("userId") Long userId) {

        // Fetch the user by userId
        User user = userService.findUserById(userId);
        if (user == null) {
            throw new RuntimeException("User not found with id: " + userId);
        }

        // Call the service method to get tasks for the user
        return taskService.getTasksForUser(user);
    }

    // Get task by ID
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    // Create a new task
    @Secured("ADMIN")
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    // Update an existing task
    @Secured("ADMIN")
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    // Delete a task
    @Secured("ADMIN")
    @DeleteMapping("/{id}")
    public boolean deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id);
    }

    // Filter tasks by title and status
    @GetMapping("/filter")
    public List<Task> filterTasks(@RequestParam(required = false) String title,
            @RequestParam(required = false) String status) {
        return taskService.filterTasks(title, status);
    }

    @GetMapping("/user_filter")
    public List<Task> filterTasksForUser(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String status,
            @RequestParam("userId") Long userId) {

        // Retrieve the user from the database by userId
        User user = userService.findUserById(userId);

        // Call the filter method from the service to get tasks for the specific user
        return taskService.filterTasksForUser(title, status, user);
    }
}

package com.TasksProjectTest.TasksProjectTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TasksProjectTest.TasksProjectTest.enums.TaskStatus;
import com.TasksProjectTest.TasksProjectTest.model.Task;
import com.TasksProjectTest.TasksProjectTest.model.User;
import com.TasksProjectTest.TasksProjectTest.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired // This annotation is used to inject the Repository dependency one of spring
               // boot features "DI"
    private TaskRepository taskRepository;

    // This is function to get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // This is function to get tasks for a specific user
    public List<Task> getTasksForUser(User user) {
        return taskRepository.findByUserInCharge(user);
    }

    // This is function to create a new task
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // This is function to get a task by id
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // This is function to update a task
    public Task updateTask(Long id, Task updatedTask) {
        if (taskRepository.existsById(id)) {
            updatedTask.setId(id);
            return taskRepository.save(updatedTask);
        }
        return null;
    }

    // This is function to delete a task
    public boolean deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // This is function to filter tasks by title and status combined
    public List<Task> filterTasks(String title, String status) {
        if ((title == null || title.isEmpty()) && (status == null || status.isEmpty())) {
            return getAllTasks(); // This is just to return all tasks by default
        }

        TaskStatus taskStatus = (status == null || status.isEmpty()) ? null : TaskStatus.valueOf(status);

        if (title != null && !title.isEmpty() && taskStatus != null) {
            return taskRepository.findByTitleContainingAndStatus(title, taskStatus);
        }

        if (title != null && !title.isEmpty()) {
            return taskRepository.findByTitleContaining(title);
        }

        if (taskStatus != null) {
            return taskRepository.findByStatus(taskStatus);
        }

        return getAllTasks();
    }

    public List<Task> filterTasksForUser(String title, String status, User user) {
        if ((title == null || title.isEmpty()) && (status == null || status.isEmpty())) {
            return getTasksForUser(user); // Return only tasks assigned to the user by default
        }

        TaskStatus taskStatus = (status == null || status.isEmpty()) ? null : TaskStatus.valueOf(status);

        if (title != null && !title.isEmpty() && taskStatus != null) {
            return taskRepository.findByUserInChargeAndTitleContainingAndStatus(user, title, taskStatus);
        }

        if (title != null && !title.isEmpty()) {
            return taskRepository.findByUserInChargeAndTitleContaining(user, title);
        }

        if (taskStatus != null) {
            return taskRepository.findByUserInChargeAndStatus(user, taskStatus);
        }

        return getTasksForUser(user);
    }

}

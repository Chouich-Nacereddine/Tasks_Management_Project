package com.TasksProjectTest.TasksProjectTest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TasksProjectTest.TasksProjectTest.enums.TaskStatus;
import com.TasksProjectTest.TasksProjectTest.model.Task;
import com.TasksProjectTest.TasksProjectTest.model.User;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUserInCharge(User user);

    List<Task> findByTitleContainingAndStatus(String title, TaskStatus status);

    List<Task> findByUserInChargeAndTitleContainingAndStatus(User user, String title, TaskStatus status);

    List<Task> findByUserInChargeAndTitleContaining(User user, String title);

    List<Task> findByUserInChargeAndStatus(User user, TaskStatus status);

    List<Task> findByTitleContaining(String title);

    List<Task> findByStatus(TaskStatus status);
}
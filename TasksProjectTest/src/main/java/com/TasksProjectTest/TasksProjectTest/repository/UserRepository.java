package com.TasksProjectTest.TasksProjectTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TasksProjectTest.TasksProjectTest.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByEmail(String email);

    User findFirstById(Long id);
}
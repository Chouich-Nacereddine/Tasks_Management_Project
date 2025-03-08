package com.TasksProjectTest.TasksProjectTest.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.TasksProjectTest.TasksProjectTest.enums.Role;
import com.TasksProjectTest.TasksProjectTest.model.User;
import com.TasksProjectTest.TasksProjectTest.repository.UserRepository;

@Configuration
public class UserSeeder {
    @Bean
    public ApplicationRunner loadData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return _ -> {
            if (userRepository.findFirstByEmail("admin@example.com") == null) {
                User admin = new User(null, "Admin", "admin@example.com", passwordEncoder.encode("admin123"),
                        Role.ADMIN);
                userRepository.save(admin);
            }

            if (userRepository.findFirstByEmail("user@example.com") == null) {
                User user = new User(null, "User", "user2@example.com", passwordEncoder.encode("user123"),
                        Role.SIMPLE_USER);
                userRepository.save(user);
            }
            if (userRepository.findFirstByEmail("user@example.com") == null) {
                User user = new User(null, "User", "use3@example.com", passwordEncoder.encode("user123"),
                        Role.SIMPLE_USER);
                userRepository.save(user);
            }
            if (userRepository.findFirstByEmail("user@example.com") == null) {
                User user = new User(null, "User", "use4@example.com", passwordEncoder.encode("user123"),
                        Role.SIMPLE_USER);
                userRepository.save(user);
            }
        };
    }
}

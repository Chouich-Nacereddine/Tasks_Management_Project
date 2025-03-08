package com.TasksProjectTest.TasksProjectTest.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.TasksProjectTest.TasksProjectTest.model.User;
import com.TasksProjectTest.TasksProjectTest.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired // This annotation is used to inject the Repository dependency one of spring
               // boot features "DI"
    private UserRepository userRepository;

    public User findUserById(Long id) {
        return userRepository.findFirstById(id); // Find user by ID
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findFirstByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().name());

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<SimpleGrantedAuthority>() {
                    {
                        add(authority);
                    }
                });
    }
}

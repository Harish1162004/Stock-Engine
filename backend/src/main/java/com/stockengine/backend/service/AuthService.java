package com.stockengine.backend.service;

import com.stockengine.backend.entity.User;
import com.stockengine.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String signup(User user) {

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "Username already exists";
        }

        userRepository.save(user);
        return "User registered successfully";
    }
}

package com.stockengine.backend.controller;

import com.stockengine.backend.entity.User;
import com.stockengine.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 🔐 SIGNUP
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {

        // 🔥 ENCRYPT PASSWORD HERE
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        userRepository.save(user);

        return "User Registered Successfully";
    }

    // 🔑 LOGIN
    @PostMapping("/login")
    public String login(@RequestBody User loginUser) {

        User user = userRepository.findByUsername(loginUser.getUsername())
                .orElse(null);

        if (user == null) {
            return "Invalid Username or Password";
        }

        // 🔥 MATCH RAW vs ENCRYPTED
        if (passwordEncoder.matches(loginUser.getPassword(), user.getPassword())) {
            return "Login Success";
        }

        return "Invalid Username or Password";
    }
}

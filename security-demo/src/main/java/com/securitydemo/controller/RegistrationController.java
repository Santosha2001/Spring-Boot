package com.securitydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.securitydemo.model.UserDtls;
import com.securitydemo.repository.UserRepository;

@RestController
public class RegistrationController {

    public RegistrationController() {
        System.out.println(getClass().getSimpleName());
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register/user")
    public UserDtls createUser(@RequestBody UserDtls user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}

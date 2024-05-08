package com.securitydemo.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.securitydemo.model.UserDtls;
import com.securitydemo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserDtls> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            var userObj = user.get();

            return User.builder()
                    .username("santhu")
                    .password(userObj.getPassword())
                    .roles(userObj.getRole())
                    .build();
        }

        throw new UsernameNotFoundException(username);
    }

}
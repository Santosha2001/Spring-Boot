package com.securitydemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securitydemo.model.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {

    Optional<UserDtls> findByUsername(String username);

}

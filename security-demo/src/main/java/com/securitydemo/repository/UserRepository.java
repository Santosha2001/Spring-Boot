package com.securitydemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.securitydemo.model.UserDtls;

@Repository
public interface UserRepository extends JpaRepository<UserDtls, Integer> {

    Optional<UserDtls> findByUsername(String username);

}
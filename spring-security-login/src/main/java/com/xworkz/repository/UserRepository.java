package com.xworkz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xworkz.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
}

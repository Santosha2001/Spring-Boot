package com.workz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workz.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	 Optional<User> findByEmail(String email);
}

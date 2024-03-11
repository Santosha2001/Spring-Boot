package com.spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.demo.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

	// CUSTOM FINDER METHODS
	public UserEntity findByEmail(String email);

	// JPQL: JAVA PERSISTENCE QUERY LANGUAGE
	@Query("Select et.userName From UserEntity et Where et.email =:email")
	public String findNameByEmail(@Param(value = "email") String email);

	// NATIVE SQL QUERY
	@Query(value = "select user_name from user_entity", nativeQuery = true)
	public List<String> findAllNames();
}

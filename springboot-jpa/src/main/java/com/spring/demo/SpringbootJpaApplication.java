package com.spring.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.demo.entities.UserEntity;
import com.spring.demo.repository.UserRepository;

@SpringBootApplication
public class SpringbootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootJpaApplication.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);

		UserEntity entity = new UserEntity();
		entity.setUserName("Gagan");
		entity.setEmail("gagan@gmail.com");
		entity.setMobileNumber(7022590723L);

		UserEntity entity2 = new UserEntity();
		entity2.setUserName("Amruth");
		entity2.setEmail("amruth@gmail.com");
		entity2.setMobileNumber(7022590267L);

		UserEntity entity3 = new UserEntity();
		entity3.setUserName("Santosh");
		entity3.setEmail("santosh@gmail.com");
		entity3.setMobileNumber(7022590204L);

		// CREARE
		// userRepository.save(entity);

		List<UserEntity> saveAll = List.of(entity2, entity3);
		// userRepository.saveAll(saveAll);

		// READ
		Optional<UserEntity> byId = userRepository.findById(2);
		System.out.println(byId);

		System.out.println("____________________________________________________");
		
		//UPDATE
		Optional<UserEntity> byId2 = userRepository.findById(3);
		UserEntity entity4 = byId2.get();
		entity4.setMobileNumber(8152010705L);
		userRepository.save(entity4);
		
		System.out.println(entity4);
		
	}

}

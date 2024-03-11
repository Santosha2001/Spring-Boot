package com.spring.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.demo.entities.UserEntity;
import com.spring.demo.repository.UserRepository;

@SpringBootApplication
public class SpringbootJpaApplicationRunner {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootJpaApplicationRunner.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

		UserEntity byEmail = userRepository.findByEmail("santosh@gmail.com");
		System.out.println(byEmail);
		System.out.println("____________________________________________________");

		String nameByEmail = userRepository.findNameByEmail("santosh@gmail.com");
		System.out.println(nameByEmail);
		System.out.println("____________________________________________________");

		List<String> allNames = userRepository.findAllNames();
		allNames.forEach(System.out::println);
		System.out.println("____________________________________________________");

	}
}

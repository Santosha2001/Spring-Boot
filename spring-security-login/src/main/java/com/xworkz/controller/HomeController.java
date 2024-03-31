package com.xworkz.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.xworkz.entity.User;
import com.xworkz.repository.UserRepository;
import com.xworkz.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private UserService service;

	@Autowired
	private UserRepository repository;

	public HomeController() {
		System.out.println("Home Controller.");
	}

	@ModelAttribute
	public void commonUser(Principal p, Model m) {
		if (p != null) {
			String email = p.getName();
			User user = repository.findByEmail(email);
			m.addAttribute("user", user);
		}

	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user, HttpSession session, Model m) {

		// System.out.println(user);

		User u = service.saveUser(user);

		if (u != null) {
			// System.out.println("save sucess");
			session.setAttribute("msg", "Register successfully");

		} else {
			// System.out.println("error in server");
			session.setAttribute("msg", "Something wrong server");
		}
		return "redirect:/register";
	}

	@GetMapping("/user/profile")
	public String profile(Principal p, Model m) {
		String email = p.getName();
		User user = repository.findByEmail(email);
		m.addAttribute("user", user);
		return "profile";
	}

	@GetMapping("/user/home")
	public String home() {
		return "home";
	}
}

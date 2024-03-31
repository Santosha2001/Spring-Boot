package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.entities.LoginData;

@Controller
public class FormValidationController {

	public FormValidationController() {
		System.out.println("FormValidationController created.");
	}

	@GetMapping("/form")
	public String formValidation(Model model) {
		LoginData loginData = new LoginData();
		
		model.addAttribute("login", loginData);
		return "form";
	}

//	@PostMapping("/process")
//	public String processForm(@ModelAttribute("loginData") LoginData loginData) {
//
//		System.out.println(loginData);
//
//		return "success";
//	}

}

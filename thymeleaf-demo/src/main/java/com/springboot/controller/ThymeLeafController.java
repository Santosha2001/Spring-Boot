package com.springboot.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeLeafController {

	public ThymeLeafController() {
		System.out.println("ThymeLeafController created.");
	}

	@GetMapping("/about")
	public String getHome(Model model) {
		System.out.println("getHome called.");
		model.addAttribute("name", "Santosh");
		model.addAttribute("date", new Date().toLocaleString());

		return "about";
	}

	// for iterating
	@GetMapping("/iterate")
	public String iterate(Model model) {

		List<String> namesList = List.of("Santosh", "Amruth", "Vinutha", "Bindhu", "Gagan");
		model.addAttribute("nameList", namesList);

		return "iterate";
	}

	// thyemeleaf operators
	@GetMapping("/conditional-operator")
	public String elvisOperator(Model model) {
		model.addAttribute("isActive", true);
		model.addAttribute("gender", "F");

		List<Integer> list = List.of(2, 8, 3, 5);
		model.addAttribute("list", list);

		return "conditionals";
	}

	// service
	@GetMapping("/service")
	public String services(Model model) {

		model.addAttribute("title", "this is a title of footer.");
		model.addAttribute("subtitle", "this is a subtitle of footer.");
		return "service";
	}

	// new about
	@GetMapping("/newabout")
	public String newAbout() {
		return "aboutnew";
	}
	
	//footer new
	@GetMapping("/newfooter")
	public String newFooter() {
		return "footernew";
	}
	

}

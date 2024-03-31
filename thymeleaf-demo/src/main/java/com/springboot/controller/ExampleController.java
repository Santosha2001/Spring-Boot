package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {
	public ExampleController() {
		System.out.println("ExampleController");
	}

	@GetMapping("/example")
	public String example() {
		return "example";
	}

}

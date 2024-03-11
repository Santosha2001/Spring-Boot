package com.spring.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

	public DemoController() {
		System.out.println("DemoController");
	}

	@RequestMapping("/test")
	@ResponseBody
	public String handler() {
		System.out.println("Handler invoking..");

		return "This is a first Spring Boot project using STS.";
	}
}

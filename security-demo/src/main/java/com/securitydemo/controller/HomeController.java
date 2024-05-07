package com.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    public HomeController() {
        System.out.println(getClass().getSimpleName());
    }

    @GetMapping("/")
    public String homeHandler() {

        System.out.println("home handler.");
        return "index";
    }

    @GetMapping("/admin/home")
    public String adminHandler() {

        System.out.println("admin home handler.");
        return "admin_home";
    }

    @GetMapping("/user/home")
    public String userHandler() {

        System.out.println("user home handler.");
        return "user_home";
    }

    @GetMapping("/login")
    public String login() {

        System.out.println("login handler.");
        return "custom_login";
    }
}

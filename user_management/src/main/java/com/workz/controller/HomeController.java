package com.workz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.workz.form.UserForm;
import com.workz.model.User;
import com.workz.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	 @Autowired
	    private UserService userService;

	    public HomeController() {
	        System.out.println(getClass().getSimpleName());
	    }

	    
	    @GetMapping("/")
	    public String indexHandler() {
	        return "redirect:/home";
	    }

	    @GetMapping("/home")
	    public String homeHandler() {
	        return "index";
	    }

	    @GetMapping("/about")
	    public String aboutHandler() {
	        return "about";
	    }

	    @GetMapping("/services")
	    public String serviceHandler() {
	        return "services";
	    }

	    @GetMapping("/contact")
	    public String contactHandler() {
	        return new String("contact");
	    }

	    @GetMapping("/login")
	    public String loginHandler() {
	        return new String("login");
	    }

	    @GetMapping("/register")
	    public String registerHandler(Model model) {
	        UserForm userForm = new UserForm();

	        model.addAttribute("userForm", userForm);
	        return new String("register");
	    }

	    @PostMapping("/do-register")
	    public String signupHandler(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult,
	            HttpSession session) {
	        System.out.println("processing form.");
	        System.out.println(userForm);

	        // validation
	        if (bindingResult.hasErrors()) {
	            return "register";
	        }

	        User user = new User();
	        user.setName(userForm.getName());
	        user.setEmail(userForm.getEmail());
	        user.setPassword(userForm.getPassword());
	        user.setMobile(userForm.getMobile());

	        System.out.println(user);

	        // save user
	        User saveUser = userService.saveUser(user);
	        System.out.println("savedUser: " + saveUser);

//	        Message message = Message.builder().content("Registration Successful.").type(MessageType.BLUE).build();

	        session.setAttribute("message", "Registration Successful.");

	        return "redirect:/register";
	    }
}

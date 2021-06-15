package com.evghenia.controllerandviews.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.evghenia.controllerandviews.models.User;
import com.evghenia.controllerandviews.services.UserService;

@Controller
public class MainController {
	@Autowired
    private UserService userService;
	
	@GetMapping("/registration")
	public String registerForm(@ModelAttribute("user")User user) {
		return "registrationPage.jsp";
	}
	@GetMapping("/login")
	public String login() {
		return "loginPage.jsp";
	}
	@PostMapping(value="/registration")
	public String createForm(@Valid@ModelAttribute("user")User user,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			return "registrationPage.jsp";
		}else {
		User u = userService.registerUser(user);
		session.setAttribute("userId",u.getId());
		return "redirect:/home";
	}
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String authenticateUser(@RequestParam("email") String email, @RequestParam("password")String password, Model model,HttpSession session) {
		Boolean isAuthenticated = userService.authenticateUser(email, password);
		//if the user is authenticated save their id in session
		if(isAuthenticated) {
			User u = userService.findByEmail(email);
			session.setAttribute("userId",u.getId());
			return "redirect:/home";
		}else {
			model.addAttribute("error","Invalid account.Please try again.");
			return "loginPage.jsp";
		}
	}
	@GetMapping("/home")
	public String home(HttpSession session,Model model) {
		Long userId = (Long)session.getAttribute("userId");
		User user = userService.findUserById(userId);
		model.addAttribute("user",user);
		return "home.jsp";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
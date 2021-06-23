package com.evghenia.eventsbeltreviewer.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.evghenia.eventsbeltreviewer.models.Event;
import com.evghenia.eventsbeltreviewer.models.User;
import com.evghenia.eventsbeltreviewer.services.EventService;
import com.evghenia.eventsbeltreviewer.services.UserService;
import com.evghenia.eventsbeltreviewer.validator.UserValidator;

@Controller
public class MainController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private EventService eventService;
	
	
	
	@GetMapping("/")
	public String registraterForm(@ModelAttribute("user")User user) {
		return "login.jsp";
	}
	@PostMapping(value="/")
	public String createForm(@Valid@ModelAttribute("user")User user,BindingResult result,HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "login.jsp";
		}else {
		User u = userService.registerUser(user);
		session.setAttribute("userId",u.getId());
		return "redirect:/events";
	}
	
	}
	@PostMapping(value="/login")
	public String authenticateUser(@RequestParam("email") String email, @RequestParam("password")String password, Model model,HttpSession session,RedirectAttributes redirs) {
		Boolean isAuthenticated = userService.authenticateUser(email, password);
		//if the user is authenticated save their id in session
		if(isAuthenticated) {
			User u = userService.findByEmail(email);
			session.setAttribute("userId",u.getId());
			return "redirect:/events";
		}else {
			redirs.addFlashAttribute("error","Invalid account.Please try again.");
			return "login.jsp";
		}
	}
	@GetMapping("/events")
	public String home(@ModelAttribute("event")Event event,HttpSession session,Model model) {
		Long userId = (Long)session.getAttribute("userId");
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		User user = userService.findUserById(userId);
		model.addAttribute("user",user);
		model.addAttribute("inState",this.eventService.getEventsWithState(user.getState()));
		model.addAttribute("outState",this.eventService.getEventsNoState(user.getState()));
		return "event.jsp";
    }
	@PostMapping(value="/events")
	public String createEvent(@Valid@ModelAttribute("events")Event event,BindingResult result,HttpSession session,Model model) {
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("userId");
			User user = userService.findUserById(userId);
			model.addAttribute("user",user);
			return "event.jsp"; 
		}else {
			this.eventService.createEvent(event);
			return "redirect:/events";
		}
	}
	@GetMapping("/events/{id}/edit")
	public String editEvent(@PathVariable("id")Long id,Model model,HttpSession session,RedirectAttributes redirs) {
		Event eventToEdit = this.eventService.getOneEvent(id);
		if((Long) session.getAttribute("userId")!= eventToEdit.getPlanner().getId()) {
			redirs.addFlashAttribute("error","You are  not allowing to change anything");
			return "redirect:/events";
		}
		model.addAttribute("event",eventToEdit);
		return "edit.jsp";
	}
	@PostMapping(value="/events/{id}/edit")
	public String updateEvent(@Valid@ModelAttribute("event")Event event,BindingResult result,@PathVariable("id")Long id,HttpSession session,Model model) {
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("userId");
			model.addAttribute("event",this.eventService.getOneEvent(id));
			return "edit.jsp";
		}
		this.eventService.updateEvent(event);
		return "redirect:/events";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
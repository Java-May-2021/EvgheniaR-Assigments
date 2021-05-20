package com.evghenia.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Human {
	@RequestMapping("/")
    public String index(){
       return "index.jsp";
	}
	@RequestMapping("/users/{name}")
	public String name(@PathVariable("name") String userName, Model model) {
		model.addAttribute("userName",userName);
		return "name.jsp";
	}
}

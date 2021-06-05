package com.evghenia.dojosandninjas.controllers;

import java.util.List;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.evghenia.dojosandninjas.models.Dojo;
import com.evghenia.dojosandninjas.models.Ninja;
import com.evghenia.dojosandninjas.services.DojoService;
import com.evghenia.dojosandninjas.services.NinjaService;

@Controller
public class MainController {
	@Autowired
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo")Dojo dojo) {
		return "dojo.jsp";
	}
	@PostMapping(value="/dojos/new")
	public String createDojo(@Valid@ModelAttribute("dojo")Dojo dojo,BindingResult result) {
		if(result.hasErrors()) {
			return "dojo.jsp";
		}else {
			this.dojoService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja")Ninja ninja,Model model) {
		List<Dojo> dojo = dojoService.getAll();
		model.addAttribute("dojos",dojo);
		return "ninja.jsp";
	}
	@PostMapping(value="/ninjas/new")
	public String createNinja(@Valid@ModelAttribute("ninja")Ninja ninja,BindingResult result,@ModelAttribute("dojo")Dojo dojo) {
		if(result.hasErrors()) {
			return "ninja.jsp";
		}else {
			this.ninjaService.createNinja(ninja);
			return "redirect:/dojos/" + dojo.getId();
		}
	}
	@GetMapping("/dojos/{id}")
	public String viewDojo(@PathVariable ("id")Long id,Model model) {
		Dojo dojo = dojoService.getDojoById(id);
		model.addAttribute("dojo",dojo);
		model.addAttribute("ninjas",dojo.getNinjas());
		return "show.jsp";
	}
	
}

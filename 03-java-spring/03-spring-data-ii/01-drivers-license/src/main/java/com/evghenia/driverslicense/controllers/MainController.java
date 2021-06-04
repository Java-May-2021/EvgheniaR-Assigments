package com.evghenia.driverslicense.controllers;

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

import com.evghenia.driverslicense.models.License;
import com.evghenia.driverslicense.models.Person;
import com.evghenia.driverslicense.services.LicenseService;
import com.evghenia.driverslicense.services.PersonService;

@Controller
public class MainController {
	@Autowired
	private PersonService personService;
	@Autowired
	private LicenseService licenseService;
	
	@GetMapping("/persons/new")
	public String newPerson(@ModelAttribute("person")Person person) {
		return "person.jsp";
	}
	@PostMapping(value="/persons")
	public String createPerson(@Valid@ModelAttribute("person")Person person,BindingResult result) {
		if(result.hasErrors()) {
			return "person.jsp";
		}else {
			this.personService.createPerson(person);
			return "redirect:/licenses/new";
		}
		
	}
	@GetMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license")License license,Model model) {
		List<Person> person = personService.getAll();
		model.addAttribute("persons",person);
		return "license.jsp";
	}
	@PostMapping(value="/licenses")
	public String  createLicense(@Valid@ModelAttribute("license")License license,BindingResult result) {
		if(result.hasErrors()) {
			return "license.jsp";
		}else {
			this.licenseService.createLicense(license);
			return "redirect:/persons/new";
		}
	}
	@GetMapping("/persons/{id}")
	public String showLicense(@PathVariable("id")Long id,Model model) {
		Person person = this.personService.getSinglePerson(id);
		model.addAttribute("person",person);
		if(person.getLicense() != null) {
			License license = person.getLicense();
			model.addAttribute("license",license);
		}
		return "show.jsp";
		
  }
}
package com.evghenia.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.evghenia.languages.models.Language;
import com.evghenia.languages.services.LanguageService;

@Controller
public class LanguageController {
	@Autowired
    private LanguageService lService;
	
	@GetMapping("/languages")
	public String index(@ModelAttribute("language") Language language,Model model) {
		List<Language> languages = this.lService.getAllLanguages();
		model.addAttribute("languages" ,languages);
		return "index.jsp";
	}
	@PostMapping(value="/languages")
	public String createLanguage(@Valid@ModelAttribute("language")Language language,BindingResult result) {
		if(result.hasErrors()) {
			return "/languages";
		}else {
			lService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	@GetMapping("/languages/{id}")
	public String findById(@ModelAttribute("language") Language language,Model model,@PathVariable("id") Long id) {
		Language newLanguage = this.lService.getSingleLanguage(id);
		model.addAttribute("language",newLanguage);
		return "showLanguage.jsp";
	}
	@GetMapping("/languages/{id}/edit")
	public String editLanguage(@ModelAttribute("language")Language language,Model model,@PathVariable("id")Long id) {
		model.addAttribute("language",lService.getSingleLanguage(id));
		return "editLanguage.jsp";
	}
	@PutMapping("languages/{id}/update")
	public String updateLanguage(@Valid@ModelAttribute("language") Language language,BindingResult result ,@PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "editLanguage.jsp";
		}else {
			lService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	@GetMapping("languages/{id}/delete")
	public String deleteLanguage(@PathVariable("id") Long id) {
		lService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
	
}

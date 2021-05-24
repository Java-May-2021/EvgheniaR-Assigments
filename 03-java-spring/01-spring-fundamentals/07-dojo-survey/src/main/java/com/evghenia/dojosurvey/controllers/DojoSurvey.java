package com.evghenia.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoSurvey {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(path="/result", method=RequestMethod.POST)
	public String result(@RequestParam(value="name")String name,@RequestParam(value="location") String location,@RequestParam(value="language")String language,@RequestParam(value="comment")String comment,Model model) {
		model.addAttribute("name", name);
		model.addAttribute("location",location);
		model.addAttribute("language",language);
		model.addAttribute("comment",comment);
		if(language.equals("Java")) {
			return "java.jsp";
		}
		else {
		    return "result.jsp";
		}
	}

}

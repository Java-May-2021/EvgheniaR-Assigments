package com.evghenia.dojooverflow.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.evghenia.dojooverflow.models.Answer;
import com.evghenia.dojooverflow.models.Question;
import com.evghenia.dojooverflow.models.Tag;
import com.evghenia.dojooverflow.services.MainService;


@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@GetMapping("/questions")
	public String dashboard(@ModelAttribute("quest") Question question, @ModelAttribute("tags") Tag tags, Model model) {
		List<Question> allQuestions = this.mainService.getAllQuestions();
		List<Tag> allTags = this.mainService.getAllTags();
		model.addAttribute("allQuestions", allQuestions);
		model.addAttribute("allTags", allTags);
		return "index.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("quest") Question question) {
		return "question.jsp";
	}
	
	@PostMapping("/questions/new")
	public String createQuestion(@Valid @ModelAttribute("quest") Question question, BindingResult result, Tag tag, Model model) {
		if(result.hasErrors()) {
			return "question.jsp";
		}
		this.mainService.createQuestion(question);
		return "redirect:/questions";
	}
	
	@GetMapping("/questions/{id}")
	public String showQuestion(@PathVariable("id") Long id, @ModelAttribute("ans") Answer answer, Model model) {
		Long questionId = id;
		List<Answer> allAnswers = this.mainService.getAllAnswers();
		model.addAttribute("question", this.mainService.getSingleQuestion(questionId));
		model.addAttribute("allAnswers", this.mainService.getAllAnswers());
		return "show.jsp";
	}
	
	@PostMapping("/answers")
	public String createAnswers(@Valid @ModelAttribute("ans") Answer answer, BindingResult result, Model model, Long id) {
		if(result.hasErrors()) {
			return "show.jsp";
		}
		this.mainService.addAnswer(answer);
		return "redirect:/questions/" + answer.getQuestion().getId();
	}
}

package com.evghenia.strings.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringController {
	@RequestMapping("/")
	public String index() {
		return "Hello client.How are you doing?";
	}
	@RequestMapping("/random")
	public String random() {
		return "Spring Boot is great.So easy to just response with strings";
	}
}

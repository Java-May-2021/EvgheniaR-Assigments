package com.evghenia.counter.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Counter {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count",0);
		}
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String countTimes(HttpSession session) {
		Integer currentCount = (Integer) session.getAttribute("count");
		currentCount++;
		session.setAttribute("count", currentCount);
		return "counter.jsp";
	}
	@RequestMapping("/new")
	public String count(HttpSession session) {
		Integer currentCount = (Integer) session.getAttribute("count");
		currentCount +=2;
		session.setAttribute("count", currentCount);
		return "new.jsp";
	}
	@RequestMapping("/reset")
	public String clear(HttpSession session) {
		session.setAttribute("count", 0);
		return "counter.jsp";
	}
}

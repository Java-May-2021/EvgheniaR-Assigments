package com.evghenia.show.controllers;

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
import com.evghenia.show.models.Book;
import com.evghenia.show.services.BookService;

@Controller
public class BookController {
	@Autowired
    private  BookService bookService;
	
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> allBooks = this.bookService.getAllBooks();
		model.addAttribute("books",allBooks);
		return "books/index.jsp";
	}
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book")Book book) {
		return "books/new.jsp";
	}
	@PostMapping(value="/books")
	public String create(@Valid @ModelAttribute("book")Book book,BindingResult result) {
		if(result.hasErrors()) {
			return "books/new.jsp";
		}else { 
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	@GetMapping("/books/{id}")
	public String findById(@ModelAttribute("book")Book book,Model model,@PathVariable("id")Long id) {
		Book newBook = this.bookService.getSingleBook(id);
		model.addAttribute("book",newBook);
		return "showBook.jsp";
	}
}
package com.evghenia.updateanddelete.services;

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

import com.evghenia.updateanddelete.controllers.BookService;
import com.evghenia.updateanddelete.models.Book;

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
	@RequestMapping("/books/edit/{id}")
	public String editBook(@PathVariable("id")Long id,Model model) {
		Book book =this.bookService.findBook(id);
		if(book != null) {
			model.addAttribute("book", book);
			return "books/editBook.jsp";
		}else {
			return "redirect:/books";
		}
	}
    @PostMapping("/books/edit/{id}")
    public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result,Model model) {
        if (result.hasErrors()) {
            return "showBook.jsp";
        }else{
            this.bookService.updateBook(book);
            return "redirect:/books/{id}";
        }
    }
    @RequestMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id")Long id) {
    	this.bookService.deleteBook(id);
    	return "redirect:/books";
    }

}
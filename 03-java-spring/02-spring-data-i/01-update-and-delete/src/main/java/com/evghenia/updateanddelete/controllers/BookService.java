package com.evghenia.updateanddelete.controllers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evghenia.updateanddelete.models.Book;
import com.evghenia.updateanddelete.repositories.BookRepository;


@Service
public class BookService {
	private List<Book> books = new ArrayList<Book>(Arrays.asList(
            new Book("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309),
            new Book("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180),
            new Book("Moby Dick", "The saga of Captain Ahab", "english", 544),
            new Book("Don Quixote", "Life of a retired country gentleman", "english", 150),
            new Book("The Odyssey", "Ancient Greek epic poem", "english", 475)
            ));
	public List<Book> allBook(){
		return books;
	}
	public Book findById(int id) {
		if(id< books.size()) {
			return books.get(id);
		}else {
			return null;
		}
	}
	public List<Book> saveBook(Book book) {
		return books;
	}
	@Autowired
	private final BookRepository bookRepository;
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}else {
			return null;
		}
	}
	public Book getSingleBook(Long id) {
		return this.bookRepository.findById(id).orElse(null);
	}
	public Book updateBook(Book updatedBook) {
		return this.bookRepository.save(updatedBook);
	}
	public void deleteBook(Long id) {
		this.bookRepository.deleteById(id);
	}
}

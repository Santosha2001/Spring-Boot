package com.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.entities.Book;
import com.springboot.services.BookService;
import com.springboot.services.BookServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private BookServiceImpl bookServiceImpl;

	public BookController() {
		System.out.println("BookController created.");
	}

	// get all books handler
	@GetMapping(value = "/books")
	@ResponseBody
	public List<Book> getBooks() {

		// return this.bookService.getAllBooks();
		return this.bookServiceImpl.getAllBooks();

	}

	// get single book handler
	@GetMapping("/books/{id}")
	@ResponseBody
	public Book getSingleBook(@PathVariable("id") int id) {

		// return bookService.getBookById(id);
		return bookServiceImpl.getBookById(id);
	}

	// add new book handler
	@PostMapping("/books")
	@ResponseBody
	public Book addingBook(@RequestBody Book book) {
		System.out.println(book);

		// return this.bookService.addBook(book);

		return bookServiceImpl.addBook(book);
	}

	// delete book handler
	@DeleteMapping("/books/{id}")
	@ResponseBody
	public void deleteBook(@PathVariable("id") int id) {
		System.out.println(id);

		// this.bookService.deleteBook(id);
		bookServiceImpl.deleteBookById(id);

	}

	// update book
	@PutMapping("/books/{id}")
	@ResponseBody
	public Book updateBook(@RequestBody Book book, @PathVariable("id") int id) {
		// this.bookService.updateBook(book, id);
		bookServiceImpl.updateBook(book, id);
		return book;
	}
}

package com.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entities.Book;
import com.springboot.repository.BookRepository;

@Service
public class BookServiceImpl {

	@Autowired
	private BookRepository bookRepository;

	// get all books
	public List<Book> getAllBooks() {
		List<Book> books = (List<Book>) this.bookRepository.findAll();
		return books;
	}

	// get book by id
	public Book getBookById(int id) {
		return this.bookRepository.findById(id);
	}

	// add book
	public Book addBook(Book book) {
		return this.bookRepository.save(book);
	}

	// delete book by id
	public void deleteBookById(int id) {
		this.bookRepository.deleteById(id);
	}

	// update book
	public void updateBook(Book book, int id) {
		book.setId(id);
		this.bookRepository.save(book);
	}

}

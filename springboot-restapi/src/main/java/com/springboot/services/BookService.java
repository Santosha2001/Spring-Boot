package com.springboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.entities.Book;

@Service
public class BookService {

	private static List<Book> books = new ArrayList<>();

	static {
//		books.add(new Book(1, "Java complete reference.", "Santosh"));
//		books.add(new Book(2, "Coding stuff", "Amruth"));
//		books.add(new Book(3, "Head first servlet", "Bindhu"));
//		books.add(new Book(4, "Boaring stuf with python", "Vinutha"));
	}

	// get all books
	public List<Book> getAllBooks() {
		return books;
	}

	// get single book by id
	public Book getBookById(int id) {
		Book book = books.stream().filter(a -> a.getId() == id).findFirst().get();

		return book;
	}

	// adding the book
	public Book addBook(Book book) {
		books.add(book);

		return book;
	}

	// deleting a book
	public void deleteBook(int id) {
		List<Book> collect = books.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
		collect.forEach(book -> System.out.println(book));

	}

	// update book
	public void updateBook(Book book, int id) {
		books.stream().map(b -> {
			if (b.getId() == id) {
				b.setBookAuthor(book.getBookAuthor());
				b.setBookName(book.getBookName());
			}
			return b;
		}).collect(Collectors.toList());
	}
}

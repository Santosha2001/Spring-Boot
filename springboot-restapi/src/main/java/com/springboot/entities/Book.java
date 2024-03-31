package com.springboot.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bookName;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Author bookAuthor;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String bookName, Author bookAuthor) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}

	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Author getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(Author bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

}

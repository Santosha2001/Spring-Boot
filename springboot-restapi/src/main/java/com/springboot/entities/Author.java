package com.springboot.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorId;
	private String firstName;
	private String lastName;
	private String languageSpeak;

	@OneToOne(mappedBy = "bookAuthor")
	@JsonBackReference
	private Book book;

	public Author() {
		// TODO Auto-generated constructor stub
	}

	public Author(int authorId, String firstName, String lastName, String languageSpeak) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.languageSpeak = languageSpeak;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", languageSpeak=" + languageSpeak + "]";
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLanguageSpeak() {
		return languageSpeak;
	}

	public void setLanguageSpeak(String languageSpeak) {
		this.languageSpeak = languageSpeak;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}

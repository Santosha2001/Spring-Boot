package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

	Book findById(int id);
}

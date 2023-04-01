package com.mvc.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.demo.models.Book;


// CrudRepository is a Spring Data interface for generic CRUD operations on a repository of a specific type.
// It provides several methods out of the box for interacting with a database.
// CrudRepository<T, ID>

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
//	default non-static return-List<> name();  <-- No {Body} since it's abstract method in Interface
	List<Book> findAll();  // this method retrieves all the books from the database
	List<Book> findByDescriptionContaining(String search);  // this method finds books with descriptions containing the search string
//  Long countByTitleContaining(String search);  // this method counts how many titles contain a certain string
//  Long deleteByTitleStartingWith(String search);  // this method deletes a book that starts with a specific title
//	List<Book> findByTitleIs(String title);
	
}

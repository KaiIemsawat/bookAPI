package com.mvc.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mvc.demo.models.Book;
import com.mvc.demo.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	
	
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
    		System.out.println("There is no book with that id, please try again");
            return null;
        }
    }
    
//    To save the new value after edited
    public Book updateBook(Book book) {
    	return bookRepository.save(book);
    }
    
    
    public void deleteBook(Long id) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
    	if (optionalBook.isPresent()) {
    		bookRepository.deleteById(id);
    	}
    	else {
    		System.out.println("There is no book with that id, please try again");
    	}
    	
    }
}

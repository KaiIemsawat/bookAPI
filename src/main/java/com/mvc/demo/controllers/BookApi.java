package com.mvc.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.demo.models.Book;
import com.mvc.demo.services.BookService;


@RestController
public class BookApi {
	
	@Autowired
	private BookService bookService;
//	---------------------------------------
//	Use @Autowired to replace below codes
//	---------------------------------------
//	private final BookService bookService;
//
//	public BookApi(BookService bookService) {
//		this.bookService = bookService;
//	}
//	----------------------------------------
	

//	Method to get all of the books
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
    
//    Add new book to database
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
//    Get to the needed book by ID
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
    
//    Reassign/update a current book by id
//    Note **** once the values are edited it need to be saved
    @RequestMapping(value="/api/books/update/{id}", method=RequestMethod.PUT)
    public void update(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages, @RequestParam(value="id") Long id) {
    	Book book = bookService.findBook(id);
    	book.setTitle(title);
    	book.setDescription(desc);
    	book.setLanguage(lang);
    	book.setNumberOfPages(numOfPages);
    	book.setId(id);
    	bookService.updateBook(book);
    }
    
//    Delete a book by id
    @RequestMapping(value="/api/books/delete/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	bookService.deleteBook(id);
    }
	
}

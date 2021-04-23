package com.codingdojo.book.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.book.models.MBook;
import com.codingdojo.book.services.BookService;

@RestController
public class BooksApi {

	private final BookService bookService;
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    @RequestMapping("/api/books")
    public List<MBook> index() {
        return bookService.allBooks();
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public MBook create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, 						@RequestParam(value="language") String lang, @RequestParam(value="numberOfPages") Integer numberOfPages) {
        MBook book = new MBook(title, desc, lang, numberOfPages);
        return bookService.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public MBook show(@PathVariable("id") Long id) {
        MBook book = bookService.findBook(id);
        return book;
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public MBook update(@PathVariable("id") Long id,MBook b ) {
        return bookService.updateBook(b);
    }
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }	
}


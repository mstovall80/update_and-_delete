package com.codingdojo.book.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.book.models.MBook;
import com.codingdojo.book.repositories.BookRepository;

@Service
public class BookService {

	 // adding the book repository as a dependency
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<MBook> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public MBook createBook(MBook b) {
        return bookRepository.save(b);
    }
    public MBook updateBook(MBook b) {
    	return bookRepository.save(b);
    }
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
    // retrieves a book
    public MBook findBook(Long id) {
        Optional<MBook> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }


}

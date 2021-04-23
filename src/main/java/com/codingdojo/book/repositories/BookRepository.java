package com.codingdojo.book.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.book.models.MBook;

@Repository
public interface BookRepository extends CrudRepository<MBook, Long>{
	// this method retrieves all the books from the database
    List<MBook> findAll();
    // this method finds books with descriptions containing the search string
    List<MBook> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
}

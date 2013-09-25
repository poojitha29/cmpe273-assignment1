package edu.sjsu.cmpe.library.repository;

import edu.sjsu.cmpe.library.domain.Author;
import edu.sjsu.cmpe.library.domain.Book;
import edu.sjsu.cmpe.library.domain.Reviews;

/**
 * Book repository interface.
 * 
 * What is repository pattern?
 * 
 * @see http://martinfowler.com/eaaCatalog/repository.html
 */
public interface BookRepositoryInterface {
    /**
     * Save a new book in the repository
     * 
     * @param newBook
     *            a book instance to be create in the repository
     * @return a newly created book instance with auto-generated ISBN
     */
    Book saveBook(Book newBook);
    Book createReview(Book newBook);
    /**
     * Retrieve an existing book by ISBN
     * 
     * @param isbn
     *            a valid ISBN
     * @return a book instance
     */
    Book getBookByISBN(Long isbn);

    
    boolean deleteBookByISBN (Long isbn);
  
    boolean updateBookByISBN(Long isbn,String status);
    
    Reviews getReviewByID(Long isbn,int id);
    Author getAuthorByID(Long isbn,int id);
    boolean getAuthorByIsbn(Long isbn);
    boolean getReviewsByIsbn(Long isbn);
    // TODO: add other operations here!
}

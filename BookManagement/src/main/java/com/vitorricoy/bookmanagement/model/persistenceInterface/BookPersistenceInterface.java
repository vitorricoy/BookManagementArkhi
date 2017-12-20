package com.vitorricoy.bookmanagement.model.persistenceInterface;

import com.vitorricoy.bookmanagement.model.domain.Author;
import com.vitorricoy.bookmanagement.model.domain.Book;
import com.vitorricoy.bookmanagement.model.exception.PersistenceException;
import java.util.List;

/**
 * Interface to define the BookPersistence's methods
 * @author vitor
 */
public interface BookPersistenceInterface {
    /**
     * Insert a book
     * @param book The book to be inserted
     * @return The inserted book
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Book insertBook(Book book) throws PersistenceException;

    /**
     * Get a book by it's id
     * @param isbn The desired book's isbn
     * @return The corresponding book
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Book getBookById(String isbn) throws PersistenceException;

    /**
     * Remove a book
     * @param isbn The desired book's isbn
     * @return The corresponding removed book
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Book removeBook(String isbn) throws PersistenceException;

    /**
     * Update a book
     * @param newBook The new book
     * @param isbn The old book isbn
     * @return The updated book
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Book updateBook(Book newBook, String isbn) throws PersistenceException;
    
    /**
     * Get a list of books by author
     * @param author The book author
     * @return The list of books written by this author
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public List<Book> getBookByAuthor(Author author) throws PersistenceException;
    
    /**
     * List all books
     * @return A list with all books
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public List<Book> listAll() throws PersistenceException;
}

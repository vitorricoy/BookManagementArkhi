package com.vitorricoy.bookmanagement.model.serviceInterface;

import com.vitorricoy.bookmanagement.model.domain.Author;
import com.vitorricoy.bookmanagement.model.domain.Book;
import com.vitorricoy.bookmanagement.model.exception.BusinessException;
import com.vitorricoy.bookmanagement.model.exception.PersistenceException;
import java.util.List;

/**
 * Interface to define the BookService's methods
 * @book vitor
 */
public interface BookServiceInterface {
    /**
     * Insert a book in the persistence
     * @param book The book to be inserted
     * @return The inserted book
     * @throws com.vitorricoy.bookmanagement.model.exception.BusinessException
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Book insertBook(Book book) throws BusinessException, PersistenceException;

    /**
     * Get a book in the persistence by it's id
     * @param isbn The desired book's isbn
     * @return The corresponding book
     * @throws com.vitorricoy.bookmanagement.model.exception.BusinessException
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Book getBookById(String isbn) throws BusinessException, PersistenceException;

    /**
     * Remove a book from the persistence
     * @param isbn The desired book's isbn
     * @return The corresponding removed book
     * @throws com.vitorricoy.bookmanagement.model.exception.BusinessException
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Book removeBook(String isbn) throws BusinessException, PersistenceException;

    /**
     * Update a book in the persistence
     * @param newBook The new book
     * @param isbn The old book isbn
     * @return The updated book
     * @throws com.vitorricoy.bookmanagement.model.exception.BusinessException
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Book updateBook(Book newBook, String isbn) throws BusinessException, PersistenceException;
    
    /**
     * Get a list of books by author
     * @param author The book author
     * @return The list of books written by this author
     * @throws com.vitorricoy.bookmanagement.model.exception.BusinessException
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public List<Book> getBookByAuthor(Author author) throws BusinessException, PersistenceException;
    
    /**
     * List all books
     * @return A list with all books
     * @throws com.vitorricoy.bookmanagement.model.exception.BusinessException
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public List<Book> listAll() throws BusinessException, PersistenceException;
}

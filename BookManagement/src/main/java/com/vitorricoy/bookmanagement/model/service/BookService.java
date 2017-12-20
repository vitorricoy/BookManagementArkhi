package com.vitorricoy.bookmanagement.model.service;

import com.vitorricoy.bookmanagement.model.domain.Author;
import com.vitorricoy.bookmanagement.model.domain.Book;
import com.vitorricoy.bookmanagement.model.exception.BusinessException;
import com.vitorricoy.bookmanagement.model.exception.PersistenceException;
import com.vitorricoy.bookmanagement.model.persistenceInterface.BookPersistenceInterface;
import com.vitorricoy.bookmanagement.model.serviceInterface.BookServiceInterface;
import java.util.List;

/**
 * Book Service
 * @author vitor
 */
public class BookService implements BookServiceInterface{
    
    BookPersistenceInterface persistence;
    
    public BookService(BookPersistenceInterface persistence){
        this.persistence=persistence;
    }
    
    @Override
    public Book insertBook(Book book) throws BusinessException, PersistenceException {
        if(book.getAuthors()==null || book.getAuthors().isEmpty()){
            throw new BusinessException("Book authors can't be null or empty");
        }
        if(book.getIsbn()==null || book.getIsbn().equals("")){
            throw new BusinessException("Book isbn can't be null or empty");
        }
        if(book.getPrice()==null){
            throw new BusinessException("Book price can't be null");
        }
        if(book.getPublisher()==null || book.getPublisher().equals("")){
            throw new BusinessException("Book publisher can't be null or empty");
        }
        if(book.getReleaseDate()==null){
            throw new BusinessException("Book release date can't be null");
        }
        if(book.getReviews()==null || book.getReviews().isEmpty()){
            throw new BusinessException("Book reviews can't be null or empty");
        }
        if(book.getTitle()==null || book.getTitle().equals("")){
            throw new BusinessException("Book title can't be null or empty");
        }
        return persistence.insertBook(book);
    }

    @Override
    public Book getBookById(String isbn) throws BusinessException, PersistenceException {
        if(isbn==null || isbn.equals("")){
            throw new BusinessException("Book isbn can't be null or empty");
        }
        return persistence.getBookById(isbn);
    }

    @Override
    public Book removeBook(String isbn) throws BusinessException, PersistenceException {
        if(isbn==null || isbn.equals("")){
            throw new BusinessException("Book isbn can't be null or empty");
        }
        return persistence.removeBook(isbn);
    }

    @Override
    public Book updateBook(Book newBook, String isbn) throws BusinessException, PersistenceException {
        if(isbn==null || isbn.equals("")){
            throw new BusinessException("Book isbn can't be null or empty");
        }
        if(newBook.getAuthors()==null || newBook.getAuthors().isEmpty()){
            throw new BusinessException("Book authors can't be null or empty");
        }
        if(newBook.getIsbn()==null || newBook.getIsbn().equals("")){
            throw new BusinessException("Book isbn can't be null or empty");
        }
        if(newBook.getPrice()==null){
            throw new BusinessException("Book price can't be null");
        }
        if(newBook.getPublisher()==null || newBook.getPublisher().equals("")){
            throw new BusinessException("Book publisher can't be null or empty");
        }
        if(newBook.getReleaseDate()==null){
            throw new BusinessException("Book release date can't be null");
        }
        if(newBook.getReviews()==null || newBook.getReviews().isEmpty()){
            throw new BusinessException("Book reviews can't be null or empty");
        }
        if(newBook.getTitle()==null || newBook.getTitle().equals("")){
            throw new BusinessException("Book title can't be null or empty");
        }
        newBook.setIsbn(isbn);
        return persistence.updateBook(newBook, isbn);
    }

    @Override
    public List<Book> getBookByAuthor(Author author) throws BusinessException, PersistenceException {
        if(author.getAuthorName()==null || author.getAuthorName().equals("")){
            throw new BusinessException("Author's name can't be null or empty");
        }
        if(author.getBirthDate()==null){
            throw new BusinessException("The author's birth date can't be null");
        }
        return persistence.getBookByAuthor(author);
    }

    @Override
    public List<Book> listAll() throws BusinessException, PersistenceException {
        return persistence.listAll();
    }
    
}

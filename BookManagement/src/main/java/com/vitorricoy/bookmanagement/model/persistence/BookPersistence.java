package com.vitorricoy.bookmanagement.model.persistence;

import com.vitorricoy.bookmanagement.model.domain.Author;
import com.vitorricoy.bookmanagement.model.domain.Book;
import com.vitorricoy.bookmanagement.model.exception.PersistenceException;
import com.vitorricoy.bookmanagement.model.persistenceInterface.BookPersistenceInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Book Persistence implemented using RAM
 * @author vitor
 */
public class BookPersistence implements BookPersistenceInterface{
    
    private HashMap<String, Book> table;
    private static BookPersistence instance = null;
    
    private BookPersistence(){
        table = new HashMap<>();
    }
    
    public static BookPersistence getInstance(){
        if(instance==null){
            instance = new BookPersistence();
        }
        return instance;
    }
    
    @Override
    public Book insertBook(Book book) throws PersistenceException {
        if(table.containsKey(book.getIsbn())){
            throw new PersistenceException("Duplicated key");
        }
        table.put(book.getIsbn(), book);
        return book;
    }

    @Override
    public Book getBookById(String isbn) throws PersistenceException {
        Book book = table.get(isbn);
        if(book==null){
            throw new PersistenceException("Book with key " + isbn + " not found");
        }
        return book;
    }

    @Override
    public Book removeBook(String isbn) throws PersistenceException {
        Book book = table.remove(isbn);
        if(book==null){
            throw new PersistenceException("Book with key " + isbn + " not found to be removed");
        }
        return book;
    }

    @Override
    public Book updateBook(Book newBook, String isbn) throws PersistenceException {
        Book book = table.replace(isbn, newBook);
        if(book==null){
            throw new PersistenceException("Book with key " + isbn + " not found to be updated");
        }
        return newBook;
    }

    @Override
    public List<Book> getBookByAuthor(Author author) throws PersistenceException {
        List<Book> books = new ArrayList<>();
        //Iterate trough persistence table
        for(Map.Entry<String, Book> b:table.entrySet()){
            List<Author> authors = b.getValue().getAuthors();
            //Iterate through each book authors
            for(Author a: authors){
                //If the books have the searched author add it in the list
                if(a.getId().equals(author.getId())){
                    books.add(b.getValue());
                }
            }
        }
        return books;
    }
    
    public void cleanData(){
        table = new HashMap<>();
    }
    
}

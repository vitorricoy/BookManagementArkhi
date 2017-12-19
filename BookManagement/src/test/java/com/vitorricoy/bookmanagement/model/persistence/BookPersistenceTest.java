/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitorricoy.bookmanagement.model.persistence;

import com.vitorricoy.bookmanagement.model.domain.Author;
import com.vitorricoy.bookmanagement.model.domain.Book;
import com.vitorricoy.bookmanagement.model.domain.Review;
import com.vitorricoy.bookmanagement.model.exception.PersistenceException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitor
 */
public class BookPersistenceTest {
    
    private BookPersistence persistence;
    private List<Author> authors;
    private List<Review> reviews;
    private Date release;
    
    public BookPersistenceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        persistence = new BookPersistence();
        authors = new ArrayList<>();
        authors.add(new Author(new Long(0), "John", new Date()));
        authors.add(new Author(new Long(1), "Mary", new Date()));
        reviews = new ArrayList<>();
        reviews.add(new Review(new Long(0), "Max", 9, "It's excellent"));
        reviews.add(new Review(new Long(1), "Juliet", 3, "Poor reading"));
        release = new Date();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertBook method, of class BookPersistence.
     */
    @org.junit.Test
    public void testInsertBook1() throws Exception {
        System.out.println("insertBook1");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        Book result = persistence.insertBook(book);
        assertEquals(book, result);
        try{
            Book result2 = persistence.getBookById(book.getIsbn());
        }catch(PersistenceException ex){
            fail("Didn't insert the book");
        }
    }
    
    /**
     * Test of insertBook method, of class BookPersistence.
     */
    @org.junit.Test
    public void testInsertBook2() throws Exception {
        System.out.println("insertBook2");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        Book result = persistence.insertBook(book);
        assertEquals(book, result);
        Book book2 = new Book("1940593758372", "Around the World", authors, "Reading Inc", release, 10.00, reviews);
        try{
            Book result2 = persistence.insertBook(book2);
        }catch(PersistenceException ex){
            return;
        }
        fail("Accepted duplicated keys");
    }

    /**
     * Test of getBookById method, of class BookPersistence.
     */
    @org.junit.Test
    public void testGetBookById1() throws Exception {
        System.out.println("getBookById1");
        String isbn = "1940593758372";
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        book = persistence.insertBook(book);
        Book result = persistence.getBookById(isbn);
        assertEquals(book, result);
    }
    
    /**
     * Test of getBookById method, of class BookPersistence.
     */
    @org.junit.Test
    public void testGetBookById2() throws Exception {
        System.out.println("getBookById2");
        String isbn = "2765593758372";
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        book = persistence.insertBook(book);
        try{
            Book result = persistence.getBookById(isbn);
        }catch(PersistenceException ex){
            return;
        }
        fail("Searched for an invalid key");
    }

    /**
     * Test of removeBook method, of class BookPersistence.
     */
    @org.junit.Test
    public void testRemoveBook1() throws Exception {
        System.out.println("removeBook1");
        String isbn = "1940593758372";
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        book = persistence.insertBook(book);
        Book result = persistence.removeBook(isbn);
        assertEquals(book, result);
        try{
            persistence.getBookById(isbn);
        }catch(PersistenceException ex){
            return;
        }
        fail("Didn't remove the book");
    }
    
    /**
     * Test of removeBook method, of class BookPersistence.
     */
    @org.junit.Test
    public void testRemoveBook2() throws Exception {
        String isbn = "2765593758372";
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        persistence.insertBook(book);
        try{
            Book result = persistence.removeBook(isbn);
        }catch(PersistenceException ex){
            return;
        }
        fail("Removed an invalid key");
    }

    /**
     * Test of updateBook method, of class BookPersistence.
     */
    @org.junit.Test
    public void testUpdateBook1() throws Exception {
        String isbn = "1940593758372";
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        persistence.insertBook(book);
        Book book2 = new Book("1940593758372", "Around", authors, "Reading Inc", release, 20.00, reviews);
        Book result = persistence.updateBook(book2, isbn);
        assertEquals(result, book2);
        Book result2 = persistence.getBookById(isbn);
        assertEquals(result2, book2);
    }
    
    /**
     * Test of updateBook method, of class BookPersistence.
     */
    @org.junit.Test
    public void testUpdateBook2() throws Exception {
        String isbn = "2765593758372";
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        persistence.insertBook(book);
        Book book2 = new Book("1940593758372", "Around", authors, "Reading Inc", release, 20.00, reviews);
        try{
            Book result = persistence.updateBook(book2, isbn);
        }catch(PersistenceException ex){
            return;
        }
        fail("Updated an invalid key");
    }
    
    /**
     * Test of getBookByAuthor method, of class BookPersistence.
     */
    @org.junit.Test
    public void testGetBookByAuthor1() throws Exception {
        System.out.println("getBookByAuthor1");
        Author author = new Author(new Long(0), "John", new Date());
        Book book1 = new Book("1940593744332", "Trips", authors, "Reading Inc", release, 30.00, reviews);
        Book book2 = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        persistence.insertBook(book1);
        persistence.insertBook(book2);
        List<Book> result = persistence.getBookByAuthor(author);
        assertEquals(2, result.size());
        Author author2 = new Author(new Long(1), "Mary", new Date());
        result = persistence.getBookByAuthor(author);
        assertEquals(2, result.size());
        Author author3 = new Author(new Long(2), "Jonny", new Date());
        result = persistence.getBookByAuthor(author3);
        assertEquals(0, result.size());
    }
    
}

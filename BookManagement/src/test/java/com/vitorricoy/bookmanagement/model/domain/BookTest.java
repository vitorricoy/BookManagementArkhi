/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitorricoy.bookmanagement.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author vitor
 */
public class BookTest {
    
    private Book book;
    private ArrayList<Author> authors;
    private ArrayList<Review> reviews;
    private Date release;
    
    public BookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        authors = new ArrayList<>();
        authors.add(new Author(new Long(0), "John", new Date()));
        authors.add(new Author(new Long(1), "Mary", new Date()));
        reviews = new ArrayList<>();
        reviews.add(new Review(new Long(0), "Max", 9, "It's excellent"));
        reviews.add(new Review(new Long(1), "Juliet", 3, "Poor reading"));
        release = new Date();
        book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIsbn method, of class Book.
     */
    @org.junit.Test
    public void testGetIsbn() {
        System.out.println("getIsbn");
        String expResult = "1940593758372";
        String result = book.getIsbn();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIsbn method, of class Book.
     */
    @org.junit.Test
    public void testSetIsbn() {
        System.out.println("setIsbn");
        String isbn = "1234567891012";
        book.setIsbn(isbn);
        assertEquals(isbn, book.getIsbn());
    }

    /**
     * Test of getTitle method, of class Book.
     */
    @org.junit.Test
    public void testGetTitle() {
        System.out.println("getTitle");
        String expResult = "Adventures";
        String result = book.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class Book.
     */
    @org.junit.Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String Title = "Fantasy";
        book.setTitle(Title);
        assertEquals(Title, book.getTitle());
    }

    /**
     * Test of getAuthors method, of class Book.
     */
    @org.junit.Test
    public void testGetAuthors() {
        System.out.println("getAuthors");
        List<Author> expResult = authors;
        List<Author> result = book.getAuthors();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAuthors method, of class Book.
     */
    @org.junit.Test
    public void testSetAuthors() {
        System.out.println("setAuthors");
        List<Author> aut = new ArrayList<>();
        authors.add(new Author(new Long(0), "Jack", new Date()));
        book.setAuthors(aut);
        assertEquals(aut, book.getAuthors());
    }

    /**
     * Test of getPublisher method, of class Book.
     */
    @org.junit.Test
    public void testGetPublisher() {
        System.out.println("getPublisher");
        String expResult = "Reading Inc";
        String result = book.getPublisher();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPublisher method, of class Book.
     */
    @org.junit.Test
    public void testSetPublisher() {
        System.out.println("setPublisher");
        String publisher = "Letters";
        book.setPublisher(publisher);
        assertEquals(publisher, book.getPublisher());
    }

    /**
     * Test of getReleaseDate method, of class Book.
     */
    @org.junit.Test
    public void testGetReleaseDate() {
        System.out.println("getReleaseDate");
        Date expResult = release;
        Date result = book.getReleaseDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setReleaseDate method, of class Book.
     */
    @org.junit.Test
    public void testSetReleaseDate() {
        System.out.println("setReleaseDate");
        Date releaseDate = new Date(Date.UTC(2000, 10, 23, 10, 20, 3));
        book.setReleaseDate(releaseDate);
         assertEquals(releaseDate, book.getReleaseDate());
    }

    /**
     * Test of getPrice method, of class Book.
     */
    @org.junit.Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Double expResult = 10.0;
        Double result = book.getPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPrice method, of class Book.
     */
    @org.junit.Test
    public void testSetPrice() {
        System.out.println("setPrice");
        Double price = 9.0;
        book.setPrice(price);
        assertEquals(price, book.getPrice());
    }

    /**
     * Test of getReviews method, of class Book.
     */
    @org.junit.Test
    public void testGetReviews() {
        System.out.println("getReviews");
        List<Review> expResult = reviews;
        List<Review> result = book.getReviews();
        assertEquals(expResult, result);
    }

    /**
     * Test of setReviews method, of class Book.
     */
    @org.junit.Test
    public void testSetReviews() {
        System.out.println("setReviews");
        List<Review> rev = new ArrayList<>();
        reviews.add(new Review(new Long(0), "Max", 3, "Horrible"));
        book.setReviews(rev);
        assertEquals(rev, book.getReviews());
    }
    
}

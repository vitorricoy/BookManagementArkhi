/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitorricoy.bookmanagement.model.service;

import com.vitorricoy.bookmanagement.model.domain.Author;
import com.vitorricoy.bookmanagement.model.domain.Book;
import com.vitorricoy.bookmanagement.model.domain.Review;
import com.vitorricoy.bookmanagement.model.exception.BusinessException;
import com.vitorricoy.bookmanagement.model.persistence.BookPersistence;
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
public class BookServiceTest {
    
    private BookService service;
    private List<Author> authors;
    private List<Review> reviews;
    private Date release;
    private BookPersistence persistence;
    
    
    public BookServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        persistence = BookPersistence.getInstance();
        service = new BookService(persistence);
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
        persistence.cleanData();
    }  
    
     /**
     * Test of insertBook method, of class BookService.
     */
    @org.junit.Test
    public void testInsertBook1() throws Exception {
        System.out.println("insertBook1");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        Book result = service.insertBook(book);
        assertEquals(book, result);
        Book result2 = service.getBookById("1940593758372");
        assertEquals(book, result2);
    }
    
    /**
     * Test of insertBook method, of class BookService.
     */
    @org.junit.Test
    public void testInsertBoo2() throws Exception {
        System.out.println("insertBook2");
        Book book = new Book("1940593758372", "Adventures", null, "Reading Inc", release, 10.00, reviews);
        try{
            Book result = service.insertBook(book);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null authors");
    }
    
    /**
     * Test of insertBook method, of class BookService.
     */
    @org.junit.Test
    public void testInsertBook3() throws Exception {
        System.out.println("insertBook3");
        Book book = new Book("1940593758372", "Adventures", new ArrayList<>(), "Reading Inc", release, 10.00, reviews);
        try{
            Book result = service.insertBook(book);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty authors");
    }
    
    /**
     * Test of insertBook method, of class BookService.
     */
    @org.junit.Test
    public void testInsertBook4() throws Exception {
        System.out.println("insertBook4");
        Book book = new Book(null, "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        try{
            Book result = service.insertBook(book);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null isbn");
    }
    
    /**
     * Test of insertBook method, of class BookService.
     */
    @org.junit.Test
    public void testInsertBook5() throws Exception {
        System.out.println("insertBook5");
        Book book = new Book("", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        try{
            Book result = service.insertBook(book);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty isbn");
    }
    
    /**
     * Test of insertBook method, of class BookService.
     */
    @org.junit.Test
    public void testInsertBook6() throws Exception {
        System.out.println("insertBook6");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, null, reviews);
        try{
            Book result = service.insertBook(book);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null price");
    }
    
    /**
     * Test of insertBook method, of class BookService.
     */
    @org.junit.Test
    public void testInsertBook7() throws Exception {
        System.out.println("insertBook7");
        Book book = new Book("1940593758372", "Adventures", authors, null, release, 10.00, reviews);
        try{
            Book result = service.insertBook(book);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null publisher");
    }
    
    /**
     * Test of insertBook method, of class BookService.
     */
    @org.junit.Test
    public void testInsertBook8() throws Exception {
        System.out.println("insertBook8");
        Book book = new Book("1940593758372", "Adventures", authors, "", release, 10.00, reviews);
        try{
            Book result = service.insertBook(book);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty publisher");
    }
    
    /**
     * Test of insertBook method, of class BookService.
     */
    @org.junit.Test
    public void testInsertBook9() throws Exception {
        System.out.println("insertBook9");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", null, 10.00, reviews);
        try{
            Book result = service.insertBook(book);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null release date");
    }
    
    /**
     * Test of insertBook method, of class BookService.
     */
    @org.junit.Test
    public void testInsertBook10() throws Exception {
        System.out.println("insertBook10");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, null);
        try{
            Book result = service.insertBook(book);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null reviews");
    }
    
    /**
     * Test of insertBook method, of class BookService.
     */
    @org.junit.Test
    public void testInsertBook11() throws Exception {
        System.out.println("insertBook11");
        Book book = new Book("1940593758372", null, authors, "Reading Inc", release, 10.00, reviews);
        try{
            Book result = service.insertBook(book);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null title");
    }
    
    /**
     * Test of insertBook method, of class BookService.
     */
    @org.junit.Test
    public void testInsertBook12() throws Exception {
        System.out.println("insertBook12");
        Book book = new Book("1940593758372", "", authors, "Reading Inc", release, 10.00, reviews);
        try{
            Book result = service.insertBook(book);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty title");
    }

    /**
     * Test of getBookById method, of class BookService.
     */
    @org.junit.Test
    public void testGetBookById1() throws Exception {
        System.out.println("getBookById1");
        String isbn = "1940593758372";
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        book = service.insertBook(book);
        Book result = service.getBookById(isbn);
        assertEquals(book, result);
    }
    
    /**
     * Test of getBookById method, of class BookService.
     */
    @org.junit.Test
    public void testGetBookById2() throws Exception {
        System.out.println("getBookById2");
        String isbn = null;
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        book = service.insertBook(book);
        try{
            Book result = service.getBookById(isbn);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null isbn");
    }
    
    /**
     * Test of getBookById method, of class BookService.
     */
    @org.junit.Test
    public void testGetBookById3() throws Exception {
        System.out.println("getBookById3");
        String isbn = "";
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        book = service.insertBook(book);
        try{
            Book result = service.getBookById(isbn);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty isbn");
    }
    
    /**
     * Test of removeBook method, of class BookService.
     */
    @org.junit.Test
    public void testRemoveBook1() throws Exception {
        System.out.println("removeBook1");
        String isbn = "1940593758372";
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        book = service.insertBook(book);
        Book result = service.removeBook(isbn);
        assertEquals(book, result);
    }
    
    /**
     * Test of removeBook method, of class BookService.
     */
    @org.junit.Test
    public void testRemoveBook2() throws Exception {
        System.out.println("removeBook2");
        String isbn = null;
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        service.insertBook(book);
        try{
            Book result = service.removeBook(isbn);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty isbn");
    }
    
    /**
     * Test of removeBook method, of class BookService.
     */
    @org.junit.Test
    public void testRemoveBook3() throws Exception {
        System.out.println("removeBook3");
        String isbn = "";
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        service.insertBook(book);
        try{
            Book result = service.removeBook(isbn);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty isbn");
    }

    /**
     * Test of updateBook method, of class BookService.
     */
    @org.junit.Test
    public void testUpdateBook1() throws Exception {
        System.out.println("updateBook1");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        book = service.insertBook(book);
        Book newBook = new Book("1940593758372", "Around", authors, "Reading Inc", release, 10.00, reviews);
        String isbn = "1940593758372";
        Book result = service.updateBook(newBook, isbn);
        assertEquals(newBook, result);
        Book result2 = service.getBookById(isbn);
        assertEquals(result2, newBook);
    }
    
    /**
     * Test of updateBook method, of class BookService.
     */
    @org.junit.Test
    public void testUpdateBook2() throws Exception {
        System.out.println("updateBook2");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        service.insertBook(book);
        Book newBook = new Book("1940593758372", "Around", authors, "Reading Inc", release, 10.00, reviews);
        String isbn = "";
        try{
            Book result = service.updateBook(newBook, isbn);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty isbn");
    }
    
    /**
     * Test of updateBook method, of class BookService.
     */
    @org.junit.Test
    public void testUpdateBook3() throws Exception {
        System.out.println("updateBook3");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        service.insertBook(book);
        Book newBook = new Book("1940593758372", "Around", authors, "Reading Inc", release, 10.00, reviews);
        String isbn = null;
        try{
            Book result = service.updateBook(newBook, isbn);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null isbn");
    }
    
    /**
     * Test of updateBook method, of class BookService.
     */
    @org.junit.Test
    public void testUpdateBook4() throws Exception {
        System.out.println("updateBook4");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        service.insertBook(book);
        Book newBook = new Book("1940593758372", "Around", null, "Reading Inc", release, 10.00, reviews);
        String isbn = "1940593758372";
        try{
            Book result = service.updateBook(newBook, isbn);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null authors");
    }
    
    /**
     * Test of updateBook method, of class BookService.
     */
    @org.junit.Test
    public void testUpdateBook5() throws Exception {
        System.out.println("updateBook5");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        service.insertBook(book);
        Book newBook = new Book("1940593758372", "Around", new ArrayList<>(), "Reading Inc", release, 10.00, reviews);
        String isbn = "1940593758372";
        try{
            Book result = service.updateBook(newBook, isbn);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty authors");
    }
    
    /**
     * Test of updateBook method, of class BookService.
     */
    @org.junit.Test
    public void testUpdateBook6() throws Exception {
        System.out.println("updateBook6");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        service.insertBook(book);
        Book newBook = new Book(null, "Around", authors, "Reading Inc", release, 10.00, reviews);
        String isbn = "1940593758372";
        try{
            Book result = service.updateBook(newBook, isbn);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null isbn");
    }
    
    /**
     * Test of updateBook method, of class BookService.
     */
    @org.junit.Test
    public void testUpdateBook7() throws Exception {
        System.out.println("updateBook7");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        service.insertBook(book);
        Book newBook = new Book("", "Around", authors, "Reading Inc", release, 10.00, reviews);
        String isbn = "1940593758372";
        try{
            Book result = service.updateBook(newBook, isbn);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty isbn");
    }
    
    /**
     * Test of updateBook method, of class BookService.
     */
    @org.junit.Test
    public void testUpdateBook8() throws Exception {
        System.out.println("updateBook8");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        service.insertBook(book);
        Book newBook = new Book("1940593758372", "Around", authors, "Reading Inc", release, null, reviews);
        String isbn = "1940593758372";
        try{
            Book result = service.updateBook(newBook, isbn);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null price");
    }
    
    /**
     * Test of updateBook method, of class BookService.
     */
    @org.junit.Test
    public void testUpdateBook9() throws Exception {
        System.out.println("updateBook9");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        service.insertBook(book);
        Book newBook = new Book("1940593758372", "Around", authors, null, release, 10.00, reviews);
        String isbn = "1940593758372";
        try{
            Book result = service.updateBook(newBook, isbn);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null publisher");
    }
    
    /**
     * Test of updateBook method, of class BookService.
     */
    @org.junit.Test
    public void testUpdateBook10() throws Exception {
        System.out.println("updateBook10");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        service.insertBook(book);
        Book newBook = new Book("1940593758372", "Around", authors, "", release, 10.00, reviews);
        String isbn = "1940593758372";
        try{
            Book result = service.updateBook(newBook, isbn);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty publisher");
    }
    
    /**
     * Test of updateBook method, of class BookService.
     */
    @org.junit.Test
    public void testUpdateBook11() throws Exception {
        System.out.println("updateBook11");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        service.insertBook(book);
        Book newBook = new Book("1940593758372", "Around", authors, "Reading Inc", null, 10.00, reviews);
        String isbn = "1940593758372";
        try{
            Book result = service.updateBook(newBook, isbn);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null release date");
    }
    
    /**
     * Test of updateBook method, of class BookService.
     */
    @org.junit.Test
    public void testUpdateBook12() throws Exception {
        System.out.println("updateBook12");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        service.insertBook(book);
        Book newBook = new Book("1940593758372", "Around", authors, "Reading Inc", release, 10.00, null);
        String isbn = "1940593758372";
        try{
            Book result = service.updateBook(newBook, isbn);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null reviews");
    }
    
    /**
     * Test of updateBook method, of class BookService.
     */
    @org.junit.Test
    public void testUpdateBook13() throws Exception {
        System.out.println("updateBook13");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        service.insertBook(book);
        Book newBook = new Book("1940593758372", "Around", authors, "Reading Inc", release, 10.00, new ArrayList<>());
        String isbn = "1940593758372";
        try{
            Book result = service.updateBook(newBook, isbn);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty reviews");
    }
    
    /**
     * Test of updateBook method, of class BookService.
     */
    @org.junit.Test
    public void testUpdateBook14() throws Exception {
        System.out.println("updateBook14");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        service.insertBook(book);
        Book newBook = new Book("1940593758372", null, authors, "Reading Inc", release, 10.00, reviews);
        String isbn = "1940593758372";
        try{
            Book result = service.updateBook(newBook, isbn);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null title");
    }
    
    /**
     * Test of updateBook method, of class BookService.
     */
    @org.junit.Test
    public void testUpdateBook15() throws Exception {
        System.out.println("updateBook15");
        Book book = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        service.insertBook(book);
        Book newBook = new Book("1940593758372", "", authors, "Reading Inc", release, 10.00, reviews);
        String isbn = "1940593758372";
        try{
            Book result = service.updateBook(newBook, isbn);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty title");
    }

    /**
     * Test of getBookByAuthor method, of class BookService.
     */
    @org.junit.Test
    public void testGetBookByAuthor1() throws Exception {
        System.out.println("getBookByAuthor1");
        Author author = new Author(new Long(0), "John", new Date());
        Book book1 = new Book("1940593744332", "Trips", authors, "Reading Inc", release, 30.00, reviews);
        Book book2 = new Book("1940593758372", "Adventures", authors, "Reading Inc", release, 10.00, reviews);
        service.insertBook(book1);
        service.insertBook(book2);
        List<Book> result = service.getBookByAuthor(author);
        assertEquals(2, result.size());
    }
    
    /**
     * Test of getBookByAuthor method, of class BookService.
     */
    @org.junit.Test
    public void testGetBookByAuthor2() throws Exception {
        System.out.println("getBookByAuthor2");
        Author author = new Author(new Long(0), null, new Date());
        try{
            List<Book> result = service.getBookByAuthor(author);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null author name");
        
    }
    
    /**
     * Test of getBookByAuthor method, of class BookService.
     */
    @org.junit.Test
    public void testGetBookByAuthor3() throws Exception {
        System.out.println("getBookByAuthor3");
        Author author = new Author(new Long(0), "", new Date());
        try{
            List<Book> result = service.getBookByAuthor(author);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty author name");
    }
    
    /**
     * Test of getBookByAuthor method, of class BookService.
     */
    @org.junit.Test
    public void testGetBookByAuthor4() throws Exception {
        System.out.println("getBookByAuthor4");
        Author author = new Author(new Long(0), "John", null);
        try{
            List<Book> result = service.getBookByAuthor(author);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null birth date");
    }
    
    /**
     * Test of listAll method, of class BookService.
     */
    @org.junit.Test
    public void listAll() throws Exception {
        System.out.println("listAll");
        Book book = new Book("1940593744332", "Trips", authors, "Reading Inc", release, 30.00, reviews);
        int size1 = service.listAll().size();
        assertEquals(size1, 0);
        service.insertBook(book);
        int size2 = service.listAll().size();
        assertEquals(size2, 1);
    }
    
}

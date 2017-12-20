/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitorricoy.bookmanagement.model.service;

import com.vitorricoy.bookmanagement.model.domain.Author;
import com.vitorricoy.bookmanagement.model.exception.BusinessException;
import com.vitorricoy.bookmanagement.model.persistence.AuthorPersistence;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author vitor
 */
public class AuthorServiceTest {
    
    private AuthorService service;
    private AuthorPersistence persistence;
    
    public AuthorServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        persistence = AuthorPersistence.getInstance();
        service = new AuthorService(persistence);
    }
    
    @After
    public void tearDown() {
        persistence.cleanData();
    }

    /**
     * Test of insertAuthor method, of class AuthorService.
     */
    @org.junit.Test
    public void testInsertAuthor1() throws Exception {
        System.out.println("insertAuthor1");
        Author author = new Author(new Long(0), "John", new Date());
        Author result = service.insertAuthor(author);
        assertEquals(author, result);
        Author result2 = service.getAuthorById(new Long(0));
        assertEquals(author, result2);
    }
    
    /**
     * Test of insertAuthor method, of class AuthorService.
     */
    @org.junit.Test
    public void testInsertAuthor2() throws Exception {
        System.out.println("insertAuthor2");
        Author author = new Author(new Long(0), null, new Date());
        try{
            Author result = service.insertAuthor(author);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null name");
    }
    
    /**
     * Test of insertAuthor method, of class AuthorService.
     */
    @org.junit.Test
    public void testInsertAuthor3() throws Exception {
        System.out.println("insertAuthor3");
        Author author = new Author(new Long(0), "", new Date());
        try{
            Author result = service.insertAuthor(author);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty name");
    }
    
    /**
     * Test of insertAuthor method, of class AuthorService.
     */
    @org.junit.Test
    public void testInsertAuthor4() throws Exception {
        System.out.println("insertAuthor4");
        Author author = new Author(new Long(0), "John", null);
        try{
            Author result = service.insertAuthor(author);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null birth date");
    }

    /**
     * Test of getAuthorById method, of class AuthorService.
     */
    @org.junit.Test
    public void testGetAuthorById1() throws Exception {
        System.out.println("getAuthorById1");
        Author author = new Author(new Long(0), "John", new Date());
        author = service.insertAuthor(author);
        Author result = service.getAuthorById(new Long(0));
        assertEquals(author, result);
    }
    
    /**
     * Test of getAuthorById method, of class AuthorService.
     */
    @org.junit.Test
    public void testGetAuthorById2() throws Exception {
        System.out.println("getAuthorById2");
        Author author = new Author(new Long(0), "John", new Date());
        author = service.insertAuthor(author);
        try{
            Author result = service.getAuthorById(null);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null id");
    }

    /**
     * Test of removeAuthor method, of class AuthorService.
     */
    @org.junit.Test
    public void testRemoveAuthor() throws Exception {
        System.out.println("removeAuthor");
        Author author = new Author(new Long(0), "John", new Date());
        author = service.insertAuthor(author);
        Author result = service.removeAuthor(new Long(0));
        assertEquals(author, result);
    }
    
    /**
     * Test of removeAuthor method, of class AuthorService.
     */
    @org.junit.Test
    public void testRemoveAuthor2() throws Exception {
        System.out.println("removeAuthor2");
        Author author = new Author(new Long(0), "John", new Date());
        author = service.insertAuthor(author);
        try{
            Author result = service.removeAuthor(null);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null id");
    }

    /**
     * Test of updateAuthor method, of class AuthorService.
     */
    @org.junit.Test
    public void testUpdateAuthor1() throws Exception {
        System.out.println("updateAuthor1");
        Author author = new Author(new Long(0), "John", new Date());
        author = service.insertAuthor(author);
        Author newAuthor = new Author(new Long(0), "Mary", new Date());
        Long id = new Long(0);
        Author result = service.updateAuthor(newAuthor, id);
        assertEquals(newAuthor, result);
        Author result2 = service.getAuthorById(id);
        assertEquals(result2, newAuthor);
    }
    
    /**
     * Test of updateAuthor method, of class AuthorService.
     */
    @org.junit.Test
    public void testUpdateAuthor2() throws Exception {
        System.out.println("updateAuthor2");
        Author author = new Author(new Long(0), "John", new Date());
        author = service.insertAuthor(author);
        Author newAuthor = new Author(new Long(0), "Mary", new Date());
        try{
            Author result = service.updateAuthor(newAuthor, null);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null id");
    }
    
    /**
     * Test of updateAuthor method, of class AuthorService.
     */
    @org.junit.Test
    public void testUpdateAuthor3() throws Exception {
        System.out.println("updateAuthor3");
        Author author = new Author(new Long(0), "John", new Date());
        author = service.insertAuthor(author);
        Author newAuthor = new Author(new Long(0), null, new Date());
        try{
            Author result = service.updateAuthor(newAuthor, new Long(0));
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null name");
    }
    
    /**
     * Test of updateAuthor method, of class AuthorService.
     */
    @org.junit.Test
    public void testUpdateAuthor4() throws Exception {
        System.out.println("updateAuthor4");
        Author author = new Author(new Long(0), "John", new Date());
        author = service.insertAuthor(author);
        Author newAuthor = new Author(new Long(0), "", new Date());
        try{
            Author result = service.updateAuthor(newAuthor, null);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty name");
    }
    
    /**
     * Test of updateAuthor method, of class AuthorService.
     */
    @org.junit.Test
    public void testUpdateAuthor5() throws Exception {
        System.out.println("updateAuthor5");
        Author author = new Author(new Long(0), "John", new Date());
        author = service.insertAuthor(author);
        Author newAuthor = new Author(new Long(0), "Mary", null);
        try{
            Author result = service.updateAuthor(newAuthor, null);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null birth date");
    }
    
    /**
     * Test of listAll method, of class AuthorService.
     */
    @org.junit.Test
    public void listAll() throws Exception {
        System.out.println("listAll");
        Author author = new Author(new Long(0), "John", new Date());
        int size1 = service.listAll().size();
        assertEquals(size1, 0);
        service.insertAuthor(author);
        int size2 = service.listAll().size();
        assertEquals(size2, 1);
    }
    
}

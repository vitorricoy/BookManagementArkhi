/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitorricoy.bookmanagement.model.persistence;

import com.vitorricoy.bookmanagement.model.domain.Author;
import com.vitorricoy.bookmanagement.model.exception.PersistenceException;
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
public class AuthorPersistenceTest {
    
    private AuthorPersistence persistence;
    
    public AuthorPersistenceTest() {
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertAuthor method, of class AuthorPersistence.
     */
    @org.junit.Test
    public void testInsertAuthor1() throws Exception {
        System.out.println("insertAuthor1");
        Author author = new Author(new Long(0), "John", new Date());
        Author result = persistence.insertAuthor(author);
        assertEquals(author, result);
        try{
            Author result2 = persistence.getAuthorById(author.getId());
        }catch(PersistenceException ex){
            fail("Didn't insert the author");
        }
    }
    
    /**
     * Test of insertAuthor method, of class AuthorPersistence.
     */
    @org.junit.Test
    public void testInsertAuthor2() throws Exception {
        System.out.println("insertAuthor2");
        Author author = new Author(null, "John", new Date());
        Author result = persistence.insertAuthor(author);
        assertEquals(author, result);
        Author author2 = new Author(new Long(0), "Jake", new Date());
        try{
            persistence.insertAuthor(author2);
        }catch(PersistenceException ex){
            return;
        }
        fail("Accepted to authors with same key");
    }

    /**
     * Test of getAuthorById method, of class AuthorPersistence.
     */
    @org.junit.Test
    public void testGetAuthorById1() throws Exception {
        System.out.println("getAuthorById1");
        Long id = new Long(0);
        Author author = new Author(new Long(0), "John", new Date());
        author = persistence.insertAuthor(author);
        Author result = persistence.getAuthorById(id);
        assertEquals(author, result);
    }
    
    /**
     * Test of getAuthorById method, of class AuthorPersistence.
     */
    @org.junit.Test
    public void testGetAuthorById2() throws Exception {
        System.out.println("getAuthorById2");
        Long id = new Long(2);
        Author author = new Author(new Long(0), "John", new Date());
        author = persistence.insertAuthor(author);
        try{
            Author result = persistence.getAuthorById(id);
        }catch(PersistenceException ex){
            return;
        }
        fail("Searched for an invalid key");
    }

    /**
     * Test of removeAuthor method, of class AuthorPersistence.
     */
    @org.junit.Test
    public void testRemoveAuthor1() throws Exception {
        System.out.println("removeAuthor1");
        Long id = new Long(0);
        Author author = new Author(new Long(0), "John", new Date());
        author = persistence.insertAuthor(author);
        Author result = persistence.removeAuthor(id);
        assertEquals(author, result);
        try{
            Author result2 = persistence.getAuthorById(id);
        }catch(PersistenceException ex){
            return;
        }
        fail("Didn't remove the author");
    }
    
     /**
     * Test of removeAuthor method, of class AuthorPersistence.
     */
    @org.junit.Test
    public void testRemoveAuthor2() throws Exception {
        System.out.println("removeAuthor2");
        Long id = new Long(2);
        Author author = new Author(new Long(0), "John", new Date());
        author = persistence.insertAuthor(author);
        try{
            Author result = persistence.removeAuthor(id);
        }catch(PersistenceException ex){
            return;
        }
        fail("Removed an invalid key");
    }

    /**
     * Test of updateAuthor method, of class AuthorPersistence.
     */
    @org.junit.Test
    public void testUpdateAuthor1() throws Exception {
        System.out.println("updateAuthor1");
        Author author = new Author(new Long(0), "John", new Date());
        author = persistence.insertAuthor(author);
        Author newAuthor = new Author(new Long(0), "Mary", new Date());
        Long id = new Long(0);
        Author result = persistence.updateAuthor(newAuthor, id);
        assertEquals(newAuthor, result);
        Author result2 = persistence.getAuthorById(id);
        assertEquals(result2, newAuthor);
    }
    
    /**
     * Test of updateAuthor method, of class AuthorPersistence.
     */
    @org.junit.Test
    public void testUpdateAuthor2() throws Exception {
        System.out.println("updateAuthor2");
        Author author = new Author(new Long(0), "John", new Date());
        author = persistence.insertAuthor(author);
        Author newAuthor = new Author(new Long(1), "Mary", new Date());
        Long id = new Long(1);
        try{
            Author result = persistence.updateAuthor(newAuthor, id);
        }catch(PersistenceException ex){
            return;
        }
        fail("Updated an invalid key");
    }
}

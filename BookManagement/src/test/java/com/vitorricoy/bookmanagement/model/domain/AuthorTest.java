/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitorricoy.bookmanagement.model.domain;

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
public class AuthorTest {
    
    public AuthorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAuthorName method, of class Author.
     */
    @org.junit.Test
    public void testGetAuthorName() {
        System.out.println("getAuthorName");
        Author author = new Author(new Long(0), "John", new Date());
        String expectedResult = "John";
        String result = author.getAuthorName();
        assertEquals(expectedResult, result);
    }

    /**
     * Test of setAuthorName method, of class Author.
     */
    @org.junit.Test
    public void testSetAuthorName() {
        System.out.println("setAuthorName");
        String authorName = "Mary";
        Author author = new Author(new Long(0), "John", new Date(), new Date());
        author.setAuthorName(authorName);
        assertEquals(author.getAuthorName(), authorName);
    }

    /**
     * Test of getBirthDate method, of class Author.
     */
    @org.junit.Test
    public void testGetBirthDate() {
        System.out.println("getBirthDate");
        Date birth = new Date();
        Author author = new Author(new Long(0), "John", birth);
        Date result = author.getBirthDate();
        assertEquals(birth, result);
    }

    /**
     * Test of setBirthDate method, of class Author.
     */
    @org.junit.Test
    public void testSetBirthDate() {
        System.out.println("setBirthDate");
        Date birthDate = new Date(Date.UTC(2000, 10, 23, 10, 20, 3));
        Author author = new Author(new Long(0), "John", new Date(), new Date());
        author.setBirthDate(birthDate);
        assertEquals(author.getBirthDate(), birthDate);
    }

    /**
     * Test of getDeathDate method, of class Author.
     */
    @org.junit.Test
    public void testGetDeathDate() {
        System.out.println("getDeathDate");
        Date death = new Date();
        Author author = new Author(new Long(0), "John", new Date(), death);
        Date result = author.getDeathDate();
        assertEquals(death, result);
    }

    /**
     * Test of setDeathDate method, of class Author.
     */
    @org.junit.Test
    public void testSetDeathDate() {
        System.out.println("setDeathDate");
        Date birthDate = new Date(Date.UTC(2000, 10, 23, 10, 20, 3));
        Author author = new Author(new Long(0), "John", new Date(), new Date());
        author.setDeathDate(birthDate);
        assertEquals(author.getDeathDate(), birthDate);
    }

    /**
     * Test of getId method, of class Author.
     */
    @org.junit.Test
    public void testGetId() {
        System.out.println("getId");
        Author author = new Author(new Long(0), "John", new Date(), new Date());
        Long expResult = new Long(0);
        Long result = author.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Author.
     */
    @org.junit.Test
    public void testSetId() {
        System.out.println("setId");
        Long id = new Long(1);
        Author author = new Author(new Long(0), "John", new Date(), new Date());
        author.setId(id);
        assertEquals(id, author.getId());
    }
    
}

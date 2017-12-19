/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitorricoy.bookmanagement.model.domain;

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
public class ReviewTest {
    
    Review review;
    
    public ReviewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        review = new Review(new Long(0), "Max", 9, "It's excellent");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAuthorName method, of class Review.
     */
    @org.junit.Test
    public void testGetAuthorName() {
        System.out.println("getAuthorName");
        String expResult = "Max";
        String result = review.getAuthorName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAuthorName method, of class Review.
     */
    @org.junit.Test
    public void testSetAuthorName() {
        System.out.println("setAuthorName");
        String authorName = "Mary";
        review.setAuthorName(authorName);
        assertEquals(authorName, review.getAuthorName());
    }

    /**
     * Test of getRating method, of class Review.
     */
    @org.junit.Test
    public void testGetRating() {
        System.out.println("getRating");
        Integer expResult = 9;
        Integer result = review.getRating();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRating method, of class Review.
     */
    @org.junit.Test
    public void testSetRating() {
        System.out.println("setRating");
        Integer rating = 10;
        review.setRating(rating);
        assertEquals(rating, review.getRating());
    }

    /**
     * Test of getReviewTxt method, of class Review.
     */
    @org.junit.Test
    public void testGetReviewTxt() {
        System.out.println("getReviewTxt");
        String expResult = "It's excellent";
        String result = review.getReviewTxt();
        assertEquals(expResult, result);
    }

    /**
     * Test of setReviewTxt method, of class Review.
     */
    @org.junit.Test
    public void testSetReviewTxt() {
        System.out.println("setReviewTxt");
        String reviewTxt = "It's very good";
        review.setReviewTxt(reviewTxt);
        assertEquals(reviewTxt, review.getReviewTxt());
    }

    /**
     * Test of getId method, of class Review.
     */
    @org.junit.Test
    public void testGetId() {
        System.out.println("getId");
        Long expResult = new Long(0);
        Long result = review.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Review.
     */
    @org.junit.Test
    public void testSetId() {
        System.out.println("setId");
        Long id = new Long(1);
        review.setId(id);
        assertEquals(id, review.getId());
    }
    
}

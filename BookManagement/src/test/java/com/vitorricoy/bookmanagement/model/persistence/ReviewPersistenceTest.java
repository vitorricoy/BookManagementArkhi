/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitorricoy.bookmanagement.model.persistence;

import com.vitorricoy.bookmanagement.model.domain.Review;
import com.vitorricoy.bookmanagement.model.exception.PersistenceException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author vitor
 */
public class ReviewPersistenceTest {
    
    private ReviewPersistence persistence;
    
    public ReviewPersistenceTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        persistence = ReviewPersistence.getInstance();
    }
    
    @After
    public void tearDown() {
        persistence.cleanData();
    }

    /**
     * Test of insertReview method, of class ReviewPersistence.
     */
    @org.junit.Test
    public void testInsertReview1() throws Exception {
        System.out.println("insertReview1");
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        Review result = persistence.insertReview(review);
        assertEquals(review, result);
        try{
            Review review2 = persistence.getReviewById(review.getId());
        }catch(PersistenceException ex){
            fail("Didn't insert the review");
        }
    }
    
    /**
     * Test of insertReview method, of class ReviewPersistence.
     */
    @org.junit.Test
    public void testInsertReview2() throws Exception {
        System.out.println("insertReview2");
        Review review = new Review(null, "Max", 9, "It's excellent");
        Review result = persistence.insertReview(review);
        assertEquals(review, result);
        Review review2 = new Review(new Long(0), "Jane", 4, "Bad");
        try{
            Review result2 = persistence.insertReview(review2);
        }catch(PersistenceException ex){
            return;
        }
        fail("Accepted duplicated keys");
    }

    /**
     * Test of getReviewById method, of class ReviewPersistence.
     */
    @org.junit.Test
    public void testGetReviewById1() throws Exception {
        System.out.println("getReviewById1");
        Long id = new Long(0);
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        review = persistence.insertReview(review);
        Review result = persistence.getReviewById(id);
        assertEquals(review, result);
    }
    
    /**
     * Test of getReviewById method, of class ReviewPersistence.
     */
    @org.junit.Test
    public void testGetReviewById2() throws Exception {
        System.out.println("getReviewById2");
        Long id = new Long(1);
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        review = persistence.insertReview(review);
        try{
            Review result = persistence.getReviewById(id);
        }catch(PersistenceException ex){
            return;
        }
        fail("Searched an invalid id");
    }

    /**
     * Test of removeReview method, of class ReviewPersistence.
     */
    @org.junit.Test
    public void testRemoveReview1() throws Exception {
        System.out.println("removeReview1");
        Long id = new Long(0);
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        review = persistence.insertReview(review);
        Review result = persistence.removeReview(id);
        assertEquals(review, result);
        try{
            review = persistence.getReviewById(id);
        }catch(PersistenceException ex){
            return;
        }
        fail("Didn't remove review");
    }
    
    /**
     * Test of removeReview method, of class ReviewPersistence.
     */
    @org.junit.Test
    public void testRemoveReview2() throws Exception {
        System.out.println("removeReview2");
        Long id = new Long(1);
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        review = persistence.insertReview(review);
        try{
            Review result = persistence.removeReview(id);
        }catch(PersistenceException ex){
            return;
        }
        fail("Removed inexisting id");
    }

    /**
     * Test of updateReview method, of class ReviewPersistence.
     */
    @org.junit.Test
    public void testUpdateReview1() throws Exception {
        System.out.println("updateReview1");
        Long id = new Long(0);
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        review = persistence.insertReview(review);
        Review review2 = new Review(new Long(0), "Jack", 2, "Disappointing");
        Review result = persistence.updateReview(review2, id);
        assertEquals(review2, result);
        Review result2 = persistence.getReviewById(id);
        assertEquals(review2, result2);
    }
    
    /**
     * Test of updateReview method, of class ReviewPersistence.
     */
    @org.junit.Test
    public void testUpdateReview2() throws Exception {
        System.out.println("updateReview2");
        Long id = new Long(1);
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        review = persistence.insertReview(review);
        Review review2 = new Review(new Long(0), "Jack", 2, "Disappointing");
        try{
            Review result = persistence.updateReview(review2, id);
        }catch(PersistenceException ex){
            return;
        }
        fail("Updated an invalid key");
    }
    
    /**
     * Test of listAll method, of class ReviewPersistence.
     */
    @org.junit.Test
    public void listAll() throws Exception {
        System.out.println("listAll");
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        int size1 = persistence.listAll().size();
        assertEquals(size1, 0);
        persistence.insertReview(review);
        int size2 = persistence.listAll().size();
        assertEquals(size2, 1);
    }
    
}

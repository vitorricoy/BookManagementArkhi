/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitorricoy.bookmanagement.model.service;

import com.vitorricoy.bookmanagement.model.domain.Review;
import com.vitorricoy.bookmanagement.model.exception.BusinessException;
import com.vitorricoy.bookmanagement.model.persistence.ReviewPersistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author vitor
 */
public class ReviewServiceTest {
    
    private ReviewService service;
    private ReviewPersistence persistence;
    
    public ReviewServiceTest() {
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
        service = new ReviewService(persistence);
    }
    
    @After
    public void tearDown() {
        persistence.cleanData();
    }

    /**
     * Test of insertReview method, of class ReviewService.
     */
    @org.junit.Test
    public void testInsertReview1() throws Exception {
        System.out.println("insertReview1");
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        Review result = service.insertReview(review);
        assertEquals(review, result);
    }
    
    /**
     * Test of insertReview method, of class ReviewService.
     */
    @org.junit.Test
    public void testInsertReview2() throws Exception {
        System.out.println("insertReview2");
        Review review = new Review(new Long(0), null, 9, "It's excellent");
        try{
            Review result = service.insertReview(review);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null author name");
    }
    
    /**
     * Test of insertReview method, of class ReviewService.
     */
    @org.junit.Test
    public void testInsertReview3() throws Exception {
        System.out.println("insertReview3");
        Review review = new Review(new Long(0), "", 9, "It's excellent");
        try{
            Review result = service.insertReview(review);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty author name");
    }
    
    /**
     * Test of insertReview method, of class ReviewService.
     */
    @org.junit.Test
    public void testInsertReview4() throws Exception {
        System.out.println("insertReview4");
        Review review = new Review(new Long(0), "Max", null, "It's excellent");
        try{
            Review result = service.insertReview(review);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null rating");
    }
    
    /**
     * Test of insertReview method, of class ReviewService.
     */
    @org.junit.Test
    public void testInsertReview5() throws Exception {
        System.out.println("insertReview5");
        Review review = new Review(new Long(0), "Max", 9, null);
        try{
            Review result = service.insertReview(review);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null review text");
    }
    
    /**
     * Test of insertReview method, of class ReviewService.
     */
    @org.junit.Test
    public void testInsertReview6() throws Exception {
        System.out.println("insertReview6");
        Review review = new Review(new Long(0), "Max", 9, "");
        try{
            Review result = service.insertReview(review);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty review text");
    }

    /**
     * Test of getReviewById method, of class ReviewService.
     */
    @org.junit.Test
    public void testGetReviewById1() throws Exception {
        System.out.println("getReviewById1");
        Long id = new Long(0);
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        review = service.insertReview(review);
        Review result = service.getReviewById(id);
        assertEquals(review, result);
    }
    
    /**
     * Test of getReviewById method, of class ReviewService.
     */
    @org.junit.Test
    public void testGetReviewById2() throws Exception {
        System.out.println("getReviewById2");
        Long id = null;
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        service.insertReview(review);
        try{
            Review result = service.getReviewById(id);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null id");
    }

    /**
     * Test of removeReview method, of class ReviewService.
     */
    @org.junit.Test
    public void testRemoveReview1() throws Exception {
        System.out.println("removeReview1");
        Long id = new Long(0);
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        review = service.insertReview(review);
        Review result = service.removeReview(id);
        assertEquals(review, result);
    }
    
    /**
     * Test of getReviewById method, of class ReviewService.
     */
    @org.junit.Test
    public void testRemoveReview2() throws Exception {
        System.out.println("removeReview2");
        Long id = null;
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        service.insertReview(review);
        try{
            Review result = service.removeReview(id);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null id");
    }
    
    /**
     * Test of updateReview method, of class ReviewService.
     */
    @org.junit.Test
    public void testUpdateReview1() throws Exception {
        System.out.println("updateReview1");
        Long id = new Long(0);
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        service.insertReview(review);
        Review review2 = new Review(new Long(0), "Jack", 2, "Disappointing");
        Review result = service.updateReview(review2, id);
        assertEquals(review2, result);
    }
    
    /**
     * Test of updateReview method, of class ReviewService.
     */
    @org.junit.Test
    public void testUpdateReview2() throws Exception {
        System.out.println("updateReview2");
        Long id = null;
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        service.insertReview(review);
        Review review2 = new Review(new Long(0), "Jack", 2, "Disappointing");
        try{
            Review result = service.updateReview(review2, id);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null id");
    }
    
    /**
     * Test of updateReview method, of class ReviewService.
     */
    @org.junit.Test
    public void testUpdateReview3() throws Exception {
        System.out.println("updateReview3");
        Long id = new Long(0);
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        service.insertReview(review);
        Review review2 = new Review(new Long(0), null, 2, "Disappointing");
        try{
            Review result = service.updateReview(review2, id);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null author name");
    }
    
    /**
     * Test of updateReview method, of class ReviewService.
     */
    @org.junit.Test
    public void testUpdateReview4() throws Exception {
        System.out.println("updateReview4");
        Long id = new Long(0);
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        service.insertReview(review);
        Review review2 = new Review(new Long(0), "", 2, "Disappointing");
        try{
            Review result = service.updateReview(review2, id);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty author name");
    }
    
    /**
     * Test of updateReview method, of class ReviewService.
     */
    @org.junit.Test
    public void testUpdateReview5() throws Exception {
        System.out.println("updateReview5");
        Long id = new Long(0);
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        service.insertReview(review);
        Review review2 = new Review(new Long(0), "Jack", null, "Disappointing");
        try{
            Review result = service.updateReview(review2, id);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null rating");
    }
    
    /**
     * Test of updateReview method, of class ReviewService.
     */
    @org.junit.Test
    public void testUpdateReview6() throws Exception {
        System.out.println("updateReview6");
        Long id = new Long(0);
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        service.insertReview(review);
        Review review2 = new Review(new Long(0), "Jack", 2, null);
        try{
            Review result = service.updateReview(review2, id);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted null review text");
    }
    
    /**
     * Test of updateReview method, of class ReviewService.
     */
    @org.junit.Test
    public void testUpdateReview7() throws Exception {
        System.out.println("updateReview7");
        Long id = new Long(0);
        Review review = new Review(new Long(0), "Max", 9, "It's excellent");
        service.insertReview(review);
        Review review2 = new Review(new Long(0), "Jack", 2, "");
        try{
            Review result = service.updateReview(review2, id);
        }catch(BusinessException ex){
            return;
        }
        fail("Accepted empty review text");
    }
    
}

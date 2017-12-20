package com.vitorricoy.bookmanagement.model.persistence;

import com.vitorricoy.bookmanagement.model.domain.Review;
import com.vitorricoy.bookmanagement.model.exception.PersistenceException;
import com.vitorricoy.bookmanagement.model.persistenceInterface.ReviewPersistenceInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Review Persistence implemented using RAM
 * @author vitor
 */
public class ReviewPersistence implements ReviewPersistenceInterface{
    
    private HashMap<Long, Review> table;
    private static ReviewPersistence instance = null;
    
    private ReviewPersistence(){
        table = new HashMap<>();
    }
    
    public static ReviewPersistence getInstance(){
        if(instance==null){
            instance = new ReviewPersistence();
        }
        return instance;
    }
    
    @Override
    public Review insertReview(Review review) throws PersistenceException {
        if(review.getId()==null){
            review.setId(new Long(table.size()));
        }
        if(table.containsKey(review.getId())){
            throw new PersistenceException("Duplicated Key");
        }
        table.put(review.getId(), review);
        return review;
    }

    @Override
    public Review getReviewById(Long id) throws PersistenceException {
        Review r = table.get(id);
        if(r==null){
            throw new PersistenceException("No review found with key " + id);
        }
        return r;
    }

    @Override
    public Review removeReview(Long id) throws PersistenceException {
        Review r = table.remove(id);
        if(r==null){
            throw new PersistenceException("No review found with key " + id + " to be removed");
        }
        return r;
    }

    @Override
    public Review updateReview(Review newReview, Long id) throws PersistenceException {
        Review r = table.replace(id, newReview);
        if(r==null){
            throw new PersistenceException("No review found with key " + id + " to be updated");
        }
        return newReview;
    }
    
    public void cleanData(){
        table = new HashMap<>();
    }

    @Override
    public List<Review> listAll() throws PersistenceException {
        return new ArrayList(table.values());
    }
}

package com.vitorricoy.bookmanagement.model.persistenceInterface;

import com.vitorricoy.bookmanagement.model.domain.Review;
import com.vitorricoy.bookmanagement.model.exception.PersistenceException;
import java.util.List;

/**
 * Interface to define the ReviewPersistence's methods
 * @author vitor
 */
public interface ReviewPersistenceInterface {
    /**
     * Insert a review
     * @param review The review to be inserted
     * @return The inserted review
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Review insertReview(Review review) throws PersistenceException;

    /**
     * Get a review by it's id
     * @param id The desired review's id
     * @return The corresponding review
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Review getReviewById(Long id) throws PersistenceException;

    /**
     * Remove a review
     * @param id The desired review's id
     * @return The corresponding removed review
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Review removeReview(Long id) throws PersistenceException;

    /**
     * Update a review
     * @param newReview The new review
     * @param id The old review id
     * @return The updated review
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Review updateReview(Review newReview, Long id) throws PersistenceException;
    
    /**
     * List all reviews
     * @return A list with all reviews
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public List<Review> listAll() throws PersistenceException;
    
}

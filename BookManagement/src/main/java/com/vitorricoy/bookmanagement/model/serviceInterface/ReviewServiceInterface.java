/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitorricoy.bookmanagement.model.serviceInterface;

import com.vitorricoy.bookmanagement.model.domain.Review;
import com.vitorricoy.bookmanagement.model.exception.BusinessException;
import com.vitorricoy.bookmanagement.model.exception.PersistenceException;

/**
 * Interface to define the ReviewService's methods
 * @review vitor
 */
public interface ReviewServiceInterface {
    /**
     * Insert a review in the persistence
     * @param review The review to be inserted
     * @return The inserted review
     * @throws com.vitorricoy.bookmanagement.model.exception.BusinessException
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Review insertReview(Review review) throws BusinessException, PersistenceException;

    /**
     * Get a review in the persistence by it's id
     * @param id The desired review's id
     * @return The corresponding review
     * @throws com.vitorricoy.bookmanagement.model.exception.BusinessException
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Review getReviewById(Long id) throws BusinessException, PersistenceException;

    /**
     * Remove a review from the persistence
     * @param id The desired review's id
     * @return The corresponding removed review
     * @throws com.vitorricoy.bookmanagement.model.exception.BusinessException
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Review removeReview(Long id) throws BusinessException, PersistenceException;

    /**
     * Update a review in the persistence
     * @param newReview The new review
     * @param id The old review id
     * @return The updated review
     * @throws com.vitorricoy.bookmanagement.model.exception.BusinessException
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Review updateReview(Review newReview, Long id) throws BusinessException, PersistenceException;
}

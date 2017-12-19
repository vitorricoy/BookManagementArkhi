/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitorricoy.bookmanagement.model.service;

import com.vitorricoy.bookmanagement.model.domain.Review;
import com.vitorricoy.bookmanagement.model.exception.BusinessException;
import com.vitorricoy.bookmanagement.model.exception.PersistenceException;
import com.vitorricoy.bookmanagement.model.persistenceInterface.ReviewPersistenceInterface;
import com.vitorricoy.bookmanagement.model.serviceInterface.ReviewServiceInterface;

/**
 * Review Service
 * @author vitor
 */
public class ReviewService implements ReviewServiceInterface{
    
    ReviewPersistenceInterface persistence;
    
    public ReviewService(ReviewPersistenceInterface persistence){
        this.persistence=persistence;
    }

    @Override
    public Review insertReview(Review review) throws BusinessException, PersistenceException {
        if(review.getAuthorName()==null || review.getAuthorName().equals("")){
            throw new BusinessException("Review author name can't be null or empty");
        }
        if(review.getRating()==null){
            throw new BusinessException("Review rating can't be null");
        }
        if(review.getReviewTxt()==null || review.getReviewTxt().equals("")){
            throw new BusinessException("Review text can't be null or empty");
        }
        return persistence.insertReview(review);
    }

    @Override
    public Review getReviewById(Long id) throws BusinessException, PersistenceException {
        if(id==null){
            throw new BusinessException("Id can't be null");
        }
        return persistence.getReviewById(id);
    }

    @Override
    public Review removeReview(Long id) throws BusinessException, PersistenceException {
        if(id==null){
            throw new BusinessException("Id can't be null");
        }
        return persistence.removeReview(id);
    }

    @Override
    public Review updateReview(Review newReview, Long id) throws BusinessException, PersistenceException {
        if(id==null){
            throw new BusinessException("Id can't be null");
        }
        if(newReview.getAuthorName()==null || newReview.getAuthorName().equals("")){
            throw new BusinessException("Review author name can't be null or empty");
        }
        if(newReview.getRating()==null){
            throw new BusinessException("Review rating can't be null");
        }
        if(newReview.getReviewTxt()==null || newReview.getReviewTxt().equals("")){
            throw new BusinessException("Review text can't be null or empty");
        }
        newReview.setId(id);
        return persistence.updateReview(newReview, id);
    }
    
}

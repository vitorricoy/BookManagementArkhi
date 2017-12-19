package com.vitorricoy.bookmanagement.util;

import com.vitorricoy.bookmanagement.model.domain.Review;

/**
 * Object to receive review update data
 * @author vitor
 */
public class ReviewUpdateObject {
    private Review review;
    private Long id;

    public ReviewUpdateObject() {
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}

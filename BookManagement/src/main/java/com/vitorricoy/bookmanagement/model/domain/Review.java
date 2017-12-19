package com.vitorricoy.bookmanagement.model.domain;

/**
 * A reader's review about a Book
 * @author vitor
 */
public class Review {
    private Long id;
    private String authorName;
    private Integer rating;
    private String reviewTxt;

    /**
     * Constructor with arguments
     * @param authorName The review's author name
     * @param rating The review's author rating of the book
     * @param reviewTxt The text explaining about the review
     * @param id The review's id
     */
    public Review(Long id, String authorName, Integer rating, String reviewTxt) {
        this.authorName = authorName;
        this.rating = rating;
        this.reviewTxt = reviewTxt; 
        this.id=id;
    }

    /**
     * Get the review's author name
     * @return The review's author name
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * Set the review's author name
     * @param authorName The review's author name
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * Get the review rating of the book
     * @return The review rating of the book
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * Set the review rating of the book
     * @param rating The review rating of the book
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     * Get the text explaining the review
     * @return The text explaining the review
     */
    public String getReviewTxt() {
        return reviewTxt;
    }

    /**
     * Set the text explaining the review
     * @param reviewTxt The text explaining the review
     */
    public void setReviewTxt(String reviewTxt) {
        this.reviewTxt = reviewTxt;
    }

    /**
     * Get the review's id
     * @return The review's id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the review's id
     * @param id The review's id
     */
    public void setId(Long id) {
        this.id = id;
    }
}

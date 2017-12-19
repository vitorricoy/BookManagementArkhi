package com.vitorricoy.bookmanagement.model.domain;

import java.util.Date;
import java.util.List;

/**
 * Representation of a book
 * @author vitor
 */
public class Book {
    private String isbn;
    private String Title;
    private List<Author> authors;
    private String publisher;
    private Date releaseDate;
    private Double price;
    private List<Review> reviews;

    /**
     *  Constructor with arguments
     * @param isbn Book's ISBN code
     * @param Title Book's Title
     * @param authors Book's authors
     * @param publisher Book's publisher
     * @param releaseDate Book's release date
     * @param price Book's price
     * @param reviews Book's reviews
     */
    public Book(String isbn, String Title, List<Author> authors, String publisher, Date releaseDate, Double price, List<Review> reviews) {
        this.isbn = isbn;
        this.Title = Title;
        this.authors = authors;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.price = price;
        this.reviews = reviews;
    }

    /**
     * Get ISBN code
     * @return ISBN code
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Set ISBN code
     * @param isbn ISBN code
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Get book's title
     * @return Book's title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * Set book's title
     * @param Title New book's title
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * Get the book's authors
     * @return A list containing the book's authors
     */
    public List<Author> getAuthors() {
        return authors;
    }

    /**
     * Set the book's authors
     * @param authors A list containing the book's new authors
     */
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    /**
     * Get the book's publisher
     * @return The book's publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Set the book's publisher
     * @param publisher The new book's publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Get the book's release date
     * @return The book's release date
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * Set the book's release date
     * @param releaseDate The book's new release date
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Get the book's price
     * @return The book's price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Set the book's price
     * @param price The new price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Get the book's reviews
     * @return A list containing the reviews
     */
    public List<Review> getReviews() {
        return reviews;
    }

    /**
     * Set the book's reviews
     * @param reviews A list containing the new reviews
     */
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}

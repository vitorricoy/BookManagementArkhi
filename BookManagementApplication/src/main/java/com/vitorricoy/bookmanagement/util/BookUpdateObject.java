package com.vitorricoy.bookmanagement.util;

import com.vitorricoy.bookmanagement.model.domain.Book;

/**
 * Object to receive book update data
 * @author vitor
 */
public class BookUpdateObject {
    private Book book;
    private String isbn;

    public BookUpdateObject() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    
}

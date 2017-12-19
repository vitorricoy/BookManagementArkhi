package com.vitorricoy.bookmanagement.util;

import com.vitorricoy.bookmanagement.model.domain.Author;

/**
 * Object to receive author update data
 * @author vitor
 */
public class AuthorUpdateObject {
    private Author author;
    private Long id;

    public AuthorUpdateObject() {
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}

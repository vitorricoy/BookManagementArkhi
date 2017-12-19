package com.vitorricoy.bookmanagement.model.persistenceInterface;

import com.vitorricoy.bookmanagement.model.domain.Author;
import com.vitorricoy.bookmanagement.model.exception.PersistenceException;

/**
 * Interface to define the AuthorPersistence's methods
 * @author vitor
 */
public interface AuthorPersistenceInterface{
     /**
     * Insert an author
     * @param author The author to be inserted
     * @return The inserted author
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Author insertAuthor(Author author) throws PersistenceException;

    /**
     * Get an author by it's id
     * @param id The desired author's id
     * @return The corresponding author
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Author getAuthorById(Long id) throws PersistenceException;

    /**
     * Remove an author
     * @param id The desired author's id
     * @return The corresponding removed author
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Author removeAuthor(Long id) throws PersistenceException;

    /**
     * Update an author
     * @param newAuthor The new author
     * @param id The old author id
     * @return The updated author
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Author updateAuthor(Author newAuthor, Long id) throws PersistenceException;
}

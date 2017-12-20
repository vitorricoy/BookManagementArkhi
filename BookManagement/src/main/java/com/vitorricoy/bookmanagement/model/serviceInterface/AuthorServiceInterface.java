package com.vitorricoy.bookmanagement.model.serviceInterface;

import com.vitorricoy.bookmanagement.model.domain.Author;
import com.vitorricoy.bookmanagement.model.exception.BusinessException;
import com.vitorricoy.bookmanagement.model.exception.PersistenceException;
import java.util.List;

/**
 * Interface to define the AuthorService's methods
 * @author vitor
 */
public interface AuthorServiceInterface {

    /**
     * Insert an author in the persistence
     * @param author The author to be inserted
     * @return The inserted author
     * @throws com.vitorricoy.bookmanagement.model.exception.BusinessException
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Author insertAuthor(Author author) throws BusinessException, PersistenceException;

    /**
     * Get an author in the persistence by it's id
     * @param id The desired author's id
     * @return The corresponding author
     * @throws com.vitorricoy.bookmanagement.model.exception.BusinessException
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Author getAuthorById(Long id) throws BusinessException, PersistenceException;

    /**
     * Remove an author from the persistence
     * @param id The desired author's id
     * @return The corresponding removed author
     * @throws com.vitorricoy.bookmanagement.model.exception.BusinessException
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Author removeAuthor(Long id) throws BusinessException, PersistenceException;

    /**
     * Update an author in the persistence
     * @param newAuthor The new author
     * @param id The old author id
     * @return The updated author
     * @throws com.vitorricoy.bookmanagement.model.exception.BusinessException
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public Author updateAuthor(Author newAuthor, Long id) throws BusinessException, PersistenceException;
    
    /**
     * List all author
     * @return A list with all authors
     * @throws com.vitorricoy.bookmanagement.model.exception.BusinessException
     * @throws com.vitorricoy.bookmanagement.model.exception.PersistenceException
     */
    public List<Author> listAll() throws BusinessException, PersistenceException;
}

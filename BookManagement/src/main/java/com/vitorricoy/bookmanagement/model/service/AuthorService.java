/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitorricoy.bookmanagement.model.service;

import com.vitorricoy.bookmanagement.model.domain.Author;
import com.vitorricoy.bookmanagement.model.exception.BusinessException;
import com.vitorricoy.bookmanagement.model.exception.PersistenceException;
import com.vitorricoy.bookmanagement.model.persistenceInterface.AuthorPersistenceInterface;
import com.vitorricoy.bookmanagement.model.serviceInterface.AuthorServiceInterface;
import java.util.List;

/**
 * Author Service
 * @author vitor
 */
public class AuthorService implements AuthorServiceInterface{
    
    AuthorPersistenceInterface persistence;
    
    public AuthorService(AuthorPersistenceInterface persistence){
        this.persistence=persistence;
    }
    
    @Override
    public Author insertAuthor(Author author) throws BusinessException, PersistenceException {
        if(author.getAuthorName()==null || author.getAuthorName().equals("")){
            throw new BusinessException("Author's name can't be null or empty");
        }
        if(author.getBirthDate()==null){
            throw new BusinessException("The author's birth date can't be null");
        }
        return persistence.insertAuthor(author);
    }

    @Override
    public Author getAuthorById(Long id) throws BusinessException, PersistenceException {
        if(id==null){
            throw new BusinessException("The id can't be null");
        }
        return persistence.getAuthorById(id);
    }

    @Override
    public Author removeAuthor(Long id) throws BusinessException, PersistenceException {
        if(id==null){
            throw new BusinessException("The id can't be null");
        }
        return persistence.removeAuthor(id);
    }

    @Override
    public Author updateAuthor(Author newAuthor, Long id) throws BusinessException, PersistenceException {
        if(newAuthor.getAuthorName()==null || newAuthor.getAuthorName().equals("")){
            throw new BusinessException("Author's name can't be null or empty");
        }
        if(newAuthor.getBirthDate()==null){
            throw new BusinessException("The author's birth date can't be null");
        }
        if(id==null){
            throw new BusinessException("The id can't be null");
        }
        newAuthor.setId(id);
        return persistence.updateAuthor(newAuthor, id);
    }

    @Override
    public List<Author> listAll() throws BusinessException, PersistenceException {
        return persistence.listAll();
    }
    
}

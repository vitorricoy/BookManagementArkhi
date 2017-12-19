package com.vitorricoy.bookmanagement.model.persistence;

import com.vitorricoy.bookmanagement.model.domain.Author;
import com.vitorricoy.bookmanagement.model.exception.PersistenceException;
import com.vitorricoy.bookmanagement.model.persistenceInterface.AuthorPersistenceInterface;
import java.util.HashMap;

/**
 * Author Persistence implemented using RAM
 * @author vitor
 */
public class AuthorPersistence implements AuthorPersistenceInterface{

    private HashMap<Long, Author> table;
    
    public AuthorPersistence(){
        table = new HashMap<>();
    }
     
    @Override
    public Author insertAuthor(Author author) throws PersistenceException {
        if(author.getId()==null){
            author.setId(new Long(table.size()));
        }
        if(table.containsKey(author.getId())){
            throw new PersistenceException("Duplicated Key");
        }
        table.put(author.getId(), author);
        return author;
    }

    @Override
    public Author getAuthorById(Long id) throws PersistenceException {
        Author author = table.get(id);
        if(author==null){
            throw new PersistenceException("Author with key " + id + " not found");
        }
        return author;
    }

    @Override
    public Author removeAuthor(Long id) throws PersistenceException {
        Author author = table.remove(id);
        if(author==null){
            throw new PersistenceException("Author with key " + id + " not found to be removed");
        }
        return author;
    }

    @Override
    public Author updateAuthor(Author newAuthor, Long id) throws PersistenceException {
        Author old = table.replace(id, newAuthor);
        if(old==null){
            throw new PersistenceException("Author with key " + id + " not found to be updated");
        }
        return newAuthor;
    }
    
}

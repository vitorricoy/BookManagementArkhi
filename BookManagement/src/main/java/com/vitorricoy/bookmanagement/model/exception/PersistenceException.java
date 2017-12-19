package com.vitorricoy.bookmanagement.model.exception;

/**
 * Class to define PeristenceException
 * @author vitor
 */
public class PersistenceException extends Exception{
    public PersistenceException(String msg){
        super(msg);
    }
}

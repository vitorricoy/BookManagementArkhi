/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitorricoy.bookmanagement.util;

/**
 *
 * @author vitor
 */
public class Result {
    private String status;
    private Object content;
    
    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatusOK() {
        status = "OK";
    }
    
    public void setStatusBADREQUEST() {
        status = "BAD REQUEST";
    }
    
    public void setStatus (String status) {
        this.status = status;
    }
}

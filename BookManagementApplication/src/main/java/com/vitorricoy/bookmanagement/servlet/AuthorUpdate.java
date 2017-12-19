package com.vitorricoy.bookmanagement.servlet;

import com.google.gson.Gson;
import com.vitorricoy.bookmanagement.model.domain.Author;
import com.vitorricoy.bookmanagement.model.exception.BusinessException;
import com.vitorricoy.bookmanagement.model.exception.PersistenceException;
import com.vitorricoy.bookmanagement.model.persistence.AuthorPersistence;
import com.vitorricoy.bookmanagement.model.service.AuthorService;
import com.vitorricoy.bookmanagement.util.AuthorUpdateObject;
import com.vitorricoy.bookmanagement.util.Result;
import com.vitorricoy.bookmanagement.util.ServletUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Update author servlet
 * @author vitor
 */
@WebServlet(name = "AuthorUpdate", urlPatterns = {"/AuthorUpdate"})
public class AuthorUpdate extends HttpServlet{
    private AuthorService authorService;
    private Gson gson;
    private Result result;
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request Servlet request
     * @param response Servlet response
     * @throws ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        authorService = new AuthorService(AuthorPersistence.getInstance());
        gson = new Gson();
        result = new Result();
        try{
            String json = ServletUtil.getJson(request);
            AuthorUpdateObject update = gson.fromJson(json, AuthorUpdateObject.class);
            Author author = authorService.updateAuthor(update.getAuthor(), update.getId());
            result.setStatusOK();
            result.setContent(author);
        }catch(BusinessException | PersistenceException ex){
            result.setStatusBADREQUEST();
            result.setContent(ex.getMessage());
        }
        finally{
            PrintWriter writer = response.getWriter();
            writer.println(gson.toJson(result));
        }
    }
}

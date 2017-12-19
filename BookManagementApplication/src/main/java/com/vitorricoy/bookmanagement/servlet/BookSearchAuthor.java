package com.vitorricoy.bookmanagement.servlet;

import com.google.gson.Gson;
import com.vitorricoy.bookmanagement.model.domain.Author;
import com.vitorricoy.bookmanagement.model.domain.Book;
import com.vitorricoy.bookmanagement.model.exception.BusinessException;
import com.vitorricoy.bookmanagement.model.exception.PersistenceException;
import com.vitorricoy.bookmanagement.model.persistence.BookPersistence;
import com.vitorricoy.bookmanagement.model.service.BookService;
import com.vitorricoy.bookmanagement.util.Result;
import com.vitorricoy.bookmanagement.util.ServletUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Book search by author servlet
 * @author vitor
 */
@WebServlet(name = "BookSearchAuthor", urlPatterns = {"/BookSearchAuthor"})
public class BookSearchAuthor extends HttpServlet{
    private BookService bookService;
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
        bookService = new BookService(BookPersistence.getInstance());
        gson = new Gson();
        result = new Result();
        try{
            String json = ServletUtil.getJson(request);
            Author author = gson.fromJson(json, Author.class);
            List<Book> books = bookService.getBookByAuthor(author);
            result.setStatusOK();
            result.setContent(books);
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

package com.vitorricoy.bookmanagement.servlet;

import com.google.gson.Gson;
import com.vitorricoy.bookmanagement.model.domain.Review;
import com.vitorricoy.bookmanagement.model.exception.BusinessException;
import com.vitorricoy.bookmanagement.model.exception.PersistenceException;
import com.vitorricoy.bookmanagement.model.persistence.ReviewPersistence;
import com.vitorricoy.bookmanagement.model.service.ReviewService;
import com.vitorricoy.bookmanagement.util.Result;
import com.vitorricoy.bookmanagement.util.ReviewUpdateObject;
import com.vitorricoy.bookmanagement.util.ServletUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Update review servlet
 * @author vitor
 */
@WebServlet(name = "ReviewUpdate", urlPatterns = {"/ReviewUpdate"})
public class ReviewUpdate extends HttpServlet{
    private ReviewService reviewService;
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
        reviewService = new ReviewService(ReviewPersistence.getInstance());
        gson = new Gson();
        result = new Result();
        try{
            String json = ServletUtil.getJson(request);
            ReviewUpdateObject update = gson.fromJson(json, ReviewUpdateObject.class);
            Review review = reviewService.updateReview(update.getReview(), update.getId());
            result.setStatusOK();
            result.setContent(review);
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

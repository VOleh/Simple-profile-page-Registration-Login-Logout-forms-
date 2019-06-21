
package com.mvc.controller;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Chating"})
public class ChatingServlet extends HttpServlet { 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Integer reciverId = Integer.parseInt(request.getParameter("userId"));
        
        request.setAttribute("reciverId", reciverId);
        
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Chat.jsp");
        dispatcher.forward(request, response);
        
    }
}


package com.mvc.controller;

import com.mvc.bean.User;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutServlets extends HttpServlet {
    
        private  Map<Integer,User> usersOnline;
        private ServletContext servletContext;
        private HttpSession httpSession;        
        private User user;
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //servletContext = request.getServletContext();
        
        httpSession = request.getSession(false);
        
        user = (User) httpSession.getAttribute("user");       
        
        usersOnline = (Map<Integer,User>) httpSession.getAttribute("usersOnline");
        
        usersOnline.remove(user.getUserId());       

        httpSession.invalidate();
        
        response.sendRedirect(request.getContextPath()+"/LoginJsp.jsp");    

    }
}

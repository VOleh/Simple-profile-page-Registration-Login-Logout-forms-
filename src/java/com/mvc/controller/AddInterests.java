
package com.mvc.controller;

import com.mvc.bean.User;
import com.mvc.dao.AddGetUpdateDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddInterests extends HttpServlet {  
        
    private User user = new User();
    private final AddGetUpdateDao dao = new AddGetUpdateDao();
    private HttpSession httpSession;
    private String parameter;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        httpSession = request.getSession(false);
        
        parameter = (String) request.getParameter("interests");    
        
        user = (User) httpSession.getAttribute("user");
        
        user.setUserFilms(request.getParameter("userFilms"));
        user.setUserBooks(request.getParameter("userBooks"));
        user.setUserMusic(request.getParameter("userMusic"));
        user.setUserSport(request.getParameter("userSport"));
        
        String sql =  "INSERT INTO Interests (id, userFilms, userBooks,"
                   + "userMusic, userSport)  VALUES (?,?,?,?,?)";
        
        String check = dao.addInfo(user ,parameter, sql);
        
        if( check.equals("Success")){
           request.getRequestDispatcher("/Hobbies.jsp").forward(request, response);
        }       
    }
}

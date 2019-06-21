package com.mvc.controller;

import com.mvc.bean.User;
import com.mvc.dao.AddGetUpdateDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet (urlPatterns = {"/editHobbies"})
public class UpdateHobbies extends HttpServlet {
    
    private  User user;
    private final AddGetUpdateDao dao = new AddGetUpdateDao();
    private HttpSession httpSession;
    private String parameter;
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {      
        
        httpSession = request.getSession(false);
        
        parameter =  request.getParameter("interests");        
        user = (User) httpSession.getAttribute("user");
        
        user.setUserFilms(request.getParameter("userFilms"));
        user.setUserBooks(request.getParameter("userBooks"));
        user.setUserMusic(request.getParameter("userMusic"));
        user.setUserSport(request.getParameter("userSport"));        
        
        String sql = "UPDATE [Interests] SET [userFilms]=?,"
                + "[userBooks]=?, [userMusic]=?, [userSport]=? WHERE id=?";        
              
        String rs_update_interests = dao.updateInfo(user, parameter, sql);

        if( rs_update_interests.equals("Updated")){
            request.setAttribute("description", "Your interests successfully updated !");
            request.setAttribute("remark", "Return back !");
            getServletContext().getRequestDispatcher("/UpdateInterests.jsp").forward(request, response);
        }
    }
}
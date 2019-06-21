
package com.mvc.controller;

import com.mvc.bean.User;
import com.mvc.dao.AddGetUpdateDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddHobbies extends HttpServlet {   
    private User user = new User();
    private HttpSession httpSession;
    private AddGetUpdateDao dao;
    private String parameter;

    public AddHobbies() {
        this.dao = new AddGetUpdateDao();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        httpSession = request.getSession(false);
        
        parameter = (String) request.getParameter("hobbies");
        
        user = (User) httpSession.getAttribute("user");
        
        user.setUserHobbies(request.getParameter("userHobbies"));

        String sql =  "UPDATE  Interests SET userHobbies=? WHERE id=?";

        String check = dao.addInfo(user, parameter, sql);

        if( check.equals("Success")){            
           
            request.setAttribute("remark", "Your account has been successfully created!");
            request.setAttribute("description", "Open your account");
            request.getRequestDispatcher("/Hobbies.jsp").forward(request, response);
        }   
    }
}

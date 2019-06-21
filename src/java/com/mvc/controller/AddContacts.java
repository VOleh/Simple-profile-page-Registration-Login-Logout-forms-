
package com.mvc.controller;

import com.mvc.bean.User;
import com.mvc.dao.AddGetUpdateDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddContacts extends HttpServlet {
    
    private User user = new User();;
    private HttpSession httpSession;
    private final AddGetUpdateDao dao = new AddGetUpdateDao();
    
    private  String parameter;
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        parameter = (String) request.getParameter("contacts");
        
        httpSession = request.getSession(false);
              
        user = (User) httpSession.getAttribute("user");
        
        user.setCountry(request.getParameter("country"));
        user.setUserHomeTown(request.getParameter("homeTown"));
        user.setUserMobilePhone(request.getParameter("mobilePhone"));
        
        String sql =  "UPDATE Contacts SET country=?, userHomeTown=?, userMobilePhone=? WHERE id=?";
        
        String check = dao.addInfo(user, parameter, sql);
        
        if( check.equals("Success")){
           request.getRequestDispatcher("/Interests.jsp").forward(request, response);
        }   
    }
}

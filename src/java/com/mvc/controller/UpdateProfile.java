
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

@WebServlet (urlPatterns = {"/editProfile"})
public class UpdateProfile extends HttpServlet {
    
    private User user;
    private final AddGetUpdateDao dao = new AddGetUpdateDao();
    private HttpSession httpSession;
    private String parameter;


    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         
    
        httpSession = request.getSession(false);        
        
        parameter = request.getParameter("profileInfo");
        
        user = (User) httpSession.getAttribute("user");
         
        user.setDayBirthday(request.getParameter("dayBirthday"));
        user.setMonthBirthday(request.getParameter("monthBirthday"));
        user.setYearBirthday(Integer.parseInt(request.getParameter("yearBirthday")));
        
        user.setCountry(request.getParameter("country")); 
        user.setUserHomeTown(request.getParameter("homeTown"));
        user.setUserMobilePhone(request.getParameter("mobilePhone"));
        user.setEmail(request.getParameter("email"));          
          
        String sql_registration = "UPDATE [Registration] SET [dayBirthday]=?,"
                + "[monthBirthday]=?,[yearBirthday]=? WHERE id=?";        
        
        String sql_contacts = "UPDATE [Contacts] SET [country]=?,"
                + "[userHomeTown]=?, [userMobilePhone]=? WHERE id=?";              
              
        String result_update = dao.updateInfo(user, parameter, sql_registration, sql_contacts);
        
        if( result_update.equals("Updated")){
            request.setAttribute("description", "Your General information successfully updated !");
            request.setAttribute("remark", "Return back !");            
        
        getServletContext().getRequestDispatcher("/UpdateProfile.jsp").forward(request, response);
    }    
}
}


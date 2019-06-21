
package com.mvc.controller;

import com.mvc.bean.User;
import com.mvc.dao.AddGetUpdateDao;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Registration", urlPatterns = {"/Registration"})
public class RegistrationServlets extends HttpServlet {
   
    private String userName;
    private String userSurname;
    private String dayBirthday;
    private String monthBirthday;
    private Integer yearBirthday;
    private String email;
    private String gender;
    private String password;
    private String confirmPassword;
    
    private String parameter;
    
    private final AddGetUpdateDao dao = new AddGetUpdateDao();    
    private final User user = new User();   
    private HttpSession newHttpSession ;   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
       parameter = (String) request.getParameter("registration");      
       userName = request.getParameter("userName");
       userSurname = request.getParameter("userSurname"); 
       dayBirthday = request.getParameter("dayBirthday");
       monthBirthday = request.getParameter("monthBirthday");   
    try {        
        yearBirthday = Integer.valueOf(request.getParameter("yearBirthday"));        
    } catch (NumberFormatException e) {        
        e.printStackTrace();       
    }     
       email = request.getParameter("email");
       gender = request.getParameter("gender");
       password = request.getParameter("password");
       confirmPassword = request.getParameter("confirmPassword");         

       if(  userName.isEmpty()|| userName ==""  || userSurname.isEmpty() 
               || userSurname == "" || yearBirthday.equals(null) 
               || email.isEmpty() || email == "" || gender.isEmpty() 
               || gender == "" || password.isEmpty() || password == "" 
               || confirmPassword.isEmpty() || confirmPassword == ""){

           request.setAttribute("description", "Please fill out all required fields !");               
           getServletContext().getRequestDispatcher("/RegistrationJsp.jsp").forward(request, response);

       }else if( ! password.equals(confirmPassword)){
           request.setAttribute("description", "Please confirm your password !");               
           getServletContext().getRequestDispatcher("/RegistrationJsp.jsp").forward(request, response);
           
       }else{           
           user.setUserName(userName);
           user.setUserSurname(userSurname);
           user.setDayBirthday(dayBirthday);
           user.setMonthBirthday(monthBirthday);
           user.setYearBirthday(yearBirthday);       
           user.setEmail(email);
           user.setGender(gender);
           user.setPassword(password); 
       
            String sqlRegistration =  "INSERT INTO Registration (userName, userSurname, "
                   + "dayBirthday, monthBirthday,yearBirthday, gender, password)  VALUES (?,?,?,?,?,?,?)";
           
            String sqlContscts =  "INSERT INTO Contacts (email) VALUES (?)";
            
       
            String registration = dao.addInfo(user, parameter, sqlRegistration, sqlContscts);
       
            if( registration.equals("Success")){
                
                String sql = "SELECT Registration.id FROM Registration"
                        + " INNER JOIN CONTACTS ON Registration.id = Contacts.id "
                            + " WHERE Contacts.email=?";
                
                ResultSet rs_registration = dao.getInfo(user,parameter,sql);              

                try {
                   if(rs_registration.next()){
                       
                       newHttpSession = request.getSession(true);
                       
                       user.setUserId(rs_registration.getInt("id"));
                       
                       newHttpSession.setAttribute("user", user);                       
                   }
                   
                String sqlWall = "INSERT INTO wall(user_id) VALUES (?)";
                String sqlChat = "INSERT INTO chat(reciver_id) VALUES (?)";
                
                dao.create(user,sqlWall, sqlChat);
                   
                } catch (SQLException ex) {
                   ex.printStackTrace();
                }               
                request.getRequestDispatcher("/AddPhoto.jsp").forward(request, response);          
           }       
        }       
    }
}


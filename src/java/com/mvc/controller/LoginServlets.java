
package com.mvc.controller;


import com.mvc.bean.User;
import com.mvc.dao.AddGetUpdateDao;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"/Login"})
public class LoginServlets extends HttpServlet  {
   
    private String login ;
    private String password ;
    
    AddGetUpdateDao dao = new AddGetUpdateDao();
        
    private final User user = new User();  
    
    private String parameter;
 

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         login = request.getParameter("userLogin");
         password = request.getParameter("userPassword");
         
        
        if(  login.isEmpty()||login ==""  || password.isEmpty() 
               || password == ""){

           request.setAttribute("description", "Please fill out all required fields !");               
           
           RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/LoginJsp.jsp");                            
           
           dispatcher.forward(request, response);

           }else {
            
               user.setEmail(login);
               user.setPassword(password);
               
               try {
                    String sqlCheck = "SELECT * FROM Registration "
                            + " INNER JOIN Contacts ON Registration.id = Contacts.id "
                            + " WHERE email=? AND password=?";
                    
                    parameter = "authorization";
                    
                    ResultSet rs_login = dao.getInfo(user, parameter, sqlCheck);              

                   if(rs_login.next()){
                       
                       user.setUserId(rs_login.getInt("id"));
                      
                        if ( login.equals(rs_login.getString("email")) &&
                                   password.equals(rs_login.getString("password"))){     
                            
                            
                            response.sendRedirect(request.getContextPath() + String.format("/Home?id=%d", user.getUserId()));
                            
                        }                                    
                    }                           

                } catch (SQLException ex) {            
                        ex.printStackTrace();        
            }
        } 
    }    
}



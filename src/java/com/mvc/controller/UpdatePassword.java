
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

@WebServlet (urlPatterns = {"/editPassword"})
public class UpdatePassword extends HttpServlet {
    
    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;    
    private User user;
    private HttpSession httpSession;
    private String parameter;
    private final AddGetUpdateDao dao = new AddGetUpdateDao();    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        
        oldPassword = request.getParameter("oldPassword");
        newPassword = request.getParameter("newPassword");
        confirmNewPassword = request.getParameter("confirmNewPassword");
        
        parameter = request.getParameter("password");        
        httpSession = request.getSession(false);
        
        user = (User) httpSession.getAttribute("user");
        System.out.println("id "+user.getUserId());
        System.out.println("parameter "+parameter);
        
        if( oldPassword.isEmpty() || oldPassword == "" || newPassword.isEmpty() 
                || newPassword == "" || confirmNewPassword.isEmpty() || confirmNewPassword == ""){       

            request.setAttribute("description", "Please fill out all required fields !");
            getServletContext().getRequestDispatcher("/UpdatePassword.jsp").forward(request, response);

        }else if( ! newPassword.equals( confirmNewPassword)){
            request.setAttribute("description", "Password dosn't match !");
            getServletContext().getRequestDispatcher("/UpdatePassword.jsp").forward(request, response);
        }else{            
            String sql = "UPDATE Registration SET password=? WHERE id=?";                   
            String resultSet_update = dao.updateInfo(user, parameter, sql);
            
            if(resultSet_update.equals("Updated")){                
                request.setAttribute("description", "Your password has been successfully updated!");
                request.setAttribute("remark", "Return back !");
                getServletContext().getRequestDispatcher("/UpdatePassword.jsp").forward(request, response);
            }
        }
    }
}

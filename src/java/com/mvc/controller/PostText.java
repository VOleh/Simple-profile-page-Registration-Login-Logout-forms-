
package com.mvc.controller;

import com.mvc.bean.Post;
import com.mvc.bean.User;
import com.mvc.dao.AddGetUpdateDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/Post"})
public class PostText extends HttpServlet {
    
    private HttpSession httpSession;   
    private String message;       
    private User user  = new User();    
    private final AddGetUpdateDao dao =  new AddGetUpdateDao();    
    private final Post post = new Post(); 
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            post.setMessage( request.getParameter("message"));
            
            httpSession = request.getSession(false);
            
            user =  (User) httpSession.getAttribute("user");            
            
            
            if( message.isEmpty()|| message =="" ){
                response.sendRedirect(request.getContextPath() + String.format("/Home?id=%d", user.getUserId()));
            }else{    
                
                String sql_post = "INSERT INTO [post] (wall_id, user_id, message) VALUES (?,?,?)";

                String check = dao.addPost(user, post, request, sql_post);               

                if( check.equals("Success")){
                       response.sendRedirect(request.getContextPath() + String.format("/Home?id=%d", user.getUserId()));
                }          
            }
    }  
}
    


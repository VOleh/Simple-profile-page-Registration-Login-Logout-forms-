
package com.mvc.controller;

import com.mvc.bean.User;
import com.mvc.dao.AddFileDao;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize =169999999)
public class AddPhoto extends HttpServlet {
    
    private Part photo;    
    private InputStream inputStream;
    private String resultSet_add_userPhoto; 
    private  User user = new User();
    private HttpSession httpSession;
    private final AddFileDao dao = new AddFileDao();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       photo = request.getPart("file");       
       httpSession = request.getSession(false);
        
        if(photo != null){          
            String sql =  "UPDATE [registration] SET [user_photo]=? WHERE id=?";
            
            user = (User) httpSession.getAttribute("user");

            inputStream = photo.getInputStream();

            resultSet_add_userPhoto = dao.addFile(user,inputStream, sql);
        }       
        if(resultSet_add_userPhoto.equals("Success")){                
            getServletContext().getRequestDispatcher("/Contacts.jsp").forward(request, response);
        }    
    }   
}


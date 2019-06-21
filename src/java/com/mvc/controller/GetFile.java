
package com.mvc.controller;

import com.mvc.util.DataBaseConnect;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet( urlPatterns = {"/GetFile"})
public class GetFile extends HttpServlet {
byte[] img;
private ServletOutputStream sos = null;
private int idUser;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
       
        idUser = Integer.parseInt(request.getParameter("id"));
        
        String sql = "SELECT user_photo FROM Registration where id=?";
        
        try{
        Connection connection = DataBaseConnect.createConnection(); 
        
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,idUser);
        ResultSet rs = ps.executeQuery();
        
            if(rs.next()){
                img = rs.getBytes("user_photo");
            }

            sos = response.getOutputStream();
            sos.write(img);
        }catch (Exception e){} 
    }
}
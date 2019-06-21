
package com.mvc.controller;

import com.mvc.bean.Chat;
import com.mvc.bean.User;
import com.mvc.dao.AddGetUpdateDao;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet( urlPatterns = {"/MyChats"})
public class ChatListServlet extends HttpServlet {
    
    private final Chat author = new Chat();
    private HttpSession httpSession;
    private final AddGetUpdateDao dao = new AddGetUpdateDao();
    private final Map<Integer,Chat> listChats = Collections.synchronizedMap(new HashMap<Integer,Chat>());
 
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
            httpSession = request.getSession(true);
            User user = (User) httpSession.getAttribute("user");
      
        String sql = "SELECT DISTINCT  [Registration].[userName], [Registration].[userSurname],"
                + " [Registration].[id] FROM [Registration]"
                + " INNER JOIN [author] ON [Registration].[id] = [author].[sender_id]"
                + " WHERE [author].[reciver_id] =?";       
        
        ResultSet rsChats = dao.getInfo(sql,user);

        try {
            while(rsChats.next()){
                
                author.setAuthorName(rsChats.getString("userName"));
                author.setAuthorSurname(rsChats.getString("userSurname"));
                author.setAuthorId(rsChats.getInt("id"));
                
                listChats.put(author.getAuthorId(),new Chat(author.getAuthorName(), author.getAuthorSurname())); 
            }            
                httpSession.setAttribute("listChats", listChats);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/ChatList.jsp");
        dispatcher.forward(request, response);     
    }
}

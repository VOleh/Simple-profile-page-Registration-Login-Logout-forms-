
package com.mvc.controller;

import com.mvc.bean.Post;
import com.mvc.bean.User;
import com.mvc.dao.AddGetUpdateDao;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/Home"})

public class ProfileServlet extends HttpServlet {
    
    AddGetUpdateDao dao = new AddGetUpdateDao();
        
    private final User user = new User();
    private final Post post = new Post();
    private HttpSession newHttpSession ; 
    
    private String parameter;
   
    
    private  Map <Integer,User> usersOnline = Collections.synchronizedMap(new HashMap<Integer,User>());
    
    private  List<Post> list = Collections.synchronizedList(new ArrayList<Post>());

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
         
            HttpSession oldHttpSession = request.getSession(false);           

            if(oldHttpSession != null){               
                oldHttpSession.invalidate();
                
            }   list.clear();
            
                newHttpSession = request.getSession(true);       
                user.setUserId(Integer.parseInt(request.getParameter("id")));               
         try {                                                  

                //newHttpSession.setAttribute("userLogin", login); // for filter (check login)
                
                String sqlUser= "SELECT * FROM Registration "
                        + " INNER JOIN Contacts ON Registration.id = Contacts.id"
                        + " INNER JOIN Interests ON Registration.id = Interests.id "
                        + " WHERE Registration.id=?";

                parameter = "login";
                
                ResultSet rsUser = dao.getInfo(user, parameter, sqlUser);

                if(rsUser.next()){

                    // general information 
                    user.setUserName(rsUser.getString("userName"));
                    user.setUserSurname(rsUser.getString("userSurname"));
                    user.setCountry(rsUser.getString("country"));                                
                    user.setGender(rsUser.getString("gender"));                                
                    user.setDayBirthday(rsUser.getString("dayBirthday"));
                    user.setMonthBirthday(rsUser.getString("monthBirthday"));
                    user.setYearBirthday(rsUser.getInt("yearBirthday"));
                    // contacts infornation
                    user.setUserHomeTown(rsUser.getString("userHomeTown"));
                    user.setUserMobilePhone(rsUser.getString("userMobilePhone"));
                    user.setEmail(rsUser.getString("email"));
                    // interests information
                    user.setUserFilms(rsUser.getString("userFilms"));
                    user.setUserBooks(rsUser.getString("userBooks"));
                    user.setUserMusic(rsUser.getString("userMusic"));
                    user.setUserSport(rsUser.getString("userSport"));                                
                    user.setUserHobbies(rsUser.getString("userHobbies"));                                      
                }

                newHttpSession.setAttribute("user",user);                
                
                usersOnline.put(user.getUserId(),new User(user.getUserName(),user.getUserSurname()));
                
                newHttpSession.setAttribute("usersOnline", usersOnline);
                
                String sqlPosts = "SELECT [Registration].[userName],"+
                    " [Registration].[userSurname],[post].[message],[post].[create],[post].[user_id] "+
                    " FROM [Registration] INNER JOIN [post] ON [Registration].[id] = [post].[user_id]" +
                    " WHERE [post].[wall_id] = ?";                            

                ResultSet rsPosts = dao.getInfo(user, parameter, sqlPosts);

                while(rsPosts.next()){
                    
                    post.setAuthorId(rsPosts.getInt("user_id"));                    
                    post.setAuthorName(rsPosts.getString("userName"));
                    post.setAuthorSurname(rsPosts.getString("userSurname"));
                    post.setMessage(rsPosts.getString("message"));             

                    list.add(new Post(post.getAuthorId(),post.getAuthorName(),post.getAuthorSurname(),post.getMessage()));
                } 
                
                newHttpSession.setAttribute("list", list);
                
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/MainJsp.jsp");
                dispatcher.forward(request, response);          
            

            } catch (SQLException ex) {            
                    ex.printStackTrace();        
            }
        } 
    }



package com.mvc.controller;

import com.mvc.bean.User;
import com.mvc.dao.AddGetUpdateDao;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="UsersProfilePage",urlPatterns = {"/UsersProfilePage"})
public class UsersProfilePage extends HttpServlet {
    
    private final AddGetUpdateDao dao = new AddGetUpdateDao();
    private final User otherUser = new User();    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
         
         otherUser.setUserId( Integer.parseInt(request.getParameter("id")));
         
         ServletContext servContext = request.getServletContext();
         
         servContext.setAttribute("key", otherUser.getUserId());
         
         
         try{
             String sql= "SELECT * FROM Registration "
                                    + " INNER JOIN Contacts ON Registration.id = Contacts.id"
                                    + " INNER JOIN Interests ON Registration.id = Interests.id "
                                    + " WHERE Registration.id=?";
             
                            ResultSet resultSet = dao.getInfo(otherUser,"login", sql);

                            if((resultSet.next())){
                                                                
                                otherUser.setUserName(resultSet.getString("userName"));
                                otherUser.setUserSurname(resultSet.getString("userSurname"));                               
                                otherUser.setGender(resultSet.getString("gender"));
                                otherUser.setDayBirthday(resultSet.getString("dayBirthday"));
                                otherUser.setMonthBirthday(resultSet.getString("monthBirthday"));
                                otherUser.setYearBirthday(resultSet.getInt("yearBirthday"));
                                
                                
                                otherUser.setCountry(resultSet.getString("country"));
                                otherUser.setUserHomeTown(resultSet.getString("userHomeTown"));
                                otherUser.setUserMobilePhone(resultSet.getString("userMobilePhone"));
                                otherUser.setEmail(resultSet.getString("email"));
                                
                                otherUser.setUserFilms(resultSet.getString("userFilms"));
                                otherUser.setUserBooks(resultSet.getString("userBooks"));
                                otherUser.setUserMusic(resultSet.getString("userMusic")); 
                                otherUser.setUserSport(resultSet.getString("userSport"));
                                otherUser.setUserHobbies(resultSet.getString("userHobbies"));
                                
                                request.setAttribute("user", otherUser);

                                getServletContext().getRequestDispatcher("/ProfilePage.jsp").forward(request, response);                
                            }                        
             
         }catch(SQLException e){
             e.printStackTrace();
         }
    }

}

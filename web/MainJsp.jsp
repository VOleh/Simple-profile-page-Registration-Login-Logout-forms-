
<%@page import="com.mvc.bean.User"%>
<%@page import="com.mvc.bean.Post"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mvc.controller.LoginServlets"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="CSS/mainStyle.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <center> 
       <body>           

            <%
                //if(session.getAttribute("userLogin") == null){
                 //   response.sendRedirect("LoginJsp.jsp");
                //}                            
            %>

            <div class="container">
                <div class="homePanel">
                    <ul>            
                        <li><a class ="active" href="${pageContext.request.contextPath}/Home?id=${user.getUserId()}">Home</a></li>         
                        <li><a href="UpdateProfile.jsp">My profile</a></li>
                        <li><a href="AddPhoto.jsp">My photo</a></li>                       
                        <li><a href="UpdateInterests.jsp">My interests</a></li>
                        <li><a href="UpdateHobbies">My hobbies</a></li>          
                        <li><a href="${pageContext.request.contextPath}/MyChats?id=${user.getUserId()}">My messages</a></li>                         
                    </ul>
                    <ul>            
                        <li><a class ="active" href="#configuration">Configuration</a></li>       
                        <li><a href="UpdatePassword.jsp"> Edit password</a></li>

                        <form action="Logout" method="doGet">             
                           <li>
                               <input type="submit" class="exitButton" value="Exit"/>
                           </li>
                        </form>
                    </ul>
                </div>

                <div class="mainPanel">

                    <div class="divGeneralInform">
                        <%  
                            HttpSession httpSession = request.getSession(false);
                            User user = (User) httpSession.getAttribute("user");
                            String url =  String.format("./GetFile?id=%d",user.getUserId());
                        %>

                        <img src = <%= url %>  width="300" height="250"/>               

                        <p> GENERAL INFORMATION </p>

                        <table>
                            <tr><td>My name:</td><td> ${user.getUserName()} </td></tr>                    
                            <tr><td>My surname:</td><td> ${user.getUserSurname()} </td></tr>
                            <tr><td>Birthday:</td><td> ${user.getDayBirthday()} ${user.getMonthBirthday()} ${user.getYearBirthday()} </td></tr> 
                            <tr><td>I am:</td><td>${user.getGender()}</td></tr> 
                            <tr><td>Country:</td><td>${user.getCountry()}</td></tr>        
                        </table>
                        <hr>

                        <p> CONTACTS </p>
                        <table>
                            <tr><td>Home town:</td><td> ${user.getUserHomeTown()} </td></tr>                    
                            <tr><td>Mobile phone:</td><td> ${user.getUserMobilePhone()} </td></tr>
                            <tr><td>Email:</td><td> ${user.getEmail()} </td></tr>                    
                        </table>
                        <hr>

                        <p> INTERESTS </p>
                        <table>
                            <tr><td>Films:</td><td> ${user.getUserFilms()} </td></tr>                    
                            <tr><td>Books:</td><td> ${user.getUserBooks()} </td></tr>
                            <tr><td>Music:</td><td> ${user.getUserMusic()} </td></tr>
                            <tr><td>Sport:</td><td> ${user.getUserSport()} </td></tr>
                        </table>
                        <hr>

                        <p> HOBBIES </p>

                        <div class="divGeneralInformHobbies">            
                            ${user.getUserHobbies()}            
                        </div>
                        <hr>
                    </div>            

                    <div class="divYourPosts">

                        <p>Your posts:</p>                      
                        
                        <table>                            
                            <c:forEach items="${list}" var="item">
                                <tr>
                                    <td style="text-align: left; width: 150px; font-size : 20px;">${item.getAuthorName()} ${item.getAuthorSurname()} :</td> 
                                    <td style="text-align: left; width: 250px;">  ${item.getMessage()} </td>                             
                                </tr>                        
                            </c:forEach>                                
                        </table>                      
                        
                        <form action ="${pageContext.request.contextPath}/Post"  method="post">

                            <textarea class="textAreaPosts" name="message"></textarea> 

                            <input type="submit" name="send" value="Send"/> 

                            <input type="reset" name="clear" value="Clear"/>
                        </form>            
                    </div>

                    <div class="outPutWindow">
                        <p style="margin-bottom: -6px;"> Users <span style="color:green;">ONLINE:</span> </p>
                         <table>                            
                            <c:forEach items="${usersOnline}" var="item">
                                
                                <c:if test="${item.getKey() != user.getUserId()}"> 
                                    
                                <tr>                                    
                                    <td style="text-align: center;"> <a href=" UsersProfilePage?id=${item.getKey()}" style="font-size: 18px"> ${item.getValue().getUserName()} ${item.getValue().getUserSurname()} </a></td>                         
                                </tr>
                                
                                </c:if>
                            </c:forEach>                                
                        </table>                       
                    </div>   
                </div>
            </div>           
        </body> 
    </center>
</html>

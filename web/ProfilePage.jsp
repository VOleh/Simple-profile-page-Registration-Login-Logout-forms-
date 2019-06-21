
<%@page import="com.mvc.bean.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="CSS/mainStyle.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <center>
        <body>       
        
            <div class="container">
                <div class="mainPanel">     
                    <div class="divGeneralInform">                      
   
                        <img src = "./GetFile?id=${user.getUserId()}"  width="300" height="250"/>     
               
                         <p><a href="${pageContext.request.contextPath}/Chating?userId=${user.getUserId()}" > <span style="color:green;"> write message </span> </a></p> 
                         
                        <p> GENERAL INFORMATION </p>
                        
                        <table>
                            <tr><td>My name:</td><td> ${user.getUserName()} </td></tr>                    
                            <tr><td>My surname:</td><td> ${user.getUserSurname()} </td></tr>
                            <tr><td>Birthday:</td><td> ${user.getDayBirthday()} ${user.getMonthBirthday()} ${user.getYearBirthday()} </td></tr> 
                            <tr><td>I am:</td><td>${user.getGender()}</td></tr><tr><td>Country:</td><td>${user.getCountry()}</td></tr>        
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
                        
                        <form action = "PostText"  method="post">
                            
                            <textarea class="textAreaPosts" name="message"></textarea> 
                            
                            <input type="submit" name="send" value="Send"/> 
                            
                            <input type="reset" name="clear" value="Clear"/>
                            
                        </form>                        
                    </div>               
                </div>       
            </div>
        </body> 
    </center>
</html>

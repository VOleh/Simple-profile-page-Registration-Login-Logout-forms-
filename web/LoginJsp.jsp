
<%@ page contentType="text/html;charset=UTF-8" session="false" %>
<!DOCTYPE html>
<html>
    
    <head>        
        <title>Login form</title>     
        <link href="CSS/StyleCss.css" rel="stylesheet" type="text/css"/>        

    </head>

    <body>
            <div id="divWindow">             
                <img src="Pictures/user.png" alt=""/>
                <div class="divForm">                    
                    <h3> Login form</h3>
                    
                    <span style="color:red;"><center> ${description}</center></span><br>
                    <form action="${pageContext.request.contextPath}/Login" method="post">
                        
                        <input type ="text" name="userLogin" maxlenght="15" 
                               placeholder="Your email..."/>
                        
                        <input type ="password" name= "userPassword"  maxlenght="30"
                               placeholder="Your password..."/>
                        
                        <input type="submit" name="submit" value="login"/>
                        <input type="reset" name="clear" value="clear"/>
                        
                        <p><a href="RegistrationJsp.jsp"> create new account</a></p>
                        
                    </form> 
                </div>
            </div>                   
    </body>
</html>


<%-- 

  <servlet>
        <servlet-name>login</servlet-name>
        <servlet-class>com.mvc.controller.LoginServlets</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>login</servlet-name>
        <url-pattern>/Login</url-pattern>
    </servlet-mapping>
--%>
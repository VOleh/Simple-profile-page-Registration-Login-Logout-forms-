
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <link href="CSS/StyleCss.css" rel="stylesheet" type="text/css"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login form</title>          
    </head>

     <body>
        <div id="divWindow">
            
            <img src="Pictures/user (2).png" alt=""/>
            <div class="divForm">
                
                <h3> Hobbies form</h3>
                
                <span style="color:green;"><center> ${remark}</center></span><br>
                <form action="AddHobbies" method="post">

                    <input type="hidden" id="parameter" name="hobbies" value="hobbies"/>

                    <textarea name="userHobbies" rows="10" cols="30"
                           placeholder="Your name..."></textarea>       

                    <input type="submit" name="submit" value="Submit"/>
                    
                    <input type="reset" name="clear" value="clear"/>
                </form>
                
                <center><p><a href="LoginJsp.jsp"> ${description}</a></p></center>
            </div>
        </div>
    </body>
</html>

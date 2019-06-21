
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <link href="CSS/StyleCss.css" rel="stylesheet" type="text/css"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interests form</title>    
    </head>
    <body>        
         <div id="divWindow">             
            <img src="Pictures/user (2).png" alt=""/>
            <div class="divForm">
                <h3> INTERESTS FORM</h3>
                <form action="AddInterests" method="post">
                    <input type="hidden" id="parameter" name="interests" value="interests"/>

                    <input type ="text" name="userFilms" maxlenght="200" 
                           placeholder="Your favorite films are..."/>       

                    <input type ="text" name= "userBooks"  maxlenght="200"
                           placeholder="What kind of books do you like?..."/>

                    <input type ="text" name= "userMusic"  maxlenght="200"
                           placeholder="Your favorite music groups..."/>

                    <input type ="text" name= "userSport"  maxlenght="200"
                           placeholder="Do you like some sport?..."/>

                    <input type="submit" name="submit" value="Next"/>
                    <input type="reset" name="clear" value="Clear"/>
                </form> 
            </div>
         </div>
    </body>
</html>

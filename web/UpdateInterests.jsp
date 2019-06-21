
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="CSS/StyleCss.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="divWindow">
            <img src="Pictures/user (4).png" alt=""/>
            <div class="divForm">
                <h3> Edit interests </h3>                
                <span style="color:green;"><center> <p> ${description}</p> </center></span>
                
                <form action="${pageContext.request.contextPath}/editInterests" method="post" >
                    
                    <input type="hidden" id="parameter" name="interests" value="interests"/>
                    
                    <label>Films:</label><br>
                    <textarea name="userFilms" rows="10" cols="40">${user.getUserFilms()}</textarea>
                    
                    <label>Books:</label><br>
                    <textarea name="userBooks" rows="10" cols="40">${user.getUserBooks()}</textarea>

                    <label>Music:</label><br>              
                    <textarea name="userMusic" rows="10" cols="40">${user.getUserMusic()}</textarea>

                    <label>Sport:</label><br>
                    <textarea name="userSport" rows="10" cols="40">${user.getUserSport()}</textarea>

                    <input type="submit" name="submit" value="Update"/>
                    <input type="reset" name="clear" value="Clear"/>
                    
                    <center><a href="${pageContext.request.contextPath}/Home?id=${user.getUserId()}"> ${remark}</a></p> </center>
                </form>
            </div>
        </div>
    </body>
</html>

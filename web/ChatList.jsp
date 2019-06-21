

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="CSS/StyleCss.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Chats</title>       
    </head>

        <body>
            <div id="divWindow">
                <img src="Pictures/team.png" alt=""/>
                <div class="divForm">
                    <h3> My chats: </h3>               
                   
                       <table>                            
                            <c:forEach items="${listChats}" var="item">
                                <tr>                                
                                    <td style="width: 150px;text-align: center; font-size : 20px;"> 
                                        <a href=Chating?userId=${item.getKey()}> ${item.getValue().getAuthorName()} ${item.getValue().getAuthorSurname()}</a>                                      
                                    </td>                                   
                                </tr>
                            </c:forEach>
                       </table>                  
                </div>
            </div>
        </body>        
   
</html>

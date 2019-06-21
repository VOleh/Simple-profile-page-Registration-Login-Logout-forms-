
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Login form</title>     
        <link href="CSS/StyleCss.css" rel="stylesheet" type="text/css"/> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

     <body>
        <div class="divHeader">
           <h1> VoI</h1> 
        </div>         

             <div id="divWindow">             
                 <img src="Pictures/user.png" alt=""/>
                     <div class="divForm">

                        <h3>Public your photos:</h3>

                        <form action="PostPhoto" method="post" enctype="multipart/form-data">

                            <input type="text" name="description" placeholder="Add your description..."/>

                            <input type ="file" name="file" alt="" />

                            <input type="submit" name="submit" value="Add"/>
                            <input type="reset" name="clear" value="Delete"/>
                        </form>
                    </div>
             </div>
    </body>
</html>
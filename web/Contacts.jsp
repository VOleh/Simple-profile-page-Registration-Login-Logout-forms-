<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>    
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/StyleCss.css" rel="stylesheet" type="text/css"/>
        <title>Contacts form</title>
    </head>
    <body>       
        <div id="divWindow">
            <img src="Pictures/user (2).png" alt=""/>
            
            <div class="divForm">
                
                <h3> CONTACTS FORM </h3>
                
                <form action="AddContacts" method="post">
                    
                    <input type="hidden" id="parameter" name="contacts" value="contacts"/>
                    
                    <select name="country">              
                        <option value ="Andora">Andora</option>
                        <option value ="Armenia">Armenia</option>
                        <option value ="Azerbaijan">Azerbaijan</option>
                        <option value ="Belarus">Belarus</option>
                        <option value ="Belgium">Belgium</option>
                        <option value ="Czechia">Czechia</option>
                        <option value ="Denmark">Denmark</option>
                        <option value ="Estonia">Estonia</option>
                        <option value ="Finland">Finland</option>
                        <option value ="France">France</option>
                        <option value ="Georhia">Georhia</option>
                        <option value ="Germany">Germany</option>
                        <option value ="Greece">Greece</option>
                        <option value ="Hungary">Hungary</option>
                        <option value ="Iceland">Iceland</option>
                        <option value ="Italy">Italy</option>
                        <option value ="Latvia">Latvia</option>
                        <option value ="Liechtenstein">Liechtenstein</option>
                        <option value ="Luxembourg">Luxembourg</option>
                        <option value ="Malta">Malta</option>
                        <option value ="Moldova">Moldova</option>
                        <option value ="Monaco">Monaco</option>
                        <option value ="Netherlands">Netherlands</option>
                        <option value ="Norway">Norway</option>
                        <option value ="Poland">Poland</option>
                        <option value ="Portugal">Portugal</option>
                        <option value ="Russia">Russia</option>
                        <option value ="San Marino">San Marino</option>
                        <option value ="Slovakia">Slovakia</option>
                        <option value ="Slovenia">Slovenia</option>
                        <option value ="Spain">Spain</option>
                        <option value ="Sweden">Sweden</option>
                        <option value ="Switzerland">Switzerland</option>
                        <option value ="Ukraine">Ukraine</option>
                        <option value ="Vatican">Vatican</option>
                    </select>
                    <input type="text"  name="homeTown"
                           maxlength="20" placeholder="Your home town..."/>
                    
                    <input type="text"  name="mobilePhone"
                           maxlength="20" placeholder="Your mobilePhone..."/>                

                    <input type="submit" value="Next">

                    <input type="reset" value="Clear">
                </form>
            </div>
        </div>
    </body>
</html>

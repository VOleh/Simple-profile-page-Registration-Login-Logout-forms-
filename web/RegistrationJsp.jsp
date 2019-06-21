
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>   

    <head>
        <link href="CSS/StyleCss.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Registration form</title>       
    </head>
    <body>
        <div id="divWindow">
            <img src="Pictures/team.png" alt=""/>
            <div class="divForm">
                <h3> registration form </h3>
                
                <span style="color:green;"><center> ${remark}</center></span><br>

                <form action="Registration" method="post">

                    <input type="hidden" id="parameter" name="registration" value="registration"/>
                    
                    <input type="text"  name="userName"
                           maxlength="20" placeholder="Your name..."/>

                    <input type="text"  name="userSurname"
                           maxlength="20" placeholder="Your surname..."/>

                    <div id="divBirthday">  
                        <select id="selectBirthday" name="dayBirthday">
                        <option value="1">1</option><option value="2">2</option>
                        <option value="3">3</option><option value="4">4</option>
                        <option value="5">5</option><option value="6">6</option>
                        <option value="7">7</option><option value="8">8</option>
                        <option value="9">9</option><option value="10">10</option>
                        <option value="11">11</option><option value="12">12</option>
                        <option value="13">13</option><option value="14">14</option>
                        <option value="15">15</option><option value="16">16</option>
                        <option value="17">17</option><option value="18">18</option>
                        <option value="19">19</option><option value="20">20</option>
                        <option value="21">21</option><option value="22">22</option>
                        <option value="23">23</option><option value="24">24</option>
                        <option value="25">25</option><option value="26">26</option>
                        <option value="27">27</option><option value="28">28</option>
                        <option value="29">29</option><option value="30">30</option>
                        <option value="31">31</option>
                        </select>

                        <select id="selectBirthday"  name="monthBirthday">
                        <option value="January">January</option>
                        <option value="February">February</option>
                        <option value="March">March</option>
                        <option value="April">April</option>
                        <option value="May">May</option>
                        <option value="June">June</option>
                        <option value="July">July</option>
                        <option value="Augest">Augest</option>
                        <option value="September">September</option>
                        <option value="October">October</option>
                        <option value="Nowember">Nowember</option>
                        <option value="December">December</option>
                        </select>

                        <input  type="number" name="yearBirthday" min="1950" max="2018" 
                               placeholder="Years..."/>
                    </div>
                    
                    <input type="text" name="email"
                           maxlength="64" placeholder="Your email..."/>

                    <select name="gender">            
                    <option value ="male">Male</option>
                    <option value ="female">Female</option> 
                    </select>

                    <input type="password" name="password" 
                           maxlength="25" placeholder="Your password..."/>          

                    <input type="password" name="confirmPassword" 
                           maxlength="25" placeholder="Confirm password..."/>                  

                    <input type="submit" value="Next">
                    <input type="reset" value="Clear">

                </form>
                <center><p><a href="LoginJsp.jsp"> ${description}</a></p></center>        
            </div>
        </div>
    </body>
</html>

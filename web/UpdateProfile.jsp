
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/StyleCss.css" rel="stylesheet" type="text/css"/>
        <title>Update general information</title>
    </head>
    <body>
        <div id="divWindow">    
            <img src="Pictures/user (4).png" alt=""/>   
            <div class="divForm">        
                <p> GENERAL INFORMATION </p> 

                <table>
                    <tr><td> Your name:</td> <td> ${user.getUserName()} </td></tr>
                    <tr><td> Your surname:</td> <td> ${user.getUserSurname()} </td></tr>                     
                </table>  
                    <span style="color:green;"><center> <p> ${description}</p> </center></span>

                <form action="${pageContext.request.contextPath}/editProfile" method="post">
                    <input type="hidden" id="parameter" name="profileInfo" value="profileInfo"/>                    
                    <label>Birthday:</label><br>
                    
                    <div id="divBirthday">
                        <select id="selectDayBirthday" name="dayBirthday">                    
                        <option value="${user.getDayBirthday()}">${user.getDayBirthday()}</option> 

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

                        <select id="selectMonthBirthday"  name="monthBirthday">                    
                        <option id="currentValue" value="${user.getMonthBirthday()}">${user.getMonthBirthday()} </option>

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

                        <input type="number" name="yearBirthday" min="1950" max="2018" 
                               value="${user.getYearBirthday()}"/>

                    </div>

                    <label>Country:</label><br> 

                    <select name="country">                 
                    <option value ="${user.getCountry()}">${user.getCountry()}</option>

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
                    
                    <label>Home town:</label><br>
                     <input type="text"  name="homeTown"
                           maxlength="20" value="${user.getUserHomeTown()}"/>
                     <label>Mobile phone:</label><br>
                     <input type="text"  name="mobilePhone"
                           maxlength="20" value="${user.getUserMobilePhone()}"/>
                     <label>Email:</label><br> 
                     <input type="text"  name="email"
                           maxlength="20" value="${user.getEmail()}"/>  

                    <input type="submit" value="Submit"/>
                    <input type="reset" value="Clear"/>
                    <center><a href="${pageContext.request.contextPath}/Home?id=${user.getUserId()}"> ${remark}</a></p> </center>
                </form>
            </div>
        </div>
    </body>
</html> 



        
    
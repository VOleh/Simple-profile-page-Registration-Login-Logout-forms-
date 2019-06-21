
<%@page import="com.mvc.bean.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        
        <script language="javascript" type="text/javascript">
                         
              function init(){
                var senderId = ${user.getUserId()};
                var reciverId = ${reciverId};
                var output = document.getElementById("output");
                var btnSend = document.getElementById("btnSend");
                var messageText = document.getElementById("messageText");   

                websocket = new WebSocket("ws://127.0.0.1:8080/MyWebChat/chat?sender="+senderId+"&reciver="+reciverId);
                websocket.onopen = function() { onOpen(); };                
                websocket.onmessage = function(evt) { onMessage(evt); };
                btnSend.onclick = function (){sendMessage();};
              };

              function onOpen(){
                if(websocket.readyState === WebSocket.OPEN){
                    writeToScreen('<span style="color:green;CONNECTED;">CONNECTED:</span>');}            
              };
             
              function onMessage(evt)
              { 
                 writeToScreen(evt.data);
              };


             function sendMessage() {
                websocket.send(messageText.value);
                messageText.value = "";
             };
             
              function writeToScreen(message)
              {
                var pre = document.createElement("p");
                pre.style.wordWrap = "break-word";
                pre.innerHTML = message;
                output.appendChild(pre);
              };

              window.addEventListener("load", init, false);
        </script>
        
        <title>Web Socket Chat</title>
    </head>
    <center>
        <body>
        <h1>Welcome to chat</h1>
        <div id="output">
            
        </div>
            <form> 
                <div>
                    <input type="text"  style="width: 230px;" id="messageText"/>                        
                    <input value="Add" id="btnSend" type="button"/>
                </div>            
            </form>  
        
        
        </body>
    </center>
    </html>
    

package com.mvc.controller;

import com.mvc.dao.AddGetUpdateDao;
import java.io.IOException;
import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/chat")

public class ChatEcho {
    
     private Session session;
     private final AddGetUpdateDao dao = new AddGetUpdateDao();
     
  
    @OnOpen
    public void open(Session session) {       
        
        this.session = session;
    }
    
    
    @OnMessage
    public void onMessage(String message) throws IOException{
        
        Integer sender = Integer.parseInt( session.getRequestParameterMap().get("sender").get(0));
        Integer reciver = Integer.parseInt(session.getRequestParameterMap().get("reciver").get(0));
        
        System.out.println("sender "+sender);
        System.out.println("reciver "+reciver);
        System.out.println("message "+message); 
        
        writeToDataBase(message,sender,reciver);        
        
            session.getBasicRemote().sendText(message);
           
    } 
    public void writeToDataBase(String message, Integer...p){
        
       String Sql_authorTable = "INSERT INTO author (reciver_id, sender_id) VALUES (?,?)";       
       
       String Sql_messageTable = "INSERT INTO message (reciver_id, sender_id, message) VALUES (?,?,?)";
       
       String check = dao.addInfo(p[0],p[1],message, Sql_authorTable,Sql_messageTable);
       if (check == "Success"){
           System.out.println("added");
       }else{
           System.out.println("error");
       }      
    } 
}


    


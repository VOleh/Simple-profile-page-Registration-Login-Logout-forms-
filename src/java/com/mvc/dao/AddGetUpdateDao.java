
package com.mvc.dao;
import com.mvc.bean.Post;
import com.mvc.bean.User;
import com.mvc.util.DataBaseConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class AddGetUpdateDao {  
    
    private ResultSet resultSet; 
    private final Connection connection = DataBaseConnect.createConnection();
    
    
    public  String addInfo(User user, String p, String...sql){    
        
        
            try{
                if(sql.length != 1){
                    
                    PreparedStatement pst = connection.prepareStatement(sql[0]);
                    PreparedStatement pst1 = connection.prepareStatement(sql[1]);                    
                    
                    if(p.equals("registration")){

                        pst.setString(1, user.getUserName());
                        pst.setString(2, user.getUserSurname());
                        pst.setString(3, user.getDayBirthday());
                        pst.setString(4, user.getMonthBirthday());
                        pst.setInt(5, user.getYearBirthday());       
                        pst.setString(6, user.getGender());
                        pst.setString(7, user.getPassword());

                        pst1.setString(1, user.getEmail());                      
                                                
                        int i = pst.executeUpdate();
                        int j = pst1.executeUpdate();                   
                       
                        if((i!=0) && (j!=0)){ return "Success";}    
                    }
                }else{
                    
                    PreparedStatement pst = connection.prepareStatement(sql[0]);
                    
                    if(p.equals("contacts")){               
                        pst.setString(1, user.getCountry());
                        pst.setString(2, user.getUserHomeTown());
                        pst.setString(3, user.getUserMobilePhone());
                        pst.setInt(4, user.getUserId());

                    }else if(p.equals("interests")){                    
                        pst.setInt(1, user.getUserId());
                        pst.setString(2, user.getUserFilms());
                        pst.setString(3, user.getUserBooks());             
                        pst.setString(4, user.getUserMusic());
                        pst.setString(5, user.getUserSport());

                    }else if(p.equals("hobbies")){                    
                        pst.setString(1, user.getUserHobbies());
                        pst.setInt(2, user.getUserId());
                    }
                    
                    int i = pst.executeUpdate();
                    if(i!=0){ return "Success";}                    
                    }                                              
        }catch (Exception e){
            e.printStackTrace();
        }        
            return "Error";
    }
    
    public void create(User user, String sqlWall, String sqlChat){
        
        try {
            PreparedStatement pst = connection.prepareStatement(sqlWall);
            PreparedStatement pst1 = connection.prepareStatement(sqlChat);
            
            pst.setInt(1, user.getUserId());
            pst1.setInt(1, user.getUserId());                                                 

            pst.executeUpdate();
            pst1.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }         
    }
    
    
    
    
    

    public String addPost( User user, Post message,HttpServletRequest request, String ... sql){
        
                ServletContext servContext = request.getServletContext();           
                Integer key = (Integer) servContext.getAttribute("key");
                
        try{
                PreparedStatement  pst_message =connection.prepareStatement(sql[0]);
                if( key == null){                   
                    pst_message.setInt(1, user.getUserId());
                }else{              
                    pst_message.setInt(1, key);
                }                
                pst_message.setInt(2, user.getUserId());
                pst_message.setString(3, message.getMessage());
                
                int k = pst_message.executeUpdate();                
                if((k!=0)){                    
                return "Success"; }            
        }catch (Exception e){
            e.printStackTrace(); }        
        return "Error";
    }


    
    
    public  ResultSet getInfo(User user, String p, String sql){
        
            try{ 
                PreparedStatement ps = connection.prepareStatement(sql);

                if(p.equals("registration")){
                    ps.setString(1, user.getEmail());

                }else if(p.equals("authorization")){
                  ps.setString(1, user.getEmail());
                  ps.setString(2, user.getPassword());  

                }else if(p.equals("login")){
                  ps.setInt(1, user.getUserId());                
                }               

                  resultSet = ps.executeQuery();       
            }catch (Exception e){            
                e.printStackTrace();}        
                return resultSet;
    }
    
        public  ResultSet getInfo( String sql,User user){
        
            try{ 
                PreparedStatement ps = connection.prepareStatement(sql); 
                ps.setInt(1, user.getUserId());
                resultSet = ps.executeQuery();       
            }catch (Exception e){            
                e.printStackTrace();}        
                return resultSet;
    }
    
    
    
    
    public String updateInfo(User user, String p, String...sql){
        
        try{
            if(sql.length != 1){

                PreparedStatement pst = connection.prepareStatement(sql[0]);
                PreparedStatement pst1 = connection.prepareStatement(sql[1]);

                if(p.equals("profileInfo")){

                    pst.setString(1, user.getDayBirthday());
                    pst.setString(2, user.getMonthBirthday());
                    pst.setInt(3, user.getYearBirthday());
                    pst.setInt(4, user.getUserId());                    

                    pst1.setString(1, user.getCountry());
                    pst1.setString(2, user.getUserHomeTown());
                    pst1.setString(3, user.getUserMobilePhone());
                    pst1.setInt(4, user.getUserId());
                }
                
                int i = pst.executeUpdate();
                int j = pst1.executeUpdate();
                
                if((i!=0)||(i!=0 && j!=0)){
                    return "Updated";
                }
            }else {
                PreparedStatement pst = connection.prepareStatement(sql[0]);
                
                if(p.equals("interests")){      

                    pst.setString(1, user.getUserFilms());
                    pst.setString(2, user.getUserBooks());             
                    pst.setString(3, user.getUserMusic());
                    pst.setString(4, user.getUserSport());
                    pst.setInt(5, user.getUserId());              

                }else if(p.equals("password")){                   

                    pst.setString(1, user.getPassword());
                    pst.setInt(2, user.getUserId());
                }
                    int i = pst.executeUpdate();
                    
                    if(i!=0){ 
                        return "Updated";
                    }             
            }                
        }catch (Exception e){
            e.printStackTrace();
        }             
        return "Error";     
    }


  public String addInfo( Integer sender, Integer reciver, String message, String ... sql){       
                
        try{            
            PreparedStatement  pst_author = connection.prepareStatement(sql[0]);
            PreparedStatement  pst_message = connection.prepareStatement(sql[1]);

            pst_author.setInt(1, reciver);
            pst_author.setInt(2, sender);

            pst_message.setInt(1, reciver);
            pst_message.setInt(2, sender);
            pst_message.setString(3, message);
           
            int b = pst_author.executeUpdate();
            int c = pst_message.executeUpdate();
            if((b!=0)&&(c!=0)){                    
                return "Success"; 
            }            
        }catch (Exception e){
            e.printStackTrace(); }        
        return "Error";
    }

}
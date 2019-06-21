
package com.mvc.dao;

import com.mvc.bean.User;
import com.mvc.util.DataBaseConnect;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddFileDao {  
    
     public String addFile(User user, InputStream inputStream, String sql){
         
        try{            
            Connection connection = DataBaseConnect.createConnection();

            PreparedStatement pst =connection.prepareStatement(sql);

            pst.setBlob(1,  inputStream);
            pst.setInt(2,  user.getUserId());
        
            int i = pst.executeUpdate();
            
            if(i!=0){ return "Success";}
            
        }catch (Exception e){
            e.printStackTrace();
        }               
        return "Error";
    }
}


package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataBaseConnect {
    
    public static Connection createConnection() {   
    String url = "jdbc:sqlserver://localhost:1433;databaseName=MyWebProject";
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String login ="User";
    String passwordDataBase ="123456789";   
    
    Connection connection = null;
      try{
          
         try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
         connection = DriverManager.getConnection(url, login, passwordDataBase);
         
        }catch (Exception e){
          e.printStackTrace();
      }
       
    return connection;
    }
}
          
    
 
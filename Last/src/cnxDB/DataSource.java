/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cnxDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mahmo
 */
public class DataSource {
    private Connection connection;
    private String url="jdbc:mysql://localhost:3306/cupcake";
    private String user="root";
    private String pwd="";
    public static DataSource instance;
    
    //private Statement ste;
    private DataSource() {
        
            try {
                connection = DriverManager.getConnection(url,user,pwd);
            } catch (SQLException ex) {
                Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        
        
    }
    public  Connection getConnection()
    {
    return connection;
    }
    
     public static DataSource getInstance(){
        if (instance == null)
        {
            instance = new DataSource();
        }
        return instance;
    }
    
    
    
    
}

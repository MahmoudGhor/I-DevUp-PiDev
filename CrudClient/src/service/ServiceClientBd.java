/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import CnxBD.DataSource;
import crudclient.CrudClient;
import entites.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mahmo
 */
public class ServiceClientBd {
    static DataSource ds = DataSource.getInstance();
    
     public  void insererPersonne(Client c) {
        try {
            //  try {
        // Statement ste = ds.getConnection().createStatement();
        //String req = "insert into personne (`nom`,`prenom`) values ('"+p.getNom()+"','"+p.getPrenom()+"')";
         //ste.executeUpdate(req);
              
        String req = "insert into user (username , email , enabled , password , roles , firstname , lastname , phone , town ,  picture , address , postalcode , facebook) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
         PreparedStatement ste1 = ds.getInstance().getConnection().prepareStatement(req);
         ste1.setString(1, c.getUsername());
         ste1.setString(2, c.getEmail());
         ste1.setInt(3, 1);
         ste1.setString(4, c.getPassword());
         ste1.setString(5, "Client");
         ste1.setString(6, c.getFirstname());
         ste1.setString(7, c.getLastname());
         ste1.setString(8, c.getPhone());
         ste1.setString(9, c.getTown());
         ste1.setString(10, c.getPicture());
         ste1.setString(11, c.getAddress());
         ste1.setString(12, c.getPostalcode());
         ste1.setString(13, c.getFacebook());
         ste1.executeUpdate(); //exécution
            System.out.println("ok");
         //  } catch (Exception e) {
            //      System.out.println("probleme");
            // }
        } catch (SQLException ex) {
            Logger.getLogger(CrudClient.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    
        
}
     
     
     public String getImageClient(String cli)
     {
         String image = null ;
         try {
         Statement ste = ds.getConnection().createStatement();
         String req = "select picture from user where username='"+cli+"'";
         ResultSet rs =ste.executeQuery(req);
           while (rs.next()) {
               String s = rs.getString(1);
               image=s;
           }
            } catch (SQLException ex) {
            Logger.getLogger(CrudClient.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return  image;
     }
     
     public Client getInfoClient(String cli)
     {
         Client c = new Client();
         try {
         Statement ste = ds.getConnection().createStatement();
         String req = "select firstname , lastname , email , phone , town , address , postalcode , facebook from user where username='"+cli+"'";
         ResultSet rs =ste.executeQuery(req);
           while (rs.next()) {
               String firstname = rs.getString(1);
               String lastname = rs.getString(2);
               String email = rs.getString(3);
               String phone = rs.getString(4);
               String town = rs.getString(5);
               String address = rs.getString(6);
               String postalcode = rs.getString(7);
               String facebook = rs.getString(8);
                c = new Client(email, firstname, lastname, phone, town, address, postalcode, facebook);
              
           }
            } catch (SQLException ex) {
            Logger.getLogger(CrudClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
       
       
     }
     
     
           public void updateClient(Client c ) {
        try {
            System.out.println(c.getPicture());
         Statement ste = ds.getConnection().createStatement();
         String req = "update user set firstname='"+c.getFirstname()+"',lastname='"+c.getLastname()+"' ,email='"+c.getEmail()+"',phone='"+c.getPhone()+"',town='"+c.getTown()+"', picture='"+c.getPicture()+"',address='"+c.getAddress()+"',postalcode='"+c.getPostalcode()+"',facebook='"+c.getFacebook()+"'  where username= 'ali' ";
         ste.executeUpdate(req);
            } catch (SQLException ex) {
            Logger.getLogger(CrudClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
}
}

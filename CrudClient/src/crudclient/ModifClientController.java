/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudclient;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entites.Client;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import service.ServiceClientBd;

/**
 * FXML Controller class
 *
 * @author mahmo
 */
public class ModifClientController implements Initializable {
    
    String newUrl;
    @FXML
    private Label username;
    @FXML
    private ImageView photo;
    @FXML
    private JFXTextField firstname;
    @FXML
    private JFXTextField lastname;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField phone;
    @FXML
    private JFXTextField town;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXTextField postalcode;
    @FXML
    private JFXTextField facebook;
    @FXML
    private JFXButton btn;
    
     List<String> lstFile;
    @FXML
    private JFXButton btnmdfimg;
     
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        lstFile = new ArrayList<>();
        lstFile.add("*.png");
        lstFile.add("*.jpg");
        username.setText("ali");
        ServiceClientBd serv = new ServiceClientBd();
        //System.out.println(serv.getImageClient("ali"));
        newUrl=serv.getImageClient("ali");
        Image image = new Image("file:"+serv.getImageClient("ali"));
        photo.setImage(image);
        firstname.setText( serv.getInfoClient("ali").getFirstname());
        lastname.setText(serv.getInfoClient("ali").getLastname());
        email.setText(serv.getInfoClient("ali").getEmail());
        phone.setText(serv.getInfoClient("ali").getPhone());
        town.setText(serv.getInfoClient("ali").getTown());
        address.setText(serv.getInfoClient("ali").getAddress());
        postalcode.setText(serv.getInfoClient("ali").getPostalcode());
        facebook.setText(serv.getInfoClient("ali").getPostalcode());
    }    

    @FXML
    private void changeimg(ActionEvent event) throws MalformedURLException{
         FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("word file", lstFile));
        File f = fc.showOpenDialog(null);
        
        if (f!=null)
        {
            String s = f.getAbsolutePath();
            System.out.println(s);
            newUrl= s;
            Image image = new Image(f.toURI().toURL().toString());
            photo.setImage(image) ;
        }
        
        
        
    }

    @FXML
    private void save(MouseEvent event) {
        System.out.println(newUrl);
        newUrl = newUrl.replaceAll("\\\\", "/");
        Client c = new Client(email.getText(), firstname.getText(), lastname.getText(), phone.getText(), town.getText(), address.getText(), postalcode.getText(), newUrl.toString(), facebook.getText());
        ServiceClientBd serv = new ServiceClientBd();
        serv.updateClient(c);
        System.out.println("ok");
        
        
        
                }
    
    
    
}

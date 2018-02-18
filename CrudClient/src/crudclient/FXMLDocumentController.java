/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudclient;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entites.Client;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import service.ServiceClientBd;
import service.serviceCryptage;

/**
 *
 * @author mahmo
 */
public class FXMLDocumentController implements Initializable {
    
    List<String> lstFile;
    private Label label;
    @FXML
    private ImageView view;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField firstname;
    @FXML
    private JFXTextField lastname;
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
    private JFXButton bt1;
    @FXML
    private Label lab;
    @FXML
    private JFXButton enreg;
    @FXML
    private Label warning;
    @FXML
    private Label warning1;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bt1.setDisable(false);
        lstFile = new ArrayList<>();
        lstFile.add("*.png");
        lstFile.add("*.jpg");
    }    

    @FXML
    private void choseimage(MouseEvent event) throws MalformedURLException{
        
        FileChooser fc = new FileChooser();
       // System.out.println("0");
        fc.getExtensionFilters().add(new ExtensionFilter("word file", lstFile));
       // System.out.println("1");
        File f = fc.showOpenDialog(null);
        
        if (f!=null)
        {
            lab.setText(f.getAbsolutePath());
            Image image = new Image(f.toURI().toURL().toString());
            view.setImage(image) ;
        }
    }

    @FXML
    private void enregistrer(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Alert alert1 = new Alert(Alert.AlertType.WARNING);
        
        
        
//        if (phone.getText()!="")
//        {
//            System.out.println("aaaaaa");
//            System.out.println(phone.getText());
//        }
        if ((lab.getText().equals(""))||(username.getText().equals(""))||(email.getText().equals(""))||(password.getText().equals(""))||(firstname.getText().equals(""))||(lastname.getText().equals(""))||(phone.getText().equals(""))||(town.getText().equals(""))||(address.getText().equals(""))||(postalcode.getText().equals(""))||(facebook.getText().equals("")))
        {
            alert.setTitle("Warning");
                            alert.setHeaderText("Warning");
                            alert.setContentText("Veillez remplir tous les champs");
                            alert.show();
        }
        else 
        {
            System.out.println("eee");
            serviceCryptage crypt = new serviceCryptage();
            String mdpCrypte = crypt.cryptWithMD5(password.getText());
            Client c = new Client(username.getText(), email.getText(), mdpCrypte.toString(),firstname.getText(), lastname.getText(), phone.getText(), town.getText(), address.getText(), postalcode.getText(), lab.getText(), facebook.getText());
            ServiceClientBd serv = new ServiceClientBd();
            serv.insererPersonne(c);
            alert.setTitle("Inscription avec ressuite");
                            alert.setHeaderText("reussite");
                            alert.setContentText("Votre inscription est effectué avec succés");
                            alert.show();
            username.setText("");
            email.setText("");
            firstname.setText("");
            lastname.setText("");
            phone.setText("");
            town.setText("");
            address.setText("");
            postalcode.setText("");
            lab.setText("");
            facebook.setText("");
            view.setImage(null);
            password.setText("");
            
            
            
            
        }
                }

    @FXML
    private void keyleaved(KeyEvent event) {
      
    }

    @FXML
    private void keyleave(KeyEvent event) {
        
          Alert alert = new Alert(Alert.AlertType.ERROR);
         String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"+"[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
        Pattern pattern = Pattern.compile(masque);
        Matcher controler = pattern.matcher(email.getText());
        
        if (controler.matches()){            
            warning.setVisible(false);
            bt1.setDisable(false);                            
        }
        else{
            warning.setVisible(true);
         warning.setText("verifier votre mail !");
        bt1.setDisable(true);
        bt1.focusedProperty();
    }
    }

    @FXML
    private void verifnumber(KeyEvent event) {
        
    }

    @FXML
    private void verifnumbers(KeyEvent event) {
        if(phone.getText().trim().length()>0)
        {
         try {
            int i = Integer.parseInt(phone.getText());
             }
         catch (NumberFormatException e) {
            warning1.setVisible(true);
            warning1.setText("il faut inserer seulement des numéros");
            enreg.setDisable(true);
            }
        }
        
    }
    
}

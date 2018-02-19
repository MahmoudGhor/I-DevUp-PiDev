/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package last;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.org.apache.xerces.internal.util.URI;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.ServiceClientBd;

/**
 * FXML Controller class
 *
 * @author mahmo
 */
public class SignupController implements Initializable {
    ServiceClientBd servCl = new ServiceClientBd();
    boolean verifivationEmail = false;
    boolean verifivationDoubleEmail = false;
    boolean verificationUserName = false;
    boolean verificationPassword =false;
    boolean verificationDoublePassword=false;
    boolean verificationNumero=false;
    boolean verificationSexe=false;
    boolean verificationNom=false;
    boolean verificationPrenom=false;
    boolean verificationVille=false;
    boolean verificationAdresse=false;
    boolean verificationCodePostal=false;
    
    
    @FXML
    private AnchorPane pane2;
    private JFXComboBox<String> type;
    @FXML
    private ImageView view1;
    @FXML
    private AnchorPane pane1;
    @FXML
    private JFXButton suivat1;
    @FXML
    private JFXButton save;
    @FXML
    private JFXButton precedent;
    @FXML
    private JFXComboBox<String> ville;
    @FXML
    private JFXComboBox<String> sexe;
    @FXML
    private JFXTextField username;
    @FXML
    private Label labelusername;
    @FXML
    private Label verifEmail;
    @FXML
    private Label confEmail;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField confirmationEmail;
    List<String> lstFile;
    @FXML
    private ImageView view2;
    @FXML
    private Label labelImage;
    @FXML
    private JFXButton Annuler;
    @FXML
    private JFXPasswordField password;
    @FXML
    private Label labelMdp;
    @FXML
    private JFXPasswordField confirmationMDP;
    @FXML
    private Label labelConfirmationMdp;
    @FXML
    private JFXTextField Nom;
    @FXML
    private JFXTextField Prenom;
    @FXML
    private JFXTextField Tel;
    @FXML
    private Label telConfirmation;
    @FXML
    private JFXTextField Adresse;
    @FXML
    private JFXTextField CodePostal;
    @FXML
    private JFXTextField facebook;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pane2.setVisible(false);
        view2.setVisible(false);
        ObservableList<String> listeVille = FXCollections.observableArrayList(
        "Tunis","Sfax"
        );
        ville.setItems(listeVille);
        ObservableList<String> listeUser = FXCollections.observableArrayList(
        "Homme","Femme"
        );
        sexe.setItems(listeUser);
        lstFile = new ArrayList<>();
        lstFile.add("*.png");
        lstFile.add("*.jpg");
    }    

    @FXML
    private void passinter2(MouseEvent event) {
        pane1.setVisible(false);
        pane2.setVisible(true);
    }

    @FXML
    private void passinter1(MouseEvent event) {
        pane1.setVisible(true);
        pane2.setVisible(false);
    }

    @FXML
    private void typeuser(MouseEvent event) {
    }

    @FXML
    private void chargeville(MouseEvent event) {
    }

    @FXML
    private void verifusername(KeyEvent event) {
        if (servCl.searchClientByUserName(username.getText())==true)
        {
            labelusername.setText("Nom d'utilisateur existe déja");
            verificationUserName=false;
        }
        if (servCl.searchClientByUserName(username.getText())==false)
        {
            labelusername.setText("");
            verificationUserName=true;
        }
        
    }

    @FXML
    private void verifEmail(KeyEvent event) {
        if (servCl.searchClientByEmail(email.getText())==true)
        {
            verifEmail.setText("Email Existe déja");
            verifivationEmail=false;
        }
        if (servCl.searchClientByEmail(email.getText())==false)
        {
                String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"+"[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
        Pattern pattern = Pattern.compile(masque);
        Matcher controler = pattern.matcher(email.getText());
        
        if (controler.matches()){            
            verifEmail.setVisible(false); 
            verifivationEmail=true;
        }
        else{
            verifEmail.setVisible(true);
         verifEmail.setText("verifier votre mail !");
         verifivationEmail=false;
        
        
    }
        }
        
    }

    @FXML
    private void ConfirmEmail(KeyEvent event) {
        if (email.getText().equals(confirmationEmail.getText()))
        {
            confEmail.setText("");
            verifivationDoubleEmail=true;
        }
        else
        {
            confEmail.setText("Verifier votre email");
            verifivationDoubleEmail=false;
        }
    }

    @FXML
    private void ChargeImage(MouseEvent event) throws MalformedURLException{
         FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("word file", lstFile));
       File f = fc.showOpenDialog(null);
        
        if (f!=null)
        {
            //lab.setText(f.getAbsolutePath());
            Image image = new Image(f.toURI().toURL().toString());
            view2.setImage(image) ;
            view2.setVisible(true);
            view1.setVisible(false);
            labelImage.setText("Cliquez sur l'image pour la changer!");
        }
        
    }

    @FXML
    private void ChangeImage(MouseEvent event) throws MalformedURLException{
        
           FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("word file", lstFile));
       File f = fc.showOpenDialog(null);
        
        if (f!=null)
        {
            //lab.setText(f.getAbsolutePath());
            Image image = new Image(f.toURI().toURL().toString());
            view2.setImage(image) ;
            view2.setVisible(true);
            view1.setVisible(false);
            labelImage.setText("Cliquez sur l'image pour la changer!");
        }
    }

    @FXML
    private void AnnulerClick(MouseEvent event) {
                Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
        Scene scene = new Scene(root);
        Stage stage  = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        pane1.getScene().getWindow().hide();
        
    }

    @FXML
    private void controlMdp(KeyEvent event) {
        if (password.getText()=="")
        {
            labelMdp.setText("");
            verificationPassword=false;
        }
        else if (password.getText().trim().length()<6)
        {
            labelMdp.setText("6 caractéres minimum");
            verificationPassword=false;
        }
        else
        {
            labelMdp.setText("");
            verificationPassword=true;
        }
    }

    @FXML
    private void ConfirmMDP(KeyEvent event) {
          if (password.getText().equals(confirmationMDP.getText()))
        {
            confirmationMDP.setText("");
            verificationDoublePassword=true;
        }
        else
        {
            confirmationMDP.setText("Verifier votre mot de passe");
            verificationDoublePassword=false;
        }
    }


    @FXML
    private void verifNumber2(KeyEvent event) {
        if (Tel.getText().trim().length()==8)
        {
            telConfirmation.setText("");
            verificationNumero=true;
        }
        else
        {
            telConfirmation.setText("8 chiffres");
            verificationNumero=false;
        }
    }

    @FXML
    private void verifNumber(KeyEvent ev) {
            String c = ev.getCharacter();
    if("1234567890".contains(c)) 
    {
    }
    else {
        ev.consume();
    }
    }

    @FXML
    private void save(MouseEvent event) {
        //verification sexe
        if (sexe.getValue()==null)
        {
            verificationSexe=false;
        }
        else 
        {
            verificationSexe=true;
        }
        
        //verification Nom
        if ((Nom.getText()==null)||(Nom.getText()==""))
        {
            verificationNom=false;
        }
        else
        {
            verificationNom=true;
        }
        
        //verification Prenom
         if ((Prenom.getText()==null)||(Prenom.getText()==""))
        {
            verificationPrenom=false;
        }
        else
        {
            verificationPrenom=true;
        }
         
         //verification ville
          if (ville.getValue()==null)
        {
            verificationVille=false;
        }
        else 
        {
            verificationVille=true;
        }
          
          //verification Adresse
         if ((Adresse.getText()==null)||(Adresse.getText()==""))
        {
            verificationAdresse=false;
        }
        else
        {
            verificationAdresse=true;
        }  
         
         //verification code Postal
          if ((CodePostal.getText()==null)||(CodePostal.getText()==""))
        {
            verificationCodePostal=false;
        }
        else
        {
            verificationCodePostal=true;
        }
    }

    @FXML
    private void VerifNumberCodePostal(KeyEvent ev) {
             String c = ev.getCharacter();
    if("1234567890".contains(c)) 
    {
    }
    else {
        ev.consume();
    }
    }

    
    
    


}

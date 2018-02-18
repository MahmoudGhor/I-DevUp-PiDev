/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package last;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.ServiceClientBd;

/**
 * FXML Controller class
 *
 * @author mahmo
 */
public class SignupController implements Initializable {

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
    
    /**
     * Initializes the controller class.
     */
     ServiceClientBd servCl = new ServiceClientBd();
    @FXML
    private Label verifEmail;
    @FXML
    private Label confEmail;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField confirmationEmail;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pane2.setVisible(false);
        ObservableList<String> listeVille = FXCollections.observableArrayList(
        "Tunis","Sfax"
        );
        ville.setItems(listeVille);
        ObservableList<String> listeUser = FXCollections.observableArrayList(
        "Homme","Femme"
        );
        sexe.setItems(listeUser);
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
        }
        if (servCl.searchClientByUserName(username.getText())==false)
        {
            labelusername.setText("");
        }
        
    }

    @FXML
    private void verifEmail(KeyEvent event) {
        if (servCl.searchClientByEmail(email.getText())==true)
        {
            verifEmail.setText("Email Existe déja");
        }
        if (servCl.searchClientByEmail(email.getText())==false)
        {
            verifEmail.setText("");
        }
    }

    @FXML
    private void ConfirmEmail(KeyEvent event) {
        if (email.getText().equals(confirmationEmail.getText()))
        {
            confEmail.setText("");
        }
        else
        {
            confEmail.setText("Verifier votre email");
        }
    }


}

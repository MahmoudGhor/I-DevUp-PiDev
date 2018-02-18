/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package last;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author mahmo
 */
public class SignInController implements Initializable {

    @FXML
    private AnchorPane frame;
 //   @FXML
 //   private JFXPopup pop;
//     final Popup popup = new Popup();
    @FXML
    private ImageView close;
 

      
    
    private void handleButtonAction(ActionEvent event) {
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb ) {
//      JFXButton b1 = new JFXButton("je suis un Client");
//        JFXButton b2 = new JFXButton("je suis un Patissié");
//        b1.setPadding(new Insets(10));
//        b2.setPadding(new Insets(10));
//         vBox = new VBox(b1,b2);
//       popup.getContent().addAll(vBox);
      
     //  HBox layout = new HBox();
   // layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");
  // primaryStage.setScene(new Scene(layout));
  // primaryStage.show();
    
    }  
    
   
    @FXML
    private void Signup(MouseEvent event) throws IOException{
          Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("Type.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
        Scene scene = new Scene(root);
        Stage stage  = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        frame.getScene().getWindow().hide();
       
    }

    @FXML
    private void Close(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Vous allez quitter l'application");
        alert.setHeaderText("Vous allez quitter l'application");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
                System.exit(0);
        } else {
            alert.close();
        }
        
    }

   
    
}

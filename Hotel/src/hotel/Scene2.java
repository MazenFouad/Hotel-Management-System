/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

import static hotel.Hotel.mystage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author THE LAPTOP SHOP
 */
public class Scene2 extends Scene{
    public Scene2(Parent parent, double d, double d1) throws InterruptedException, FileNotFoundException{
        super(parent, d, d1);
        Receptionist res = new Receptionist();
        StackPane pane2 = new StackPane();
        Image im = new Image(new FileInputStream("gold_white.JPG"));
        ImageView image = new ImageView(im);
        image.setFitHeight(800);
        image.setFitWidth(800);
        
        Text login = new Text("Log In");
        login.setFont(Font.font("Times New Roman", FontWeight.NORMAL,50));
        login.setFill(Color.BLACK);
         GridPane grid2 = new GridPane();
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(10,10,10,10));
        grid2.setAlignment(Pos.CENTER);   
        grid2.add(login, 1, 2);
        TextField PasswordText = new TextField();
        PasswordField pass = new PasswordField();
        TextField UsernameText = new TextField();
//        pass.setStyle("-fx-background-radius: 15px; -fx-text-fill: #ffffff");
//        UsernameText.setStyle("-fx-background-radius: 15px; -fx-text-fill: #ffffff");
        UsernameText.setMinSize(300, 10);
        CheckBox showPass = new CheckBox("Show/Hide");
        PasswordText.setManaged(false);
        PasswordText.setVisible(false);
        PasswordText.managedProperty().bind(showPass.selectedProperty());
        PasswordText.visibleProperty().bind(showPass.selectedProperty());
        pass.managedProperty().bind(showPass.selectedProperty().not());
        pass.visibleProperty().bind(showPass.selectedProperty().not());
        PasswordText.textProperty().bindBidirectional(pass.textProperty());
        Label us = new Label("Username: ");
       Label ps = new Label("Password: ");
        grid2.add(us, 0,3);
        grid2.add(ps, 0,4);
        grid2.add(UsernameText, 1, 3);
        grid2.add(PasswordText, 1,4);
        grid2.add(pass, 1,4);
        grid2.add(showPass, 1,5);
        Button LogIn = new Button("Log In");
        grid2.add(LogIn, 1,6);
        LogIn.setStyle("-fx-background-color: #0000FF; -fx-background-radius: 10px; -fx-text-fill: #ffffff");
        LogIn.setMinSize(300, 30);  
        LogIn.setOnMouseEntered(e -> LogIn.setStyle("-fx-background-color: #0000CD; -fx-background-radius: 10px; -fx-text-fill: #ffffff"));
        LogIn.setOnMouseExited(e -> LogIn.setStyle("-fx-background-color: #0000FF; -fx-background-radius: 10px; -fx-text-fill: #ffffff"));
        pane2.getChildren().add(image);
        pane2.getChildren().addAll(grid2);
      Scene3 scene3 = new Scene3(new Pane(), 1000,600); 
        LogIn.setOnMouseClicked(e->{
        
            String usr= UsernameText.getText();
            String pswr = pass.getText();
            
            try {
                if(res.LogIN(usr, pswr))
                {
                   mystage.setScene(scene3);
                   mystage.show();
                }
                else 
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Incorrect Password");
                    alert.show();
                }
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        });
        setRoot(pane2);
        
  }
}

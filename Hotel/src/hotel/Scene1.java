/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

import static hotel.Hotel.mystage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author THE LAPTOP SHOP
 */
public class Scene1 extends Scene
    { 

    public Scene1(Parent parent, double d, double d1) throws FileNotFoundException, InterruptedException {
        super(parent, d, d1);
        Image im2 = new Image(new FileInputStream("hand_painted.JPG"));
        ImageView image2 = new ImageView(im2);
        image2.setFitHeight(800);
        image2.setFitWidth(800);
        Text txt = new Text("Welcome "); 
        txt.setFill(Color.BLACK);
        txt.setFont(Font.font("Times New Roman", FontWeight.NORMAL,50));        
        StackPane pane = new StackPane();
        pane.getChildren().add(image2);
        HBox text=new HBox();
        text.getChildren().add(txt);
        text.setAlignment(Pos.CENTER);
        text.setPadding(new Insets(200,5,5,5));
        pane.setPadding(new Insets(10,10,10,10));
        pane.setAlignment(Pos.CENTER);   
        Duration time = Duration.millis(2500);
        FadeTransition fade = new FadeTransition(time, txt);
        fade.setFromValue(0);
        fade.setToValue(1);  
        Button cont = new Button("Log in");        
        cont.setStyle("-fx-background-color: #0000FF; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        cont.setMinWidth(200);
        cont.setMinHeight(30);
        HBox btn=new HBox();
        text.getChildren().add(cont);
        text.setAlignment(Pos.CENTER);
        
         Duration time2 = Duration.millis(2500); 
         VBox vb=new VBox(20);
         vb.getChildren().addAll(text,btn);
         pane.getChildren().add(vb);
         
        FadeTransition fade2 = new FadeTransition(time2, cont);
        fade2.setFromValue(0);
        fade2.setToValue(1);       
        pane.getChildren().add(cont);       
        SequentialTransition seqTransition = new SequentialTransition (fade,new PauseTransition(Duration.millis(5)),fade2);  
        seqTransition.play();
       
        Scene2 scene2 = new Scene2(new Pane(),800, 600);
        cont.setOnAction( e-> mystage.setScene(scene2));
        setRoot(pane);
    }
}    

    
         
   
    
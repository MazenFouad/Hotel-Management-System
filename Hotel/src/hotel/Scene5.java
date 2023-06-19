/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author THE LAPTOP SHOP
 */
public class Scene5 extends Scene {
     public Scene5(Parent parent, double d, double d1) throws InterruptedException, FileNotFoundException{
        super(parent, d, d1);
       StackPane pane = new StackPane();
       pane.setAlignment(Pos.TOP_LEFT);
       Rectangle sideRec = new Rectangle();
       sideRec.setHeight(700);
       sideRec.setWidth(200);
       sideRec.setFill(Color.BLACK);
       Rectangle nameRec = new Rectangle();
       nameRec.setHeight(50);
       nameRec.setWidth(200);
       nameRec.setFill(Color.DARKCYAN);
       Rectangle AfterNameRec = new Rectangle();
       AfterNameRec.setHeight(50);
       AfterNameRec.setWidth(1000);
       AfterNameRec.setFill(Color.BLACK);
       AfterNameRec.setTranslateX(200);
       Text HotelName = new Text("My Hotel");
       HotelName.setFill(Color.WHITE);
       HotelName.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 30));
       HotelName.setTranslateX(40);
       HotelName.setTranslateY(8);
       Hyperlink booking = new Hyperlink();
        ImageView bk = new ImageView(new Image(new FileInputStream("white_calendar.PNG")));
        bk.setFitHeight(30);
        bk.setFitWidth(30);
        booking.setTranslateX(20);
        booking.setTranslateY(150);
        Text bo  = new Text("Bookings");
        bo.setFill(Color.WHITE);
        bo.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        bo.setTranslateX(65);
        bo.setTranslateY(154);
        booking.setGraphic(bk);
        booking.setBorder(Border.EMPTY);
        Hyperlink rooms = new Hyperlink();
        ImageView rms = new ImageView(new Image(new FileInputStream("white_house.PNG")));
        rooms.setTranslateX(20);
        rooms.setTranslateY(235);
        rms.setFitHeight(30);
        rms.setFitWidth(30);
        Text roomsText = new Text("Delete Guests");
        roomsText.setFill(Color.WHITE);
        roomsText.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        roomsText.setTranslateX(65);
        roomsText.setTranslateY(242);
        rooms.setGraphic(rms);
        rooms.setBorder(Border.EMPTY);
         Hyperlink userGuest = new Hyperlink();
        ImageView usrG = new ImageView(new Image(new FileInputStream("user_256.PNG")));
        userGuest.setGraphic(usrG);
        userGuest.setBorder(Border.EMPTY);
        userGuest.setTranslateX(20);
        userGuest.setTranslateY(320);
        Text gsts = new Text("Add guests");
        gsts.setFill(Color.WHITE);
        gsts.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        gsts.setTranslateX(65);
        gsts.setTranslateY(328);
        usrG.setFitHeight(30);
        usrG.setFitWidth(30);
        Circle greenCircle = new Circle();
        greenCircle.setFill(Color.GREEN);
        greenCircle.setRadius(6);
        greenCircle.setTranslateX(65);
        greenCircle.setTranslateY(100);
        Text online = new Text("Online");
        online.setFill(Color.WHITE);
        online.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
        online.setTranslateX(85);
        online.setTranslateY(98);
        Circle pfp = new Circle();
        pfp.setRadius(20);
        Image im = new Image("file:space_pfp.PNG");
        pfp.setFill(new ImagePattern(im));
        pfp.setStroke(Color.WHITE);
        pfp.setTranslateX(18);
        pfp.setTranslateY(70);
        Text RecptName = new Text("Mazen");
        RecptName.setFill(Color.WHITE);
        RecptName.setTranslateX(77);
        RecptName.setTranslateY(72);
         TextArea info=new TextArea();
         info.setMaxSize(500, 500);
       Button show=new Button("Show check out guests");
       show.setStyle("-fx-background-color: #0000FF; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        show.setMinSize(20, 30);  
        show.setTranslateX(500);        
        show.setTranslateY(500);
        info.setTranslateX(350);
        info.setTranslateY(70);

        show.setOnAction (new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
            try {
                String filename="CheckIn-CheckOutRecords.txt";
                Scanner input =new Scanner(new File(filename));
                while(input.hasNext()){
                    info.appendText(input.nextLine()+"\n");
                }
            }
            catch(IOException x){
                System.out.println("file can not open");
            }
        }
                });  
         
      
        RecptName.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20)); 
         pane.getChildren().addAll(info,show,sideRec, nameRec,AfterNameRec, HotelName, 
                booking,bk, bo,rms, rooms, roomsText,
                usrG, userGuest, gsts, pfp, RecptName,
                greenCircle, online); 
                  
        setRoot(pane);
     }
}

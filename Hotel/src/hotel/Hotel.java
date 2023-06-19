/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package hotel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;




public class Hotel extends Application {
    
static Stage mystage = new Stage();
    @Override
    public void start(Stage primaryStage) throws InterruptedException, FileNotFoundException {
      

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
      
        Text status = new Text("STATUS");
        status.setTranslateY(50);
        status.setTranslateX(15);
        Hyperlink rooms = new Hyperlink();
        ImageView rms = new ImageView(new Image(new FileInputStream("white_house.PNG")));
        rooms.setTranslateX(20);
        rooms.setTranslateY(235);
        rms.setFitHeight(30);
        rms.setFitWidth(30);
        Text roomsText = new Text("Show rooms");
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
        RecptName.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
         Rectangle ad1 = new Rectangle();
          ad1.setWidth(812);
          ad1.setHeight(562);
          ad1.setTranslateX(200);
          ad1.setTranslateY(50);
          ad1.setFill(Color.LIGHTGREY);
       Scene4 scene4 = new Scene4(new Pane(), 1000, 600);
        Scene5 scene5 = new Scene5(new Pane(), 1000, 600);
        Scene6 scene6 = new Scene6(new Pane(), 1000, 600);
        
         userGuest.setOnMouseClicked(e->{ 
             mystage.setScene(scene4);
             mystage.show();
         });
       rooms.setOnMouseClicked(e->{ 
             mystage.setScene(scene5);
             mystage.show();

         });
        booking.setOnMouseClicked(e->{ 
             mystage.setScene(scene6);
            mystage.show();

         });

        pane.getChildren().addAll(sideRec, nameRec,AfterNameRec, HotelName, 
                booking,bk, bo,rms, rooms, roomsText,
                usrG, userGuest, gsts, pfp, RecptName,
                greenCircle, online, ad1); 
                   

       mystage.setResizable(false);
      Scene3 scene1 = new Scene3(new Pane(), 1000,600);
       mystage.setScene(scene1);
       mystage.show();
    }
                
                
    public static void main(String[] args) {
        launch(args);
    }
    
}

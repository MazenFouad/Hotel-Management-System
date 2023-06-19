/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;
import static hotel.Hotel.mystage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import javafx.util.Callback;


public class Scene4 extends Scene{


    public Scene4(Parent parent, double d, double d1) throws InterruptedException, FileNotFoundException{
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
      
//        Text status = new Text("STATUS");
//        status.setTranslateY(50);
//        status.setTranslateX(15);
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
         TextField Fname = new TextField();
        Fname.setTranslateX(350);
        Fname.setTranslateY(100);
        Fname.setMaxSize(200, 20);
        Text fName = new Text("First Name: ");
        fName.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        fName.setTranslateX(250);
        fName.setTranslateY(103);
        TextField Lname = new TextField();
        Lname.setMaxSize(200, 20);
        Lname.setTranslateX(720);
        Lname.setTranslateY(100);    
        Text lName = new Text("Last Name: ");
        lName.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        lName.setTranslateX(620);
        lName.setTranslateY(103);
        TextField ID = new TextField();
        ID.setTranslateX(350);
        ID.setTranslateY(200);
        ID.setMaxSize(200, 20);
        Text Id = new Text("ID: ");
        Id.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        Id.setTranslateX(300);
        Id.setTranslateY(202); 
        TextField Address = new TextField();
        Address.setTranslateX(720);
        Address.setTranslateY(200);
        Address.setMaxSize(200, 20);
        Text address = new Text("Address: ");
        address.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        address.setTranslateX(640);
        address.setTranslateY(202); 
        TextField PhoneNum = new TextField();
        PhoneNum.setTranslateX(350);
        PhoneNum.setTranslateY(300);
        PhoneNum.setMaxSize(200, 20);
        Text phoneNum = new Text("Phone Number: ");
        phoneNum.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        phoneNum.setTranslateX(220);
        phoneNum.setTranslateY(302); 
        ObservableList options = FXCollections.observableArrayList(
                "Luxury",
                "Suit",
                "Deluxe");
        ComboBox Options = new ComboBox(options);
        Options.setTranslateX(720);
        Options.setTranslateY(300);
        Options.setMaxSize(200, 20);
        Text type = new Text("Room Type: ");
        type.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        type.setTranslateX(615);
        type.setTranslateY(302);
        DatePicker checkin = new DatePicker();
        DatePicker checkout = new DatePicker();
         checkin.valueProperty().addListener((ov, oldValue, newValue)->{
         checkout.setValue(newValue.plusDays(2));
         });
        checkout.setTranslateX(720);
        checkout.setTranslateY(400);
        
        checkin.setTranslateX(350);
        checkin.setTranslateY(400);
        
        Text date = new Text("Check-in:");
        date.setTranslateX(265);
        date.setTranslateY(402);
        date.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        Text date2 = new Text("Check-out:");
        date2.setTranslateX(620);
        date2.setTranslateY(402);
        date2.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        TextField RoomNum = new TextField();
        RoomNum.setTranslateX(350);
        RoomNum.setTranslateY(500);
        RoomNum.setMaxSize(200, 20);
        Text RoomNo = new Text ("Room No.:");
        RoomNo.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        RoomNo.setTranslateX(255);
        RoomNo.setTranslateY(502); 
        Button Save = new Button("Save");
        Save.setStyle("-fx-background-color: #0000FF; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        Save.setMinSize(200, 30);  
        Save.setTranslateX(720);        
        Save.setTranslateY(500);
        
         final Callback<DatePicker, DateCell> dayCellFactory = 
            (final DatePicker datePicker) -> new DateCell() {
                @Override
                public void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item.isBefore(
                            checkin.getValue().plusDays(1))
                            ) {
                        setDisable(true);
                        setStyle("-fx-background-color: #ffc0cb;");
                    }
                    long p = ChronoUnit.DAYS.between(
                            checkin.getValue(), item
                    );
                    setTooltip(new Tooltip(
                            "You're about to stay for " + p + " days")
                    );
                }
            };
      // long p = ChronoUnit.DAYS.between(checkin.getValue(), checkout.getValue());
        checkout.setDayCellFactory(dayCellFactory);
        checkout.setValue(checkin.getValue());
        Save.setOnMouseClicked(e->{
        String FNAME = Fname.getText();
        String LNAME = Lname.getText();
        String ADDRESS = Address.getText();
        String IDD = ID.getText();
        String PhoneN = PhoneNum.getText();
        String Roomtype = Options.getValue().toString();
      
//        String CHECKIN =  checkin.getValue().toString();
//        String CHECKOUT = checkout.getValue().toString();
        String ROOMNUM = RoomNum.getText();
        int roomNm = Integer.parseInt(ROOMNUM);
        Guest g = new Guest(FNAME, LNAME, IDD, ADDRESS, PhoneN);
       Rooms r = new Rooms(g, Roomtype, roomNm, 2,100);
       if(g.checkRoomStatus(roomNm)==true)
       {
           Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.setHeaderText(null);
           alert.setContentText("Room already Booked");
           alert.show();
       }
       else{
       g.reservation(r);
      
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setHeaderText(null);
           alert.setContentText("Saved Successfully!");
           alert.show();
       } 
       g.saveTheGuestRecord();
        });
        
        pane.getChildren().addAll(sideRec, nameRec,AfterNameRec, HotelName, 
                booking,bk, bo,rms, rooms, roomsText,
                usrG, userGuest, gsts, pfp, RecptName,
                greenCircle, online, Fname, fName,
               Lname, lName,ID, Id, Address, address,
               PhoneNum,phoneNum, Options, type, date,
               checkin, checkout, date2, Save, RoomNum,
               RoomNo); 
                  
        setRoot(pane);
      }
}









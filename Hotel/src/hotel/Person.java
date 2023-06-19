/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 *
 * @author THE LAPTOP SHOP
 */
public abstract class Person implements PersonInterface {

   
    protected String firstName;                 
    protected String lastName;                 
    protected String identificationNumber;      
    protected String address;                   
    protected String phoneNumber;               


   
    protected ArrayList<Rooms> roomList = new ArrayList<>();
    
   
    @Override
    public String getPersonFirstName()
    {
        return firstName;
    }
    @Override
    public String getPersonLastName()
    {
        return lastName;
    }
    public void showReservedRooms()
    {
        for (int i = 0; i < roomList.size(); i++)
        {
            System.out.println(roomList.get(i).toString());
        }
    }
    public String getRoomDetail(int roomNo)
    {
        String roomDetail;
        for(int i=0; i<roomList.size(); ++i)
        {
            if (roomList.get(i).getRoomNo() == roomNo)
            {
                roomDetail = roomList.get(i).toString();
                return roomDetail;
            }
        }
        return null;
    }
    public void saveTheGuestRecord()
    {
        String filePath = "GuestReservations.txt";

        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            try (PrintWriter pw = new PrintWriter(bw)) {
                
                for (int i = 0; i < roomList.size(); i++)
                {
                    pw.println(roomList.get(i).toString());
                }
                
                pw.flush();
            }
        } catch(IOException E){
            System.out.println("Exception Caught : " + E);
        }
    }


  
    public boolean reservation(Rooms roomObject)
    {
        this.roomList.add(roomObject);
        roomList.add(roomObject);
        return true;
    }

   
    public boolean cancelReservation(int roomNo) throws Exception
    {
        try {
            if (roomList.isEmpty()) {
                throw new Exception("Room list is already empty !!");
            }
        } catch (Exception E) {
            System.out.println("An Exception Caught : " + E);
        }
        for(int i=0; i<roomList.size(); ++i)
        {
            if (roomList.get(i).getRoomNo() == roomNo)
            {
                this.roomList.remove(i);
                roomList.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean checkRoomStatus(int roomNo)
    {
        for (int i = 0; i < roomList.size(); i++)
        {
            if (roomList.get(i).getRoomNo() == roomNo)
            {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString()
    {
        return String.format("%s,%s", getPersonFirstName(), getPersonLastName());
    }
}
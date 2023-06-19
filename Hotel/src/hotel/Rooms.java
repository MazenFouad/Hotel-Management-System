 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;


public class Rooms {
    
 private String roomType;
    private int roomNo;
    private int roomPrice;
    private int nightStay;
    private PersonInterface personObject;

    public Rooms(PersonInterface personObject, String roomType, int roomNo, int nightStay, int roomPrice)
    {
        this.personObject = personObject;
        this.roomType=roomType;
        this.roomNo=roomNo;
        this.roomPrice=roomPrice;
        this.nightStay=nightStay;
    }

   
    public PersonInterface getPersonObject()
    {
        return personObject;
    }

    public String getRoomType()
    {
        return roomType;
    }

   
    public int getRoomNo()
    {
        return roomNo;
    }

    
    public int getRoomPrice()
    {
        return roomPrice;
    }

   
    public int getNightStay()
    {
        return nightStay;
    }

    
    @Override
    public String toString()
    {
        return String.format("%s,%s,%d,%d,%d,",getPersonObject().toString(),getRoomType(),getRoomNo(),getNightStay(),getRoomPrice());
    }


}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author THE LAPTOP SHOP
 */
public class Guest extends Person {
    
      private String IdentificationNumber;
    private String address;
    private String phoneNumber;
  
    private ArrayList<Person> hotelGuests = new ArrayList<>();

    final String header = " Name, Surname, Identification Number, Address, Phone Number, Room Type, Room No, Night Stay, Room Price ( $ )";


    public Guest()
    {
        this.firstName="";
        this.lastName="";
    }
    
    public Guest(String name, String surname, String ID, String contactAddress,
                 String phone)
    {
        this.firstName = name;
        this.lastName =  surname;
        setContactInfo(ID,contactAddress,phone);
    }
    
    public void setContactInfo(String ID,String contactAddress, String phone)
    {
        IdentificationNumber = ID;
        address = contactAddress;
        phoneNumber = phone;
    }
    
    public String getIdentificationNumber()
    {
        return IdentificationNumber;
    }
    
    public String getAddress()
    {
        return address;
    }
   
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
   
   
    public void showHotelGuests()
    {
        for (int i = 0; i < hotelGuests.size(); i++)
        {
            System.out.println(hotelGuests.get(i).toString());
        }
    }
   
    public String getRoomDetailToGuest(String guestSurname)
    {
        for(int i=0; i<roomList.size(); ++i)
        {
            if (roomList.get(i).getPersonObject().getPersonLastName().equals(guestSurname))
            {
             
                return  roomList.get(i).toString();
            }
        }
        return null;
    }
   
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s",super.toString(),getIdentificationNumber(),getAddress(),
                getPhoneNumber());
    }
   
    @Override
    public void personOperations() throws Exception
    {
        try {
                int operationChoice;
                String firstName, lastName, identificationNumber, address, phoneNumber;
                String roomType;
                int roomNo, nightStay, roomPrice;
                Scanner input = new Scanner(System.in);
                Guest g2 = new Guest( "Deniz", "Kahraman",
                        "34981247901",
                        "Trabzon", "05422135401");
                Rooms newRoomReservation2 = new Rooms(g2, "Deluxe",
                        3333, 2, 100);
                Guest g3 = new Guest( "Bilge Simay", "Eroğlu",
                    "54891497628",
                    "Istanbul", "05341234567");
                Rooms newRoomReservation3 = new Rooms(g3, "Suit",
                        2222, 5, 200);
                reservation(newRoomReservation2);
                reservation(newRoomReservation3);
                // showReservedRooms();
                hotelGuests.add(g2);
                hotelGuests.add(g3);
                // showHotelGuests();
                System.out.println("Enter 1 to Reservation");
                System.out.println("Enter 2 to Reservation Cancellation");
                operationChoice = input.nextInt();
                if (operationChoice == 1)
                {
                    System.out.println("What is your name ?");
                    firstName = input.next();
                    System.out.println("What is your surname ?");
                    lastName = input.next();
                    System.out.println("What is your identification number ?");
                    identificationNumber = input.next();
                    System.out.println("What is your contact address ?");
                    address = input.next();
                    System.out.println("What is your phone number ?");
                    phoneNumber = input.next();
                    
                    Guest g1 = new Guest(firstName, lastName,
                            identificationNumber, address, phoneNumber);
                    System.out.println("\n> Select your room type < \n- Luxury\n- Suit\n- Deluxe\n ");
                    roomType = input.next();
                    System.out.println("\n> Enter your room no <\n- Luxury - 1111\n- Suit -   2222\n- Deluxe - 3333\n");
                    roomNo = input.nextInt();
                    if(checkRoomStatus(roomNo)==true)
                    {
                        System.out.println("The room is already reserved !!");
                        System.out.println("\n> Enter your room no <\n- Luxury - 1111\n- Suit - 2222\n- Deluxe - 3333\n");
                        roomNo = input.nextInt();
                    }
                    System.out.println("\n> Enter your the night stay <");
                    nightStay = input.nextInt();
                    System.out.println("> Enter the room price ( $ ) <\n- Luxury - 300\n- Suit   - 200\n- Deluxe - 100\n");
                    roomPrice = input.nextInt();
                    Rooms newRoomReservation1 = new Rooms(g1, roomType, roomNo, nightStay, roomPrice);
                    if (true == reservation(newRoomReservation1))
                    {
                        System.out.println("\nYour reservation operation is successful !!\n");
                        System.out.println("**** Your reservation detail ****");
                        System.out.println(header);
                        System.out.println(Constants.RECORD_LIST_HEADER);
                        System.out.println(getRoomDetail(roomNo));
                    }
                }
                if (operationChoice == 2)
                {
                    System.out.println("Enter your surname ");
                    lastName = input.next();

                    System.out.printf("\n%s\n", header);
                    System.out.printf("\n%s\n", Constants.RECORD_LIST_HEADER);
                    System.out.println(getRoomDetailToGuest(lastName));

                    System.out.println("\nEnter your room number ");
                    roomNo = input.nextInt();
                    if (true == cancelReservation(roomNo))
                    {
                        System.out.println("Reservation cancelling operation is successful !!");
                    }
                    else
                    {
                        System.out.println("Invalid Room No !!");
                    }
                }
            saveTheGuestRecord();   
        } catch (Exception E)
        {
            System.out.println("An Exception Caught: " + E);
        }
    }

   
}


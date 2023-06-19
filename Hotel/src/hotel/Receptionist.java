/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.io.*;

public class Receptionist extends Person{
  final String header = Constants.RECORD_LIST_HEADER;
    private String identificationNumber;      
    private String address;                   
    private String phoneNumber;               
    private String username,password;
    File f = new File("login.txt");
    public Receptionist()
    {
        this.firstName="";
        this.lastName="";
    }

    
    public Receptionist(String firstName, String lastName)
    {
        this.firstName=firstName;
        this.lastName=lastName;
    }
    
       
   
    public void saveTheRecords(String header,int roomNo)
    {

        try {
            FileWriter fw = new FileWriter(Constants.CHECK_IN_CHECK_OUT_LIST_FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(fw);
            try (PrintWriter pw = new PrintWriter(bw)) {
                pw.println(header);
                
                pw.print(getRoomDetail(roomNo));
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                pw.println(dateFormat.format(date));
                
                pw.flush();
            }

        } catch(IOException E){
            System.out.println("Exception Caught : " + E);
        }
    }
   
   
    public boolean checkData(String usr, String psw) throws IOException, ClassNotFoundException
    {
     Map<String, String> mp = new TreeMap<>();
     if(f.createNewFile())
     {
         System.out.println("File created "+ f.getName());
     }
     if(f.exists())
     {
         ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
         mp = (Map<String, String>) ois.readObject();
         mp.putIfAbsent(usr, psw);
         ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(f));
         for(Map.Entry<String, String> entry : mp.entrySet())
         {
             ous.writeObject(mp);
             ous.flush();
         }
         ous.close();
         return true;
     }
     return false;
    }
     public boolean LogIN(String usr, String psw) throws FileNotFoundException, IOException, ClassNotFoundException
     {
           Map<String, String> mp = new TreeMap<>();
     
     if(f.exists())
     {
         ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
         mp = (Map<String, String>) ois.readObject();      
         if(mp.containsKey(usr))
         {
             String stor = mp.get(usr);
             if(stor.equals(psw))
                 return true;
         }
         
     }
      return false;
    }
  @Override
    public void showReservedRooms()
    {
        for (int i = 0; i < roomList.size(); i++)
        {
            System.out.println(roomList.get(i).toString());
        }
    }

   
  @Override
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

  
  @Override
    public void saveTheGuestRecord()
    {

        try {
            FileWriter fw = new FileWriter(Constants.GUEST_RECORD_LIST_FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(fw);
            try (PrintWriter pw = new PrintWriter(bw)) {
                pw.println(Constants.RECORD_LIST_HEADER);
                
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


    
    public boolean checkOutOperation()
    {
        int roomNo;
        Scanner input = new Scanner(System.in);

        System.out.println("\n*** Reserved Rooms In the Hotel *** \n");
        System.out.println(header);
        showReservedRooms();

        System.out.println("\n> Enter the room no :");
        roomNo = input.nextInt();

        if (checkRoomStatus(roomNo) == true)
        {
            System.out.println("\nCheck-Out operation is succesfull !!\n");
            System.out.println(header+", Check-Out Date");

            System.out.print(getRoomDetail(roomNo));
            getDate();

            saveTheRecords(header+", Check-Out Date",roomNo);
            return true;
        }

        else {
            System.out.println("Check-out operation is not successfull !");
            return  false;
        }
    }

   
    public void getDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }

    
    public boolean checkInOperation()
    {
        int roomNo;
        Scanner input = new Scanner(System.in);

        System.out.println("\n*** Reserved Rooms In the Hotel *** \n");
        System.out.println(header);
        showReservedRooms();

        System.out.println("\n> Enter the room no :");
        roomNo = input.nextInt();
        if(checkRoomStatus(roomNo)==true)
        {
            System.out.println("\nCheck-in operation is succesfull !!\n");
            System.out.println(header+", Check-in Date");

            System.out.print(getRoomDetail(roomNo));
            getDate();

            saveTheRecords(header+", Check-in Date", roomNo);
            return true;

        }
        else {
            System.out.println("Check-in operation is not successfull !");
            return false;
        }
    }


   
    public Rooms newRoomObject()
    {

        String roomType;
        int roomNo,nightStay,roomPrice;

        Scanner input = new Scanner(System.in);

        System.out.println("What is the guest name ?");
        firstName = input.next();

        System.out.println("What is the guest surname ?");
        lastName = input.next();

        System.out.println("What is the guest identification number ?");
        identificationNumber = input.next();

        System.out.println("What is the guest contact address ?");
        address = input.next();

        System.out.println("What is the guest phone number ?");
        phoneNumber = input.next();

        

        Guest g1 = new Guest(firstName,lastName,
                identificationNumber,address,phoneNumber);

        System.out.println("\n> Select the room type \n- Luxury\n- Suit\n- Deluxe\n ");
        roomType = input.next();
        System.out.println("\n> Enter the room no\n- Luxury - 1111\n- Suit -   2222\n- Deluxe - 3333\n");
        roomNo = input.nextInt();

        if(checkRoomStatus(roomNo)==true)
        {
            System.out.println("The room is already reserved !!");
            System.out.println("\n> Enter the guest room no <\n- Luxury - 1111\n- Suit - 2222\n- Deluxe - 3333\n");
            roomNo = input.nextInt();
        }

        System.out.println("Enter the night stay");
        nightStay=input.nextInt();
        System.out.println("Enter the room price ( $ )\n- Luxury - 300\n- Suit -   200\n- Deluxe - 100\n");
        roomPrice=input.nextInt();

        return new Rooms(g1,roomType,roomNo,nightStay,roomPrice);
    }


   
    @Override
    public void personOperations() throws Exception
    {
        try {

            int operationChoice,roomNo;

            Scanner input = new Scanner(System.in);

            Guest g2 = new Guest( "Arda Can", "Doğan",
                    "12345678904",
                    "Kocaeli", "05347654321" );

            Rooms newRoomReservation2 = new Rooms(g2,"Deluxe",
                    3333, 2, 100);

            Guest g3 = new Guest( "Duru İklim", "Hasoğlu",
                    "41234567899",
                    "Antalya", "05344654020");


            Rooms newRoomReservation3 = new Rooms(g3,"Suit",
                    2222, 5, 200);

            reservation(newRoomReservation2);   // Other guest reservation operations
            reservation(newRoomReservation3);

            System.out.println("*** Receptionist Operations ***\nEnter 1 to Reservation");
            System.out.println("Enter 2 to Reservation Cancellation");
            System.out.println("Enter 3 to Check-In");
            System.out.println("Enter 4 to Check-Out");

            operationChoice = input.nextInt();

            switch (operationChoice) {
                case 1: {
                    if (true == reservation(newRoomObject()))
                    {
                        System.out.println("\nYour reservation operation is successful !!\n");
                        saveTheGuestRecord();
                        showReservedRooms();    // Show the updated reserved rooms details
                    }
                }
                case 2: {
                    System.out.println("\n*** Reserved Rooms In the Hotel *** \n");
                    System.out.println(header);
                    showReservedRooms();
                    System.out.println("\nEnter guest room no");
                    roomNo = input.nextInt();
                    if (true == cancelReservation(roomNo))
                    {
                        cancelReservation(roomNo);
                        System.out.println("Reservation cancelling operation is successful !!");
                        System.out.println("\n*** Updated Reserved Rooms In the Hotel ** \n");
                        System.out.println(header);
                        showReservedRooms();    // Show the reserved rooms details
                        saveTheGuestRecord();   // Save the updated rooms details
                    }
                    else
                    {
                        System.out.println("Invalid Room No !!");
                    }
                }
                case 3 :checkInOperation();
                case 4 : checkOutOperation();
                default : System.out.println("Wrong operation choice !!");
            }


        } catch (Exception E)
        {
            System.out.println(">>>>> An Exception Caught: " + E);
        }

    }

    

}
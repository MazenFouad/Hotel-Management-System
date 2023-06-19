/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package hotel;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author THE LAPTOP SHOP
 */
public class MainP {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
       Receptionist rec = new Receptionist();
       rec.checkData("alex", "abc223");
        
     try {

            String whichPerson;
            Scanner input = new Scanner(System.in);

            System.out.println("\n*** Welcome the Hotel ISTANBUL ***");
            System.out.println("Are you a guest ?\n Y/y or N/n");

            whichPerson = input.next(); 
       
         switch (whichPerson) {
             case "y": {
                 Person personObject = new Guest();          
                 personObject.personOperations();
             }
             case "n": {
                 Person personObject = new Receptionist();  
                 personObject.personOperations();
                 }
             default : System.out.println("Invalid Choice !");
         }
        
         
        } catch(Exception E){

            System.out.println("An Exception Caught : " + E);
        }

  }
}
 
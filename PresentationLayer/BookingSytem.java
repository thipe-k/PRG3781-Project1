package PresentationLayer;
import java.util.Scanner;


public class BookingSytem {
   public static void main(String[] args) {
      System.out.println("Welcome to Catering Online Booking System");
      System.out.println("Please select one of the following:");
      System.out.println("1 : I am client");
      System.out.println("2 : I am admin");
      System.out.print("Enter value : ");
       ;
      int selection = new Scanner(System.in).nextInt();
      
      if( selection == 1)
      {
         CleintMenu menu = new CleintMenu();
         menu.mainMenu();
      }
      else if (selection == 2)
      {
         AdminMenu menu = new AdminMenu();
         menu.showBookings();
      }
      

   }
}

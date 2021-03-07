package PresentationLayer;
import ApplicationLayer.*;
import java.util.Scanner;
public class AdminMenu {

   Scanner input;

   public AdminMenu() {
      input = new Scanner(System.in);
   }

   public void displayManu()
   {
      NotificationController notificationController = new NotificationController();
      System.out.println("Admin Menu");
      System.out.println("1 : View All Bookings");
      System.out.println("2 : Confirmed Bookings");
      System.out.println("3 : Notifications -- "+ notificationController.getUnreadNotifications());
      System.out.print("Enter value : ");
   }
   public void mainMenu()
   {
      displayManu();
      String choice = input.nextLine();
      switch (choice) {
         case "1":
            showBookings();
            break;
         case "2":
            showConfirmedBookings();
            break;   
         case "3":
            NotificationController notificationController = new NotificationController();
            System.out.println("Select Notifications");
            System.out.println("1 - All");
            System.out.println("2 - Read");
            System.out.println("3 - Unread");
            System.out.print("Select value : ");
            String cc = input.nextLine();
            switch (cc) {
               case "1":
                  System.out.println("All Notifications");
                  for (Notification notification : notificationController.getNotifications().getNotifications()) {
                     System.out.println(notification.toString());
                  }
                  break;
               case "2":
                  System.out.println("Read Notifications");
                  for (Notification notification : notificationController.getNotifications().getNotifications()) {
                     if(notification.getIsRead())
                     {
                        System.out.println(notification.toString());
                     }
                  }
                  break;   
               case "3":
               System.out.println("Unread Notifications");
               for (Notification notification : notificationController.getNotifications().getNotifications()) {
                  if(!notification.getIsRead())
                  {
                     System.out.println(notification.toString());
                  }
                  notificationController.markAllAsRead();
               }
            break;   
         default:
            break;
            }
      }

   }

   public void showBookings()
   {
      // this is just for testing, wanted to see if i can retrive data from files
      Operations ops =  new Operations();
      System.out.println("----------    Bookings----------------");
      for (Booking booking : ops.getBookings()) {
         System.out.println("____________Booking Number : "+booking.getBookingNum()+" ____________");
         System.out.println("Status   : " + booking.getStatus());
         System.out.println("Client   : "+booking.getClient().getDetails());
         System.out.println("Contact  : " + booking.getClient().getContactDetails());
         System.out.println("Event    : "+booking.getEvent().getType() + " on "+booking.getEvent().getDateOfEvente().toLocaleString() );
         System.out.println("Attendess: Adult - "+ booking.getEvent().getAdultAttendee() + " , Kids - "+ booking.getEvent().getMinorAddendee() );
         System.out.println("---------------------------------------------------------------------");
         System.out.println();
      }
      
   }

   
   public void showConfirmedBookings()
   {
      // this is just for testing, wanted to see if i can retrive data from files
      Operations ops =  new Operations();
      System.out.println("----------    Bookings----------------");
      for (Booking booking : ops.getBookings()) {
       if(booking.getIsConfirmed())
       {
         System.out.println("____________Booking Number : "+booking.getBookingNum()+" ____________");
         System.out.println("Status   : " + booking.getStatus());
         System.out.println("Client   : "+booking.getClient().getDetails());
         System.out.println("Contact  : " + booking.getClient().getContactDetails());
         System.out.println("Event    : "+booking.getEvent().getType() + " on "+booking.getEvent().getDateOfEvente().toLocaleString() );
         System.out.println("Attendess: Adult - "+ booking.getEvent().getAdultAttendee() + " , Kids - "+ booking.getEvent().getMinorAddendee() );
         System.out.println("---------------------------------------------------------------------");
         System.out.println();
       }
      }
   }
}

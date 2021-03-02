package PresentationLayer;
import ApplicationLayer.*;
public class AdminMenu {
   public void showBookings()
   {
      // this is just for testing, wanted to see if i can retrive data from files
      Operations ops =  new Operations();
      for (Booking booking : ops.getBookings()) {
         System.out.println("---------------------------------");
         System.out.println(booking.getClient().toString());
         System.out.println(booking.getEvent().toString());
         System.out.println("------------------------------------");
         System.out.println();System.out.println();
      }
   }
}

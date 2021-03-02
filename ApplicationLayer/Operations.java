package ApplicationLayer;

import java.util.Vector;
import DataAccessLayer.FileHandler;

public class Operations {
   public void bookEvent(Booking booking)
   {
      FileHandler fileHandler = new FileHandler();
      fileHandler.serializeToFile(booking, booking.getBookingNum());
   }
   public Vector<Booking> getBookings()
   {
      FileHandler fileHandler = new FileHandler();
      Vector<Booking> data = new Vector<Booking>();
      for (Object booking : fileHandler.getSerializedData()) {
         data.add((Booking)booking);
      }
      return data;
   }
   
}

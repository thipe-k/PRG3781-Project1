package ApplicationLayer;

import java.util.Vector;
import DataAccessLayer.FileHandler;
import java.text.SimpleDateFormat;
import java.util.Date;

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

   public boolean checkDate(Date date)
   {
      boolean dateExist = false;
      for (Booking booking : getBookings()) {
         if (date.toGMTString().equalsIgnoreCase(booking.getEvent().getDateOfEvente().toGMTString()) )
         {
            dateExist = true;
         }
      }
      return dateExist;
   }

   public Booking getBooking (String bookingNumber)
   {
      Booking booking = null;
      FileHandler fileHandler = new FileHandler();
      for (Object tempBooking : fileHandler.getSerializedData()) {
             Booking temp = (Booking)tempBooking;
             if(temp.getBookingNum().equalsIgnoreCase(bookingNumber))
             {
                booking = temp;
                break;
             }
      }
      return booking;
   }

   
}

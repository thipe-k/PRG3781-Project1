package ApplicationLayer;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {
   private static final long serialVersionUID = 17L;

   private String bookingNumber;
   private boolean isRead;
   private Date date;
   private String message;


   public String getBookingNumber() {
      return this.bookingNumber;
   }

   public void setBookingNumber(String bookingNumber) {
      this.bookingNumber = bookingNumber;
   }

   public boolean isIsRead() {
      return this.isRead;
   }

   public boolean getIsRead() {
      return this.isRead;
   }

   public void setIsRead(boolean isRead) {
      this.isRead = isRead;
   }

   public Date getDate() {
      return this.date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public String getMessage() {
      return this.message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public Notification(String bookingNumber, String message) {
      this.bookingNumber = bookingNumber;
      this.isRead = false;
      this.date = new Date(new Date().getTime());
      this.message = message;
   }


   @Override
   public String toString() {
      String read = (isRead) ? "Read" : "Not Read";
      return "Booking Number : "+ bookingNumber + ", message : "+ message + "Confirmed on : "+ date.toLocaleString() + " Status : " + read;
   }
   
}

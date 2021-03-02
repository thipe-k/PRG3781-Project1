package ApplicationLayer;
import java.io.Serializable;
import java.util.Date;
import ApplicationLayer.EventPackage.*;
import DataAccessLayer.FileHandler;

public class Booking implements Serializable {
   private static final long serialVersionUID = 1L;
   private String bookingNumber;
   private Event event;
   private boolean isConfirmed;
   private String bookingNum;
   private Date dateOfConfirmation;
   private Client client;
   private Payment payment;
   private Decoration decoration;

   public Event getEvent() {
      return this.event;
   }

   public void setEvent(Event event) {
      this.event = event;
   }

   public boolean isIsConfirmed() {
      return this.isConfirmed;
   }

   public boolean getIsConfirmed() {
      return this.isConfirmed;
   }

   public void setIsConfirmed(boolean isConfirmed) {
      this.isConfirmed = isConfirmed;
   }

   public String getBookingNum() {
      return this.bookingNum;
   }

   public void setBookingNum(String bookingNum) {
      this.bookingNum = bookingNum;
   }

   public Date getDateOfConfirmation() {
      return this.dateOfConfirmation;
   }

   public void setDateOfConfirmation(Date dateOfConfirmation) {
      this.dateOfConfirmation = dateOfConfirmation;
   }

   public Client getClient() {
      return this.client;
   }

   public void setClient(Client client) {
      this.client = client;
   }

   public Payment getPayment() {
     return this.payment;
   }

   public void setPayment(Payment payment) {
     this.payment = payment;
   }

   public Decoration getDecoration() {
      return this.decoration;
   }

   public void setDecoration(Decoration decoration) {
      this.decoration = decoration;
   }

   public Booking(Event event, Client client) {
      this.event = event;
      this.client = client;
      this.isConfirmed = false;
      this.payment = new Payment();
      FileHandler fileHandler = new FileHandler();
      bookingNum = fileHandler.getBookingNumber();
   }
   public String getBookingNumber() {
      return this.bookingNumber;
   }

}

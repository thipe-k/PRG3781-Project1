package ApplicationLayer;
import java.util.Date;
import ApplicationLayer.EventPackage.*;

public class Booking {
   private IEvent event;
   private boolean isConfirmed;
   private String bookingNum;
   private Date dateOfConfirmation;
   private Client client;
   private Payment payment;
   private Decoration decoration;

   public IEvent getEvent() {
      return this.event;
   }

   public void setEvent(IEvent event) {
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

   public Booking(IEvent event, Client client) {
      this.event = event;
      this.client = client;
      this.isConfirmed = false;
   }
   

}

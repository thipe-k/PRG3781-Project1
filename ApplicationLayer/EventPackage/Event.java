package ApplicationLayer.EventPackage;

import java.io.Serializable;
import java.util.Date;

public abstract class Event implements Serializable {

   private static final long serialVersionUID = 2L;
   protected String location;
   protected Date dateOfEvente;
   protected short adultAttendee;
   protected short minorAddendee;

   public void setValues(String location, Date dateOfEvente, short adultAttendee, short minorAddendee) {
      this.location = location;
      this.dateOfEvente = dateOfEvente;
      this.adultAttendee = adultAttendee;
      this.minorAddendee = minorAddendee;
   }
   
   public String getLocation() {
      return this.location;
   }

   public void setLocation(String location) {
      this.location = location;
   }

   public Date getDateOfEvente() {
      return this.dateOfEvente;
   }

   public void setDateOfEvente(Date dateOfEvente) {
      this.dateOfEvente = dateOfEvente;
   }

   public short getAdultAttendee() {
      return this.adultAttendee;
   }

   public void setAdultAttendee(short adultAttendee) {
      this.adultAttendee = adultAttendee;
   }

   public short getMinorAddendee() {
      return this.minorAddendee;
   }

   public void setMinorAddendee(short minorAddendee) {
      this.minorAddendee = minorAddendee;
   }
   public abstract String getType();

   @Override
   public String toString() {
      return "" + getType() + "|" +
         "" + getLocation() + "|" +
         "" + getDateOfEvente() + "|" +
         "" + getAdultAttendee() + "|" +
         "" + getMinorAddendee();
   }

}

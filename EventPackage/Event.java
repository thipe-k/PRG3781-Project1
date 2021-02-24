package EventPackage;

import java.util.Date;

public abstract class Event {
   protected String location;
   protected Date dateOfEvente;
   protected short adultAttendee;
   protected short minorAddendee;

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

}

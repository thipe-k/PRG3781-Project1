package ApplicationLayer;

import java.io.Serializable;

public class Client implements Serializable {

   private static final long serialVersionUID = 3L;
   private String firstName;
   private String lastName;
   private String cellNumber;
   private String email;

   public String getFirstName() {
      return this.firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return this.lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getCellNumber() {
      return this.cellNumber;
   }

   public void setCellNumber(String cellNumber) {
      this.cellNumber = cellNumber;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String email) {
      this.email = email;
   }


   public Client(String firstName, String lastName, String cellNumber, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.cellNumber = cellNumber;
      this.email = email;
   }

   @Override
   public String toString() {
      return 
         "" + getFirstName() + "|" +
         "" + getLastName() + "|" +
         "" + getCellNumber() + "|" +
         "" + getEmail();
   }


}

package ApplicationLayer.EventPackage;

public class BirthDayEvent extends Event {
  

   /**
    *
    */
   private static final long serialVersionUID = 12L;

   @Override
   public String getType() {
      return "Birth Day";
   }
}

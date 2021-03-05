package ApplicationLayer.EventPackage;

public class YearEndFunctionEvent extends Event  {
  
 
   /**
    *
    */
   private static final long serialVersionUID = 14L;

   @Override
   public String getType()  {
      return "Year End Function Event";
   }
}
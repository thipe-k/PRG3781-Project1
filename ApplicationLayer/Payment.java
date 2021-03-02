package ApplicationLayer;

import java.io.Serializable;

import ApplicationLayer.EventPackage.Event;
import ApplicationLayer.FoodPackage.IFood;

public class Payment implements Serializable{
 
   private static final long serialVersionUID = 4L;
   private boolean isPayed;

   public boolean isIsPayed() {
      return this.isPayed;
   }

   public boolean getIsPayed() {
      return this.isPayed;
   }

   public void setIsPayed(boolean isPayed) {
      this.isPayed = isPayed;
   }

   public Payment() {
      isPayed = false;
   }

   public double calculateDiscount( Event event , IFood food )
   {
      return 0;
   }
   public double calculateTotal(Event event , IFood food)
   {
      return 0;
   }
   public double calculateDiscount( Event event , IFood food, Decoration decoration )
   {
      return 0;
   }
   public double calculateTotal(Event event , IFood food ,  Decoration decoration) 
   {
      return 0;
   }
   
}

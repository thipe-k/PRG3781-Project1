package ApplicationLayer;

import java.io.Serializable;

import ApplicationLayer.EventPackage.Event;
import ApplicationLayer.FoodPackage.IFood;
import java.util.List;

public class Payment implements Serializable{
 
   private static final long serialVersionUID = 4L;
   private boolean isPayed;
   private double payedAmount;

   public double getPayedAmount() {
      return this.payedAmount;
   }

   public void setPayedAmount(double payedAmount) {
     
      this.payedAmount = payedAmount;
      isPayed = (payedAmount > 0) ? true : false;
   }

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
      payedAmount = 0;
   }

   public double calculateDiscount( Event event , List<String[]> eventFoods )
   {  double discount = 0;
      double total=( Double.parseDouble(eventFoods .get(0)[1])*event.getAdultAttendee())+( Double.parseDouble(eventFoods .get(0)[1])*event.getAdultAttendee());
      if((event.getAdultAttendee()+event.getMinorAddendee()>40)){
         discount = total*0.15;
      }
      return discount;
   }
   public double calculateTotal(Event event , IFood food)
   {
      return 0;
   }
   public double calculateDiscount( Event event , IFood food, Decoration decoration )
   {
      return 0;
   }
   public double calculateTotal(Event event , List<String[]> eventFoods , double discount) 
   {
      double total=( Double.parseDouble(eventFoods .get(0)[1])*event.getAdultAttendee())+( Double.parseDouble(eventFoods .get(0)[1])*event.getAdultAttendee());
      total-=discount ;
      return total;
   }

   
}

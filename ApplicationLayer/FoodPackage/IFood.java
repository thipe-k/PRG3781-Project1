package ApplicationLayer.FoodPackage;

import java.util.List;

import ApplicationLayer.EventPackage.Event;


public interface IFood {
   public double getPrice(List<String[]>data,Event event);
   public List<String[]> getAdultMeal();
   public List<String[]> getMinorMeal();
   
}

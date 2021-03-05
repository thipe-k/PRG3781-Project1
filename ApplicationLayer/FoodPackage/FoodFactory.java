package ApplicationLayer.FoodPackage;

import ApplicationLayer.Utility.*;






public class FoodFactory {
    public IFood getfood(DefaultEvents event)
   {
      switch (event) {
         case WEDDINGEVENT:
            return new WeddingFood();
         case YEARENDFUNCTIONEVENT:
            return new BirthdayFood();
         case BABTISMEVENT:
            return new PartyFood();
         case BIRTHDAYEVENT:
            return new BirthdayFood();
            
         default:
            return null;
      }
   }




}

package ApplicationLayer.Utility;

public enum DefaultEvents{
   WEDDINGEVENT,
   BIRTHDAYEVENT,
   YEARENDFUNCTIONEVENT,
   BABTISMEVENT;
   
   public static DefaultEvents getById(int id)
   {
      switch (id) {
         case 1:
            return DefaultEvents.WEDDINGEVENT;
         case 2:
            return DefaultEvents.BIRTHDAYEVENT;  
         case 3:
            return DefaultEvents.YEARENDFUNCTIONEVENT;   
         case 4:
            return DefaultEvents.BABTISMEVENT;                                 
         default:
            return null;
      }
   }  
}
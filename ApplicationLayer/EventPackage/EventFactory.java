package ApplicationLayer.EventPackage;
import ApplicationLayer.Utility.*;
public class EventFactory {
   public Event getEvent(DefaultEvents event)
   {
      switch (event) {
         case WEDDINGEVENT:
            return new WeddingEvent();
         case YEARENDFUNCTIONEVENT:
            return new YearEndFunctionEvent();
         case BABTISMEVENT:
            return new BabtismEvent();
         case BIRTHDAYEVENT:
            return new BirthDayEvent();
            
         default:
            return null;
      }
   }
}

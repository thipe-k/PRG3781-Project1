package ApplicationLayer.FoodPackage;
import ApplicationLayer.EventPackage.Event;

import java.util.ArrayList;
import java.util.List;

public class BirthdayFood implements IFood {

    @Override
    public double getPrice(List<String[]>data,Event event) {
        

      double total=( Double.parseDouble(data.get(0)[1])*event.getAdultAttendee())+( Double.parseDouble(data.get(0)[1])*event.getAdultAttendee());

      if((event.getAdultAttendee()+event.getMinorAddendee()>40)){
        double discount = total*0.15;
         total-=discount ;
      }
      
        return total;
        

    }
    @Override
    public  List<String[]> getAdultMeal() {
      List<String[]>bf= new ArrayList<String[]>();
      bf.add(new String[]{"Pasta","80"});
      bf.add(new String[]{"Seafood","180"});
      bf.add(new String[]{"Medditerianean Rice","120"});
      return bf;

    }

    @Override
    public  List<String[]> getMinorMeal() {
        List<String[]>bf= new ArrayList<String[]>();
        bf.add(new String[]{"Rice","80"});
      bf.add(new String[]{"Burger and chips","180"});
      bf.add(new String[]{"Pizza","120"});

      return bf;
    }
}


package ApplicationLayer.EventPackage;
import java.util.Date;
public interface IEvent {
  
   public String getLocation();
   public String getType();
   public int getMemberCount();
   public Date getDate();
}

package ApplicationLayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Notifications implements Serializable {
   /**
    *
    */
   private static final long serialVersionUID = 18L;
   List<Notification> notifications;
   public Notifications() {
      notifications = new ArrayList<Notification>();
   }

   public List<Notification> getNotifications() {
      return this.notifications;
   }

}

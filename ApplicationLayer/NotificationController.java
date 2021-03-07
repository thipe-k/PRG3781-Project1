package ApplicationLayer;

import DataAccessLayer.FileHandler;
import java.io.File;

public class NotificationController {
   private FileHandler fileHandler;
   public Notifications getNotifications ()
   {
   
      File fl = new File("notifications","notifications.ser");
     fileHandler = new FileHandler();
     Notifications notifications = (Notifications)fileHandler.getSerializedData(fl);
     if(notifications == null)
     {
        notifications = new Notifications();
     }
      return notifications;
   }
   public void sendNotification(Notifications notification)
   {
      File folder = new File("notifications");
      if(!folder.exists())
      {
         folder.mkdir();
      }
      File fl = new File("notifications","notifications.ser");
      fileHandler.serializeToFile(notification, fl);
   }

   public NotificationController() {
      fileHandler = new FileHandler();
   }
   public String getUnreadNotifications()
   {
      int unread = 0;
      int count = 0;
      if(getNotifications() != null)
      {
         for (Notification notification : getNotifications().getNotifications()) {
            if(!notification.getIsRead())
            {
               unread++;
       
            }
            count++;
         }
      }

      return String.format("Unread: %d , Total : %d", unread, count);
   }
   public void markAllAsRead()
   {
      Notifications notifications = getNotifications();
    for (int i = 0; i < notifications.getNotifications().size(); i++) {
       notifications.getNotifications().get(i).setIsRead(true);      
    }
    sendNotification(notifications);
   }




}

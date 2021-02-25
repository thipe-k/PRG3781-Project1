package PresentationLayer;
import ApplicationLayer.Utility.*;
import ApplicationLayer.*;
import ApplicationLayer.EventPackage.*;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class CleintMenu {

   String firstName;
   String lastName;
   String cellNumber;
   String email;
   String dateString;
   String eventlocation;
   short adultAttendee;
   short minorAttendee;
   byte evenType;
   Scanner input = new Scanner(System.in);

   public void mainMenu()
   {
      System.out.println("Welcome to Online Envent booking");
      System.out.println("1 : Book An Event");
      System.out.println("2 : View Booking");
      System.out.println("3 : Confirm Booking");
      System.out.println("4 : Cancel Booking");
      System.out.print("Enter value : ");
      
      int selection =input.nextInt();
      switch (selection) {
         case 1:
            book();
            break;
         case 2:
            
            break;   
         case 3:
            
            break;
         case 4:
            
            break;              
         default:
            break;
      }
    

   }
   private void book()
   {
      getClientData();
      getEventData();
   
      try {
         Client client = new Client(firstName, lastName, cellNumber, email);
         Date dateOfEvent = new SimpleDateFormat("dd.MM.yyyy").parse(dateString);
         EventFactory eventFactory = new EventFactory();
         Event event = eventFactory.getEvent(DefaultEvents.getById(1));
         event.setValues(eventlocation, dateOfEvent, adultAttendee, minorAttendee);
  //       Booking booking = new Booking(event, client);
      } catch (Exception e) {
         //TODO: handle exception
      }
   

   }
   private void getClientData()
   {
      input.nextLine();
      System.out.print("Enter First Name : ");
      firstName = input.nextLine();
      System.out.print("Enter Last Name : ");
      lastName = input.nextLine();
      System.out.print("Enter cell phone number : ");
      cellNumber = input.nextLine();
      System.out.print("Enter email address : ");
      email = input.nextLine();
      
   }

   private void getEventData()
   {   

      System.out.println("Please Select Type of Event");
      System.out.println("1 : Wedding");
      System.out.println("2 : Party");
      System.out.println("3 : Birth Day ");
      System.out.println("4 : Year End Function");
      System.out.print("Enter value : ");
      evenType = input.nextByte();
        input.nextLine();
      System.out.print("When is the event ? (dd.mm.yyyy.H) : ");
      dateString = input.nextLine();
      System.out.print("Where is the event (Address) : ");
      eventlocation = input.nextLine();
      System.out.print("How many adults will attend the event: ");
      adultAttendee = input.nextShort();
      System.out.print("How many kids/minors will attend the event: ");
      minorAttendee = input.nextShort();

   }
    protected void finalize()
    {
      input.close();
    }


 
   // String cellNumber;
   // String email;
   // String eventlocation;
   // short adultAttendee;
  //  short minorAttendee;



  public boolean checkDate(String date)
  {
     //Please confirm if the logic is ok
   if(date.length()==10 )
   {
       String[] split = date.split(".");
       if(Integer.parseInt(split[1])%2!=0)
       {
         if(Integer.parseInt(split[0])  <= 31 )
         {
            return true;
         }
         else
         {
            System.out.println("The month you have selected has 31 days");
            return false;
         }   
       }
       else
       {
         if(Integer.parseInt(split[1])  != 02 )
         {
            if(Integer.parseInt(split[0])  <= 30 )
            {
               return true;
            }
            else
            {
               System.out.println("The month you have selected has 30 days");
               return false;
            }
         }
         else
         {
            if(Integer.parseInt(split[0])  <= 28 )
            {
               return true;
            }
            else
            {
               System.out.println("February has 28 days");
               return false;
            }
         }
       }
   }
   else
   {
      System.out.println("Please follow the pattern for the date");
      return false;
   }
  }


  public boolean checkName(String name)
  {
   if(name!="")
   {
      return true;
   }
   else
   {
      return false;
   }
  
  }
  public boolean checkSurname(String name)
  {
   if(name!="")
   {
      return true;
   }
   else
   {
      return false;
   }
  
  }


}

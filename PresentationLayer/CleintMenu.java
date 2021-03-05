package PresentationLayer;
import ApplicationLayer.Utility.*;
import ApplicationLayer.*;
import ApplicationLayer.EventPackage.*;
import ApplicationLayer.FoodPackage.FoodFactory;
import ApplicationLayer.FoodPackage.IFood;

import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class CleintMenu {

   String firstName;
   String lastName;
   String cellNumber;
   String email;
   String dateString;
   String eventlocation;
   short adultAttendee;
   short minorAttendee;
   int evenType;
   int adultFood ;
   int minorFood ;
   IFood foodObject;
   List<String[]>selecedFood = new ArrayList <String[]>();
   boolean isDecorationNeeded;
   Scanner input = new Scanner(System.in);
   FoodFactory foodfactory = new  FoodFactory();

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
         Event event = eventFactory.getEvent(DefaultEvents.getById(evenType));
         event.setValues(eventlocation, dateOfEvent, adultAttendee, minorAttendee);
         Booking booking = new Booking(event, client);
         System.out.println("------------------------------------------------");
         System.out.println("Booking process almost complete, please confirm your details");
         System.out.println(client.toString());
         System.out.println(event.toString());
         System.out.println("The total is:"+foodObject.getPrice(selecedFood, event));
         System.out.println("Booking complete ");
         System.out.println("Your Booking Number is : " + booking.getBookingNum());
         Operations os = new Operations();
         os.bookEvent(booking);


      } catch (Exception e) {
         System.out.println("An error occured : " + e.toString());
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
      System.out.println("2 : Birth Day");
      System.out.println("3 : Year End Function ");
      System.out.println("4 : Babtism");
      System.out.print("Enter value : ");
      evenType = input.nextInt();
      
      input.nextLine();
      System.out.print("When is the event ? (dd.mm.yyyy.H) : ");
      dateString = input.nextLine();
      System.out.print("Where is the event (Address) : ");
      eventlocation = input.nextLine();
      System.out.print("How many adults will attend the event: ");
      adultAttendee = input.nextShort();
      System.out.print("How many kids/minors will attend the event: ");
      minorAttendee = input.nextShort();
     
      foodObject = foodfactory.getfood(DefaultEvents.getById(evenType));
      System.out.println("Select Adult Food");
      
      int c = 1 ;
      for (String[] foodz : foodObject.getAdultMeal()) {
       
         System.out.println(c+", "+ foodz[0]+" R"+ foodz[1]);
         c++;
      }
      System.out.println("Enter a value : "); 
      adultFood = input.nextInt();
      selecedFood.add(foodObject.getAdultMeal().get(adultFood-1));
      System.out.println("Select Minor Food");
      c= 1;
      for (String[] foodz : foodObject.getMinorMeal()) {
       
         System.out.println(c+", "+ foodz[0]+" R"+ foodz[1]);
         c++;
      }
      System.out.println("Enter a value : "); 
      minorFood = input.nextInt();
      selecedFood.add(foodObject.getMinorMeal().get(minorFood-1));

   try{
      
         Date dateOfEvent = new SimpleDateFormat("dd.MM.yyyy").parse(dateString);
         EventFactory eventFactory = new EventFactory();
         Event event = eventFactory.getEvent(DefaultEvents.getById(evenType));
         event.setValues(eventlocation, dateOfEvent, adultAttendee, minorAttendee);

         System.out.println("The total is:"+foodObject.getPrice(selecedFood, event));
   }
   catch( Exception e){}
     
   
      System.out.println("Do you need decoration for the event ?");
      System.out.println("1 : YES, I need decoration");
      System.out.println("2 : NO, Thank you.");
      System.out.println("Enter a value : "); 
  
      isDecorationNeeded = (input.nextShort() == 1) ? true: false;
      if(isDecorationNeeded)
      {
         System.out.println("Decoration is needed."); 
         // code for decorations will go here
      } 
      {
         System.out.println("Decoration not needed.");
      
      }
      
      

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

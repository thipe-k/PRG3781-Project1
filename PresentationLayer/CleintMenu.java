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

   Operations os = new Operations();


   IFood foodObject;
   Theme theme ;
   Decoration decoration;
   Client client;
   Event event;
   List<String[]>selectedFood = new ArrayList <String[]>();
   boolean isDecorationNeeded;
   Scanner input = new Scanner(System.in);
   FoodFactory foodfactory = new  FoodFactory();

   public void mainMenu() throws Exception
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
            System.out.print("Enter Booking Number : ");
            input.nextLine();
            String bookingNumber = input.nextLine();
            Booking booking = os.getBooking(bookingNumber);
            if(booking == null)
            {
               System.out.println("Booking Number : " + bookingNumber + "does not exist");
            }
            else{
               System.out.println("--------------Booking Details of "+ booking.getBookingNum()+"-------------");
               System.out.println("Status \t : "+ booking.getStatus());
               System.out.println("Type \t : "+ booking.getEvent().getType());
               System.out.println("Owner \t : " + booking.getClient().getDetails());
               System.out.println("Contacts \t : "+ booking.getClient().getContactDetails());
               if(booking.getDecoration() != null){System.out.println("Decoration Theme \t : " + booking.getDecoration().getTheme());}
               System.out.println("Date \t : "+ booking.getEvent().getDateOfEvente().toGMTString());
               System.out.println("-------------------------------------------------------------------------");
            }
            break;   
         case 3:
               System.out.print("Enter Booking Number : ");
               input.nextLine();
               String bookingNumberr = input.nextLine();
               Booking bookingg = os.getBooking(bookingNumberr);
               if(bookingg == null)
               {
                  System.out.println("Booking Number : " + bookingNumberr + "does not exist");
               }
               else{
                  if(bookingg.isIsConfirmed())
                  {
                     System.out.println("Booking already confirmed");
                  }
                  else{
                     System.out.println("You have to pay %50 of ammount to confirm booking");
                     System.out.println( "Pay R"+ bookingg.getConfirmationAccount() + " to confirm booking" );
                     System.out.print("Enter Ammount : ");
                     double ammount = input.nextDouble();
                     bookingg.getPayment().setPayedAmount(ammount);
                     bookingg.confrimBooking();
                     if (bookingg.isIsConfirmed())
                     {
                        System.out.println("Booking Comfirmed");

                        NotificationController  notificationController = new NotificationController();
                        Notification notification = new Notification(bookingg.getBookingNum(), "Booking has been confirmed");
                        Notifications notifications = notificationController.getNotifications();
             
                        notifications.getNotifications().add(notification);
                        notificationController.sendNotification(notifications); 
                        os.bookEvent(bookingg);
                     }
                     else{
                        System.out.println("The amount that you payed is shot by : "+ bookingg.getConfirmationAccount());
                        System.out.println("Please pay the rest of amount to confirm Booking");
                        os.bookEvent(bookingg);
                     }
                  }
               }
            break;
         case 4:
            
            break;              
         default:
            break;
      }
    

   }
   private void book() throws Exception
   {
      getClientData();
      getEventData();
   
      try {
     
 
         Booking booking = new Booking(event, client,selectedFood);
         System.out.println("------------------------------------------------");
         System.out.println("Booking process almost complete, please confirm your details");
         System.out.println(client.toString());
         System.out.println(event.toString());
         System.out.println("Total Ammount : R" + booking.getAmmount());
         if(decoration != null)
         {
            booking.setDecoration(decoration);
            System.out.println("Decoration : Theme - "+decoration.getTheme().getEventTheme() );
         }

         System.out.println( "Enter 1 to Book event or anykey to cancel");
         System.out.println("Enter value : ");

         String _choice = input.nextLine();
         if(_choice.equalsIgnoreCase("1"))
         {
            System.out.println("Booking complete ");
            System.out.println("Your Booking Number is : " + booking.getBookingNum());
            os.bookEvent(booking);
         }
         else{
            System.out.println("Booking canceled, Thank you");
         }
  
      } catch (Exception e) {
         System.out.println("An error occured : " + e.toString());
      }
   

   }
   private void getClientData()
   {
      String firstName;
      String lastName;
      String cellNumber;
      String email;

      input.nextLine();
      System.out.print("Enter First Name : ");
      firstName = input.nextLine();
      System.out.print("Enter Last Name : ");
      lastName = input.nextLine();
      System.out.print("Enter cell phone number : ");
      cellNumber = input.nextLine();
      System.out.print("Enter email address : ");
      email = input.nextLine();
      client = new Client(firstName, lastName, cellNumber, email);
      
   }

   private void getEventData() throws Exception
   {   
      String dateString;
      String eventlocation;
      short adultAttendee;
      short minorAttendee;
      int evenType;
      int adultFood ;
      int minorFood ;
      decoration = null;
      System.out.println("Please Select Type of Event");
      System.out.println("1 : Wedding");
      System.out.println("2 : Birth Day");
      System.out.println("3 : Year End Function ");
      System.out.println("4 : Babtism");
      System.out.print("Enter value : ");
      evenType = input.nextInt();
      
      input.nextLine();
      System.out.print("When is the event ? (dd.mm.yyyy) : ");
      dateString = input.nextLine();
      Date dateOfEvent = new SimpleDateFormat("dd.MM.yyyy").parse(dateString);
      boolean dateExist = (os.checkDate(dateOfEvent)) ? true : false ;
      
      while (dateExist)
      {
         System.out.println("Date already been booked for an event please book another date");
         System.out.print("When is the event ? (dd.mm.yyyy) : ");
         dateString = input.nextLine();
         dateOfEvent = new SimpleDateFormat("dd.MM.yyyy").parse(dateString);
         dateExist = (os.checkDate(dateOfEvent)) ? true : false ;
      }

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
      selectedFood.add(foodObject.getAdultMeal().get(adultFood-1));
      System.out.println("Select Minor Food");
      c= 1;
      for (String[] foodz : foodObject.getMinorMeal()) {
       
         System.out.println(c+", "+ foodz[0]+" R"+ foodz[1]);
         c++;
      }
      System.out.println("Enter a value : "); 
      minorFood = input.nextInt();
      selectedFood.add(foodObject.getMinorMeal().get(minorFood-1));

   try{
      
     // Date dateOfEvent = new SimpleDateFormat("dd.MM.yyyy").parse(dateString);
      EventFactory eventFactory = new EventFactory();
      event = eventFactory.getEvent(DefaultEvents.getById(evenType));
      event.setValues(eventlocation, dateOfEvent, adultAttendee, minorAttendee);

         System.out.println("The total food price is : R "+foodObject.getPrice(selectedFood, event));
   }
   catch( Exception e){}
     
   
      System.out.println("Do you need decoration for the event ?");
      System.out.println("1 : YES, I need decoration");
      System.out.println("2 : NO, Thank you.");
      System.out.println("Enter a value : "); 
  
      isDecorationNeeded = (input.nextShort() == 1) ? true: false;
      if(isDecorationNeeded)
      {
        decorationMenu();    
      } 
      {
         System.out.println("Decoration not needed.");
         input.nextLine();
      
      }
      



   }

    protected void finalize()
    {
      input.close();
    }

    private void decorationMenu()
    {
       input.nextLine();
       String color1;
       String color2;
       String eventTheme;
       boolean balloons;
       boolean candels;
       int nrOfTables;

       System.out.print("Enter Primary Color : ");
       color1 = input.nextLine();
       System.out.print("Enter Secondary Color : ");
       color2 = input.nextLine();
       System.out.println("Select Theme");
       System.out.println("1 - Pirate");
       System.out.println("2 - Huwaii");
       String selectedTheme = input.nextLine();
       switch (selectedTheme) {
          case "1":
             eventTheme = "Pirate";
             break;
          case "2":
             eventTheme = "Huwaii";
             break ;      
          default:
          eventTheme = "custom";
             break;
       }  
       System.out.print("Enter Number of Tables : ");
       nrOfTables = Integer.parseInt(input.nextLine());
       System.out.println("Do you need Candles ? type : Y/yes or Y/no");
       String choice = input.nextLine();
       candels = (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y") ) ? true : false;

       System.out.println("Do you need Ballons ? type : Y/yes or Y/no");
       choice = input.nextLine();
       balloons = (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y") ) ? true : false; 
       theme = new Theme(color1, color2, eventTheme);
       decoration = new Decoration(theme, balloons, candels, nrOfTables);

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

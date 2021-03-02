package DataAccessLayer;
import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.Scanner;
public class FileHandler {
   private String fileName;
   private String folderName;

   public FileHandler(String fileName) {
      this.fileName = fileName;
      checkFile();
   }
   public FileHandler(){
      this.folderName = "bookings";
   }
  
   public Vector<String> getData()
   {
      // an interface to access file contents
      return fileContent();
   }
   public boolean saveData(String data)
   {
      // an interface to allow writting to a file
      return addContentToFile(data);
   }

   private void checkFile()
   {
      /* This method uses the file name to check if the file already exists
       * if the file does not exist it will create it.
       *  this method ensures that an application does not fail trying to access a file that does not exist
      */ 

      File file = new File(fileName);
      if(!file.exists())
      {
         try {
         file.createNewFile();            
         } catch (Exception e) {
           // missing code for handling exception
         }
      }
   }
   private Vector<String> fileContent()
   {
      // this method reads contents of a file and stores them on a vector collection

      Vector<String> fileData = new Vector<String>();
      try {
         Scanner dataReader = new Scanner(new File(fileName)); 
         while(dataReader.hasNextLine())
         {
            fileData.add(dataReader.nextLine());
         }       
      } catch (Exception e) {
          // missing code for handling exception
      }

      return fileData;
   }
   private boolean addContentToFile(String data)
   {
      // This method takes data in a form of a string and writes it to a file
      try {
         FileWriter writer = new FileWriter(fileName, true);
         writer.write(data);
         writer.write("\n"); // move carsor to new line
         writer.close();
         return true;
      } catch (Exception e) {
          // missing code for handling exception
      }
      return false;
   }
   public <obj> void serializeToFile( obj data, String bookingNumber) 
   {
      String fl = "booking"+ bookingNumber + ".ser";
      File fileToDir = new File("bookings", fl);
      try(
         FileOutputStream file = new FileOutputStream(fileToDir,true);
         ObjectOutputStream objectStream = new ObjectOutputStream(file)
        ) 
          {
               objectStream.writeObject(data); 
          } catch (Exception e) {
         System.out.println("An error occured while serializing data : " + e.toString() );
      }
   }
    
   public Vector<Object> getSerializedData()
   {  
      // this method takes a list of filesnames from a folder then uses them to desirialise the objects
     // brackets on try allow the objects to automatically close after code block
      Vector<Object> data = new Vector<Object>();
      for (String flName : getFileNames()) {
         File fileFromDir = new File(folderName, flName);
         try (
            FileInputStream file = new FileInputStream(fileFromDir);
            ObjectInputStream objectStream = new ObjectInputStream(file)
         ) 
         {     
            data.add(objectStream.readObject());  
         } 
         catch (Exception e) {
            System.out.println("An error occured while deserializing data :" + e.toString());
            System.out.println(e.getStackTrace());
         }
      }
      return data;
   }
   private String getPostFixString()
   {
    // this method is used to formate current date into a format used for generating booking numbers
      SimpleDateFormat dateString = new SimpleDateFormat("yyyyMMdd");
      String text = dateString.format(new Date().getTime());
      return  text+"_";
   }

   public String getBookingNumber()
   { 
      // this method generates booking numbers by extracting last booking number and incrementing  to it
       String lastBooking;
       String[] temp = getFileNames();
       if(temp.length < 1)
       {
          return getPostFixString()+1;
       }
       else
       {
         lastBooking = temp[temp.length -1];
         temp = lastBooking.split("_");
         String [] temp2 = temp[1].split(".s");
         int num = Integer.parseInt(temp2[0]) + 1;
         return getPostFixString()+num;
       }

   }


  private String[] getFileNames()
  {
     // this method used to obtain all file names in a folder, directory
      File files = new File(folderName);
      if(files.exists())
      {
         if(files.isDirectory())
         {
            return files.list();
         }
         else{
            System.out.println(" You a trying to access a file that is not a directory");
            return null;
         }
      }
      else{
         System.out.println("Trying to access a directory that does not exist");
         return null;
      }
  }


}

package DataAccessLayer;
import java.io.File;
import java.io.FileWriter;
import java.util.Vector;
import java.util.Scanner;
public class FileHandler {
   private String fileName;

   public FileHandler(String fileName) {
      this.fileName = fileName;
      checkFile();
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

}

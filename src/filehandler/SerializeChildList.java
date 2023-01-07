package filehandler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializeChildList {
	
	public static void writeToFile(ArrayList childList)  {
		
		 try
		 {
		 // Create the stream objects.
	      FileOutputStream outStream = 
	                new FileOutputStream("Objects.dat");
	      ObjectOutputStream objectOutputFile = 
	                new ObjectOutputStream(outStream);
	      
	      // Write the serialized objects to the file.
	      for (int i = 0; i < childList.size(); i++)
	      {
	         objectOutputFile.writeObject(childList);
	      }
	      
	      // Close the file.
	      objectOutputFile.close();
	      System.out.println("The serialized objects " +
		            "were written to the Objects.dat file.");
		 } catch(IOException e)
		 {
			 System.out.println("OOps...there was a problem");
			 e.printStackTrace();
		 }
	      
	      System.out.println("The serialized objects " +
	            "were written to the Objects.dat file.");
		
	}

}
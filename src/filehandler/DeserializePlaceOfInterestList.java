package filehandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import property.models.PlaceOfInterest;
import property.models.Property;

public class DeserializePlaceOfInterestList {
	
	public static ArrayList<PlaceOfInterest> readChildList()  {
		ArrayList<PlaceOfInterest> list = new ArrayList<PlaceOfInterest>();
		
		try
		{
			   File f = new File("placeOfInterest.dat");
			   FileInputStream inStream;
			   ObjectInputStream objectInputFile = null;
		        if (f.exists())  {
		// Create the stream objects.
	       inStream =  new FileInputStream("placeOfInterest.dat");
	      objectInputFile = new ObjectInputStream(inStream);
		        }
	      else 
	        	 System.out.println("File does not exist");

	      
	      // Read the serialized objects from the file.
	 
	        if (f.length()>0) {
	        list = (ArrayList<PlaceOfInterest>) objectInputFile.readObject();
	        objectInputFile.close();
	        }
	        else 
	        	 System.out.println("File is empty");  
	      
	      // Close the file.
	      
		} catch(IOException e) {
			System.out.println("OOps...there was a problem");
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			System.out.println("OOps...there was a problem");
			e.printStackTrace();
		}
		
		return list;
	}

}
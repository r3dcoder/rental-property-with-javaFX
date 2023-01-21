package filehandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import property.models.Invoice;
import property.models.Property;

public class DeserializeInvoiceList {
	
	public static ArrayList<Invoice> readChildList()  {
		ArrayList<Invoice> list = new ArrayList<Invoice>();
		
		try
		{
			   File f = new File("invoice.dat");
			   FileInputStream inStream;
			   ObjectInputStream objectInputFile = null;
		        if (f.exists())  {
		// Create the stream objects.
	       inStream =  new FileInputStream("invoice.dat");
	      objectInputFile = new ObjectInputStream(inStream);
		        }
	      else 
	        	 System.out.println("File does not exist");

	      
	      // Read the serialized objects from the file.
	 
	        if (f.length()>0) {
	        list = (ArrayList<Invoice>) objectInputFile.readObject();
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
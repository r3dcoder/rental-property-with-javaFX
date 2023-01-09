package filehandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import customer.models.Customer;
import property.models.Property;

public class DeserializeCustomerList {
	
	public static ArrayList<Customer> readChildList()  {
		ArrayList<Customer> list = new ArrayList<Customer>();
		
		try
		{
			   File f = new File("customer.dat");
			   FileInputStream inStream;
			   ObjectInputStream objectInputFile = null;
		        if (f.exists())  {
		// Create the stream objects.
	       inStream =  new FileInputStream("customer.dat");
	      objectInputFile = new ObjectInputStream(inStream);
		        }
	      else 
	        	 System.out.println("File does not exist");

	      
	      // Read the serialized objects from the file.
	 
	        if (f.length()>0) {
	        list = (ArrayList<Customer>) objectInputFile.readObject();
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
		
	      
	      // Display the objects.
	      for (int i = 0; i < list.size(); i++)
	      {
	    	  Customer  c =  (Customer) list.get(i);
	         System.out.println("Child Name " + c);
	          
	      }
		return list;
	}

}
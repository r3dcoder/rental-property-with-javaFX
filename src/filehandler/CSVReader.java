package filehandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import helper.StringToDate;
import property.models.Property;

public class CSVReader {
 
    private String csvFile; // Path to the CSV file
    String line = ""; // A string to store each line of the file
    String csvSplitBy = ","; // The character used to split the values
    
    boolean headerRead = false;
    
    public void fileRead()  {
    	
    	ArrayList<Property> list = new ArrayList<Property>();
 	   
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
            	
            	  if (!headerRead) {
                      // Skip the first line (the header)
                      headerRead = true;
                      continue;
                  }
            	  
                // Split the line by the split character
                String[] values = line.split(csvSplitBy);

                String lat = values[6].toString().replace("\"", "");
                String lon = values[7].toString().replace("\"", "");
                
                Property p = new Property();
                
                StringToDate n = new StringToDate(values[0].toString());
                
                Date nDate = n.getDate();
                
                 p.setListed(nDate);
                 
                 p.setBedrooms(Integer.parseInt(values[1]));
                 p.setBathrooms(Integer.parseInt(values[2]));
                 p.setRentPerMonth(Double.parseDouble(values[3]));
                 p.setSize(Double.parseDouble(values[4]));
                 p.setPostcode(values[5].toString());
                 p.setLatitude(Double.parseDouble(lat));
                 p.setLongitude(Double.parseDouble(lon));
                 p.setFurnishingStatus(values[8].toString());
                 p.setType(values[9].toString());
                 p.setGarden(values[10].toString());
                 
                System.out.println(p.getDetails());
                list.add(p);
          	   
           	   
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
           SerializeChildList.writeToFile(list, "property.dat"); 
    	   list = DeserializePropertyList.readChildList();
    }


	public String getCsvFile() {
		return csvFile;
	}


	public void setCsvFile(String r) {
		csvFile= r;
	}

}

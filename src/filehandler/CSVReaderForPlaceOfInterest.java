package filehandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import property.models.PlaceOfInterest;
 

public class CSVReaderForPlaceOfInterest {

	private String csvFile; // Path to the CSV file
	String line = ""; // A string to store each line of the file
	String csvSplitBy = ","; // The character used to split the values

	boolean headerRead = false;
	private ArrayList<PlaceOfInterest> placeOfInterest = new ArrayList<PlaceOfInterest>();
	
	public void fileRead()  {

		

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {

				if (!headerRead) {
					// Skip the first line (the header)
					headerRead = true;
					continue;
				}

				// Split the line by the split character
				String[] values = line.split(csvSplitBy);

				String lat = values[2].toString().replace("\"", "");
				String lon = values[3].toString().replace("\"", "");

				PlaceOfInterest p = new PlaceOfInterest(values[0].toString(),
						values[1].toString(), Double.parseDouble(lat), Double.parseDouble(lon));
				System.out.println("From dis");
				System.out.println(p);
				placeOfInterest.add(p);


			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}


	public void setPlaceOfInterest(ArrayList<PlaceOfInterest>placeOfInterest) {
		
		this.placeOfInterest = placeOfInterest;
	}
	public ArrayList<PlaceOfInterest> getPlaceOfinterest() {
		
		return this.placeOfInterest;
	}

	public String getCsvFile() {
		return csvFile;
	}
	
//	public String toString() {
//		for(int i = 0 ; i< placeOfInterest.size(); i++) {
//			
//		}
//	}


	public void setCsvFile(String r) {
		csvFile= r;
	}
	
	
	

}

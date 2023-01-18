package property;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import filehandler.CSVReaderForPlaceOfInterest;
import helper.DistanceCalculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import property.models.PlaceOfInterest;
import property.models.Property;

public class PropertyDetailsController {

	public Main main;

	private Property property;
	@FXML 
	private TextArea propertyDetails;

	@FXML
	private TextArea distanceDetails;

	public PropertyDetailsController() {

		main = new Main();
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		System.out.println("Set Property: " + property.getDetails());
		this.property = property;
		updateUI();
	}

	public String getDetails() {
		return property.getDetails();
	}

	public String calculateDistance() {
		CSVReaderForPlaceOfInterest interest = new CSVReaderForPlaceOfInterest();
		interest.setCsvFile("PlacesOfInterestDataSet.csv");
		interest.fileRead();

		ArrayList<PlaceOfInterest> pOfInterest = interest.getPlaceOfinterest();

		StringBuilder sb = new StringBuilder();


		sb.append("Place Of Interest:\n");
		sb.append("-----------------\n");
 
		String unit = "K";

		for(int i = 0 ; i<pOfInterest.size(); i++) {
			System.out.println("pOfInterest "+ pOfInterest.get(i));
			
			DistanceCalculator d = new DistanceCalculator(
					property.getLatitude(), 
					property.getLongitude(), 
					pOfInterest.get(i).getLatitude(),
					pOfInterest.get(i).getLongitude(), unit );
			
//			
			System.out.println(d);
			DecimalFormat df = new DecimalFormat("#.00");
	        String formattedValue = df.format(d.getDistance());
			sb.append(pOfInterest.get(i).getName() + ": ").append(formattedValue + " "+ unit ).append("\n");
			
			sb.append("\n");
		}

		return sb.toString();


	}
	
	@FXML 
	public void onClickedAssignedToCustomer(ActionEvent event) throws IOException {
		System.out.println("onClickedAssignedToCustomer: "+ property.getBathrooms());
		main.showAssignCustomerFormView(property.getId());
		System.out.println(property.getId());
	}
	private void updateUI() {
		propertyDetails.setText(getDetails());
		distanceDetails.setText(calculateDistance());

	}
	
	@FXML
	public void onClickBackButton() {
		try {
			main.showPropertyListView();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}

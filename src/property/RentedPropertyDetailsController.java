package property;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import customer.models.Customer;
import filehandler.CSVReaderForPlaceOfInterest;
import filehandler.DeserializeInvoiceList;
import helper.DistanceCalculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import property.models.Invoice;
import property.models.PlaceOfInterest;
import property.models.Property;

public class RentedPropertyDetailsController {

	public Main main;

	private Property property;
	@FXML 
	private TextArea propertyDetails;

	@FXML
	private TextArea invoiceDetails;

	public RentedPropertyDetailsController() {

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

	 
	@FXML 
	public void onClickedEndTenancy(ActionEvent event) throws IOException {
		System.out.println("onClickedEndTenancy: "+ property.getBathrooms());
		main.showEndtenancyFormView(property.getId(), getCustomer().getFullName());
		System.out.println(property.getId());
	}
	private void updateUI() {
		propertyDetails.setText(getDetails());
		invoiceDetails.setText(getInvoiceDetails());

	}
	
	private String getInvoiceDetails() {
		ArrayList<Invoice> list = DeserializeInvoiceList.readChildList();
		
		for(int i = 0 ; i<list.size(); i++) {
			System.out.println("pro Id "+list.get(i).getProperty().getId()+ " "+ property.getId());
			if(list.get(i).getProperty().getId().equals(property.getId())) {
				return list.get(i).toString();
			}
		}
		return "";
	}
	
	private Customer getCustomer() {
		ArrayList<Invoice> list = DeserializeInvoiceList.readChildList();
		
		for(int i = 0 ; i<list.size(); i++) {
			if(list.get(i).getProperty().getId().equals(property.getId())) {
				return list.get(i).getTenant();
			}
		}
		return null;
	}
	
	@FXML
	public void onClickBackButton() {
		try {
			main.showRentedPropertyListView();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}

package property;

import java.io.IOException;

import javafx.fxml.FXML;

public class myController {
	private Main main;

    

	public myController() {
		Main m = new Main();
		setMain(m);
		// TODO Auto-generated constructor stub
	}
	public myController(Main main) {
        this.main = main;
    }
	 public void setMain(Main main) {
	        this.main = main;
	    }
	
 	 @FXML
	 private void onClickedPropertyButton() throws IOException {
	     try {
	         System.out.println("Trying to call showAddPropertyView on main object");
	         main.showAddPropertyView();
	     } catch (Exception e) {
	         System.out.println("Error calling showAddPropertyView on main object: " + e.getMessage());
	         e.printStackTrace();
	     }
	 }
 	 
 	
 	@FXML
	 private void onClickedInvoiceListButton() throws IOException {
	     try {
	         System.out.println("Trying to call showAddPropertyView on main object");
	         main.showInvoiceListView();
	     } catch (Exception e) {
	         System.out.println("Error calling showAddPropertyView on main object: " + e.getMessage());
	         e.printStackTrace();
	     }
	 }
 	
 	@FXML
	 private void onClickedPlaceOfInterestListButton() throws IOException {
	     try {
	         System.out.println("Trying to call showAddPropertyView on main object");
	         main.showPlaceOfInterestListView();
	     } catch (Exception e) {
	         System.out.println("Error calling showAddPropertyView on main object: " + e.getMessage());
	         e.printStackTrace();
	     }
	 }
 	
 	
 	 @FXML
	 private void onClickedCustomerListButton() throws IOException {
	     try {
	         System.out.println("Trying to call showAddPropertyView on main object");
	         main.showCustomerListView();
	     } catch (Exception e) {
	         System.out.println("Error calling showAddPropertyView on main object: " + e.getMessage());
	         e.printStackTrace();
	     }
	 }
 	
 	
 	@FXML
	 private void onClickedPropertyListButton() throws IOException {
	     try {
	         System.out.println("Trying to call show Properties List View Sceen");
	         main.showPropertyListView();
	     } catch (Exception e) {
	         System.out.println("Error calling showAddPropertyView on main object: " + e.getMessage());
	         e.printStackTrace();
	     }
	 }
 	
 	@FXML
	 private void onClickedRentedPropertyListButton() throws IOException {
	     try {
	         System.out.println("Trying to call show showRentedPropertyListView List View Sceen");
	         main.showRentedPropertyListView();
	     } catch (Exception e) {
	         System.out.println("Error calling showRentedPropertyListView on main object: " + e.getMessage());
	         e.printStackTrace();
	     }
	 }
	
 	@FXML
	 public void onClickedHomeButton() throws IOException {
	     try {
	    	 	main.showHomePage();
	      
	     } catch (Exception e) {
	         System.out.println("Error calling showAddPropertyView on main object: " + e.getMessage());
	         e.printStackTrace();
	     }
	 }


}

package property;

import java.io.IOException;
import java.util.ArrayList;

import filehandler.CSVReader;
import filehandler.DeserializePropertyList;
import filehandler.SerializeChildList;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import property.models.Invoice;
import property.models.Property;

public class Main extends Application {

	private static Stage primaryStage;
	private static BorderPane mainLayout;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Set up the main layout
		this.primaryStage = primaryStage;
		showHomePage();
		//		showPropertyListView();

	}

	public void showHomePage() throws IOException {
		showMainView();
		showMainItems();
//		CSVReader reader = new CSVReader();
//		reader.setCsvFile("House_Rent_Dataset.csv");
//		reader.fileRead();
		
	}

	private void showMainItems() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainItems.fxml"));
		BorderPane  mainItems = loader.load();
		mainLayout.setCenter(mainItems);

		ArrayList<Property> list = new ArrayList<Property>(); 
		list = DeserializePropertyList.readChildList();

		if(list.size()==0) {
			CSVReader csvReader = new CSVReader();
			csvReader.setCsvFile("House_Rent_Dataset.csv");
			csvReader.fileRead();
		}


	}

	private void showMainView() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainView.fxml"));
		mainLayout = loader.load();

		// Set the scene
		this.primaryStage.setTitle("Rental House App");
		Scene scene = new Scene(mainLayout);
		this.primaryStage.setScene(scene);
		this.primaryStage.show();

	}

	public void showPropertyListView() throws IOException {

		
		System.out.println("showPropertyListView Clicked");
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/PropertyListView.fxml"));
		BorderPane  mainLayout = loader.load();
//		mainLayout.setCenter(mainItems);
		
		this.primaryStage.setTitle("Property Details");
		Scene scene = new Scene(mainLayout);
		this.primaryStage.setScene(scene);
		this.primaryStage.show();
		
	}
	
	public void showRentedPropertyListView() throws IOException {

		
		System.out.println("showPropertyListView Clicked");
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/RentedPropertyListView.fxml"));
		BorderPane  mainLayout = loader.load();
		this.primaryStage.setTitle("Rented Properties");
		Scene scene = new Scene(mainLayout);
		this.primaryStage.setScene(scene);
		this.primaryStage.show();
		
	}
	
	public void showRentedPropertyDetailsView(Property property) throws IOException {

		System.out.println("property detials Clicked" + property);

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/RentedPropertyDetails.fxml"));
		BorderPane  mainLayout = loader.load();
		RentedPropertyDetailsController propertyDetailsController = loader.getController();
 		propertyDetailsController.setProperty(property);

 
		// Set the scene
		this.primaryStage.setTitle("Rented Property Details");
		Scene scene = new Scene(mainLayout);
		this.primaryStage.setScene(scene);
		this.primaryStage.show();
		

	}

	public void showPropertyDetailsView(Property property) throws IOException {

		System.out.println("property detials Clicked" + property);

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/PropertyDetailsView.fxml"));
		BorderPane  mainLayout = loader.load();
		PropertyDetailsController propertyDetailsController = loader.getController();
 		propertyDetailsController.setProperty(property);

 
		// Set the scene
		this.primaryStage.setTitle("Property Details");
		Scene scene = new Scene(mainLayout);
		this.primaryStage.setScene(scene);
		this.primaryStage.show();
		

	}

	public void showAddPropertyView() throws IOException {

		//        System.out.println("Clicked");

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/NewPropertyForm.fxml"));
		BorderPane newProperty = loader.load();

		Stage addDialougeStage = new Stage();
		addDialougeStage.setTitle("Add Propery");
		addDialougeStage.initModality(Modality.WINDOW_MODAL);
		addDialougeStage.initOwner(primaryStage);
		Scene sceen = new Scene(newProperty);
		addDialougeStage.setScene(sceen);
		addDialougeStage.show();
	} 
	
//	Customers view handelling
	
	
	
	public void showInvoiceListView() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/InvoiceListView.fxml"));
		BorderPane  mainLayout = loader.load();
 
		// Set the scene
		this.primaryStage.setTitle("Rental House App/Invoice List");
		Scene scene = new Scene(mainLayout);
		this.primaryStage.setScene(scene);
		this.primaryStage.show();

	}
	
	public void showPlaceOfInterestListView() throws IOException {
		
		System.out.println("showCustomerListView Clicked");
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/PlaceOfInterestListView.fxml"));
		BorderPane  mainLayout = loader.load();
 
		// Set the scene
		this.primaryStage.setTitle("Rental House App/Place Of Interest List");
		Scene scene = new Scene(mainLayout);
		this.primaryStage.setScene(scene);
		this.primaryStage.show();

	}
	
	public void showCustomerListView() throws IOException {
		
		System.out.println("showCustomerListView Clicked");
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/CustomerListView.fxml"));
		BorderPane  mainLayout = loader.load();
 
		// Set the scene
		this.primaryStage.setTitle("Rental House App/Customer List");
		Scene scene = new Scene(mainLayout);
		this.primaryStage.setScene(scene);
		this.primaryStage.show();

	}
	
	public void showAssignCustomerFormView(String propertyId) throws IOException {

		//        System.out.println("Clicked");

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/AssigningPropertyFormView.fxml"));
		BorderPane newProperty = loader.load();

		Stage addDialougeStage = new Stage();
		addDialougeStage.setTitle("Assign Property");
		addDialougeStage.initModality(Modality.WINDOW_MODAL);
		
		AissignCustomerController controller = loader.getController();
 		controller.setPropertyId(propertyId);
 		
		addDialougeStage.initOwner(primaryStage);
		Scene sceen = new Scene(newProperty);
		addDialougeStage.setScene(sceen);
		addDialougeStage.show();
	} 
	
	public void showEndtenancyFormView(String propertyId, String fullName) throws IOException {

		//        System.out.println("Clicked");

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/EndTenancyFormView.fxml"));
		BorderPane newProperty = loader.load();

		Stage addDialougeStage = new Stage();
		addDialougeStage.setTitle("End Tenancy ");
		addDialougeStage.initModality(Modality.WINDOW_MODAL);
		
		EndTenancyController controller = loader.getController();
 		controller.setPropertyId(propertyId);
 		controller.setFullName(fullName);
 		
		addDialougeStage.initOwner(primaryStage);
		Scene sceen = new Scene(newProperty);
		addDialougeStage.setScene(sceen);
		addDialougeStage.show();
	} 
	
	public void showNewCustomerPageView() throws IOException {
		
		System.out.println("showCustomerListView Clicked");
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/NewCustomerPageView.fxml"));
		BorderPane  mainLayout = loader.load();
 
		// Set the scene
		this.primaryStage.setTitle("Rental House App/New Customer Form");
		
		FXMLLoader form = new FXMLLoader(Main.class.getResource("view/NewCustomerFormView.fxml"));
		BorderPane  mainItems = form.load();
		mainLayout.setCenter(mainItems);
		
		Scene scene = new Scene(mainLayout);
		this.primaryStage.setScene(scene);
		this.primaryStage.show();

	}
	
	public void showInvoiceDetailsView(Invoice invoice) throws IOException {

 
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/InvoicePageView.fxml"));
		BorderPane  mainLayout = loader.load();
		InvoiceController invoicecontroller = loader.getController();
 		invoicecontroller.setInvoice(invoice);
//
//		mainLayout.setCenter(mainItems);
		
		
		Scene scene = new Scene(mainLayout);
		this.primaryStage.setScene(scene);
		this.primaryStage.show();


	}
	


	
	public static void main(String[] args) {
		launch(args);
	}

}

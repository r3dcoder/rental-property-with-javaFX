package property;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import filehandler.DeserializePropertyList;
import helper.CustomDateCellFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import property.models.Property;

public class RentedPropertyListController implements Initializable {

	@FXML
	private TableView<Property> table;
	@FXML
	private TextField searchField;
	@FXML
	private Button searchButton;

	@FXML
	private TableColumn<Property, Integer> bathrooms;

	@FXML
	private TableColumn<Property, Integer> bedrooms;

	@FXML
	private TableColumn<Property, Date> listed;

	@FXML
	private TableColumn<Property, String> garden;

	@FXML
	private TableColumn<Property, String> postcode;

	@FXML
	private TableColumn<Property, Double> rentPerMonth;

	@FXML
	private TableColumn<Property, Double> size;

	@FXML
	private TextArea propertyDetails;
	private Main main;

	ObservableList<Property> list = FXCollections.observableArrayList(
			getUnavailablePropertis()
			);
	public RentedPropertyListController() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("null")
	public ArrayList<Property> getUnavailablePropertis() {
		
		ArrayList<Property> allproperties = DeserializePropertyList.readChildList();

		ArrayList<Property> unavailableList = new ArrayList<Property>() ;
		

		for(int i = 0 ; i<allproperties.size(); i++) {
			if(!allproperties.get(i).getIsAvailable()) 
				unavailableList.add(allproperties.get(i));
		}

		return unavailableList;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println("Property list view Controller");
		main = new Main();

		populatePropertyTable();

		table.setOnMouseClicked(event -> {

			goPropertyDetails();
		});

	}

	private void goPropertyDetails()   {
		main = new Main();
		System.out.println("called goPropertyDetails method: ");

		Property selectedProperty = table.getSelectionModel().getSelectedItem();
		//		propertyDetails.setText(selectedProperty.getDetails());

		try {
			main.showRentedPropertyDetailsView(selectedProperty);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error from go property details method");
		}
	}

	private void populatePropertyTable() {

		listed.setCellValueFactory(new PropertyValueFactory<>("listed"));
		listed.setCellFactory(new CustomDateCellFactory<>("MM/dd/yyyy"));

		bathrooms.setCellValueFactory( new PropertyValueFactory<Property, Integer>("bathrooms"));
		bedrooms.setCellValueFactory( new PropertyValueFactory<Property, Integer>("bedrooms"));
		rentPerMonth.setCellValueFactory( new PropertyValueFactory<Property, Double>("rentPerMonth"));
		size.setCellValueFactory( new PropertyValueFactory<Property, Double>("size"));
		postcode.setCellValueFactory( new PropertyValueFactory<Property, String>("postcode"));
		garden.setCellValueFactory( new PropertyValueFactory<Property, String>("garden"));
		table.setItems(list);

	}

	@FXML
	public void onClickedsearchButton(ActionEvent event) {
		// Get the search criteria from the search field
		String searchCriteria = searchField.getText().toString();

		// Clear the search field
		searchField.setText("");

		// Search the TableView for rows that match the search criteria
		table.getItems().stream()
		.filter(property -> property.getPostcode().toLowerCase().contains(searchCriteria)
				|| property.getPostcode().toLowerCase().contains(searchCriteria))
		.forEach(table::scrollTo);
	}
	
	@FXML
	public void onClickBackButton(ActionEvent event) {
		try {
			main.showHomePage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
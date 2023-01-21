package property;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import filehandler.DeserializePlaceOfInterestList;
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
import property.models.PlaceOfInterest;
import property.models.Property;

public class PlaceOfInterestListVIewController implements Initializable {

	@FXML
	private TableView<PlaceOfInterest> table;
	@FXML
	private TextField searchField;
	@FXML
	private Button searchButton;

	@FXML
	private TableColumn<PlaceOfInterest, Double> latitude;

	@FXML
	private TableColumn<PlaceOfInterest, Double> longitude;

 
	@FXML
	private TableColumn<PlaceOfInterest, String> postcode;

	@FXML
	private TableColumn<PlaceOfInterest, String> name;
	private Main main;

	ObservableList<PlaceOfInterest> list = FXCollections.observableArrayList(
			 DeserializePlaceOfInterestList.readChildList()
			);
	public PlaceOfInterestListVIewController() {
		// TODO Auto-generated constructor stub
	}

 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println("Property list view Controller");
		main = new Main();

		populatePropertyTable();

 

	}

 

	private void populatePropertyTable() {

		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		 
		name.setCellValueFactory( new PropertyValueFactory<PlaceOfInterest, String>("name"));
		postcode.setCellValueFactory( new PropertyValueFactory<PlaceOfInterest, String>("postcode"));
		latitude.setCellValueFactory( new PropertyValueFactory<PlaceOfInterest, Double>("latitude"));
		longitude.setCellValueFactory( new PropertyValueFactory<PlaceOfInterest, Double>("longitude"));
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
		.filter(place -> place.getName().toLowerCase().contains(searchCriteria)
				|| place.getPostcode().toLowerCase().contains(searchCriteria))
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

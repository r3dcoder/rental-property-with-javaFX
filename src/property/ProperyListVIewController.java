package property;

import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import property.models.Property;

public class ProperyListVIewController implements Initializable {

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

	ObservableList<Property> list = FXCollections.observableArrayList(
			DeserializePropertyList.readChildList()
			);
	public ProperyListVIewController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		System.out.println("Property list view Controller");
		
		populatePropertyTable();
		
		// Add an EventHandler to the search button
//        searchButton.setOnAction(event -> searchTable());
	}

	private void populatePropertyTable() {
//		TableColumn<Property, Date> listedColumn = new TableColumn<>("Listed");
		listed.setCellValueFactory(new PropertyValueFactory<>("listed"));
		listed.setCellFactory(new CustomDateCellFactory<>("MM/dd/yyyy"));
 
//		listed.setCellValueFactory( new PropertyValueFactory<Property, Date>("listed"));
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

}

package property;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import customer.models.Customer;
import filehandler.DeserializeCustomerList;
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

public class CustomerListViewController implements Initializable {

	 @FXML
	    private TableColumn<Customer, String> address;
	 @FXML
		private TextField searchField;
	    @FXML
	    private TableView<Customer> customerTable;

	    @FXML
	    private TableColumn<Customer, String> email;

	    @FXML
	    private TableColumn<Customer, String> firstName;
	    
	    @FXML
	    private TableColumn<Customer, String> lastName;

	    @FXML
	    private TableColumn<Customer, String> gender;

	    @FXML
	    private TableColumn<Customer, String> phoneNumber;
	    
	    ObservableList<Customer> list = FXCollections.observableArrayList(
	    		DeserializeCustomerList.readChildList()
				);
	    
	Main main;
	@FXML
	private Button addNewCustomerButton;
	public CustomerListViewController() {
		Main m = new Main();
		this.main = m;
	}
	
	@FXML
	public void onClickAddNewCustomerButton() throws IOException {
		main.showNewCustomerPageView();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		System.out.println("populateCustomerTable list view Controller");
		
		populateCustomerTable();
		
		 
	     
	}
	
	private void populateCustomerTable() {
		
//		firstName.setCellValueFactory(new CustomerValueFactory<>("firstName"));
 
		firstName.setCellValueFactory(new PropertyValueFactory<Customer, String>("firstName"));
		lastName.setCellValueFactory(new PropertyValueFactory<Customer, String>("lastName"));

		phoneNumber.setCellValueFactory( new PropertyValueFactory<Customer, String>("phoneNumber"));
		
		email.setCellValueFactory(new PropertyValueFactory<Customer, String>("email"));
		address.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
		gender.setCellValueFactory(new PropertyValueFactory<Customer, String>("gender"));
		customerTable.setItems(list);
	}
	
	 @FXML
	 public void onClickedsearchButton(ActionEvent event) {
	        // Get the search criteria from the search field
	        String searchCriteria = searchField.getText().toString();

	        // Clear the search field
	        searchField.setText("");

	        // Search the TableView for rows that match the search criteria
	        customerTable.getItems().stream()
	                .filter(customer -> customer.getFirstName().toLowerCase().contains(searchCriteria)
	                        || customer.getFirstName().toLowerCase().contains(searchCriteria))
	                .forEach(customerTable::scrollTo);
	    }

}

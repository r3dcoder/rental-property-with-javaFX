package property;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import customer.models.Customer;
import filehandler.DeserializeCustomerList;
import filehandler.DeserializeInvoiceList;
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
import property.models.Invoice;
import property.models.Property;

public class InvoiceListViewController implements Initializable {

	@FXML
	private TableColumn<Invoice, String> customername;
	@FXML
	private TextField searchField;
	@FXML
	private TableView<Invoice> table;

	@FXML
	private TableColumn<Invoice, String> phonenumber;
	 
	@FXML
	private TableColumn<Invoice, String> startDate;

	@FXML
	private TableColumn<Invoice, String> endDate;

	@FXML
	private TableColumn<Invoice, Double> subtotal;

	ObservableList<Invoice> list = FXCollections.observableArrayList(
			DeserializeInvoiceList.readChildList()
			);

	Main main;
	@FXML
	private Button addNewCustomerButton;
	public InvoiceListViewController() {
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

		table.setOnMouseClicked(event -> {

			showInvoiceViewPaage();
		});

	}

	private void populateCustomerTable() {

		//		firstName.setCellValueFactory(new CustomerValueFactory<>("firstName"));

		customername.setCellValueFactory(new PropertyValueFactory<Invoice, String>("customerFullName"));

		phonenumber.setCellValueFactory( new PropertyValueFactory<Invoice, String>("customerPhoneNumber"));

		subtotal.setCellValueFactory(new PropertyValueFactory<Invoice, Double>("subTotal"));
 
		startDate.setCellValueFactory( new PropertyValueFactory<Invoice, String>("startDate"));

		endDate.setCellValueFactory( new PropertyValueFactory<Invoice, String>("endDate"));

 
		
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
		.filter(invoice -> invoice.getTenant().getFullName().toLowerCase().contains(searchCriteria)
				|| invoice.getInviceDate().toString().toLowerCase().contains(searchCriteria))
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
	
	public void showInvoiceViewPaage() {
		Invoice selected = table.getSelectionModel().getSelectedItem();
		InvoiceController iController = new InvoiceController();
		iController.showInvoicePageView(selected);
	}

}

package property;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.ResourceBundle;

import customer.models.Customer;
import filehandler.DeserializeCustomerList;
import filehandler.DeserializePropertyList;
import filehandler.SerializeChildList;
import helper.ObjectFieldValidation;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import property.models.Invoice;
import property.models.Property;

public class AissignCustomerController implements Initializable {

	@FXML
	private TextField depositeField;

	@FXML
	private DatePicker endDate;

	@FXML
	private ComboBox<Customer> selectuserComboBox;

	@FXML
	private DatePicker startDate;

	private String propertyId ;
	private Property property; 
	private int index;


	public AissignCustomerController() {

	}

	@FXML
	public void onClickedAssignButton(ActionEvent event) throws IOException {

		if(startDate != null && endDate != null && selectuserComboBox.getValue()!=null){
			dateValidation();
			updatePropertyList();
			Customer customer = new Customer();
			String fullName = selectuserComboBox.getValue().toString();
			customer = customer.getCustomer(fullName);

			Invoice invoice = new Invoice(customer, property, startDate.getValue().toString(), endDate.getValue().toString(), 
					200);

			InvoiceController iController = new InvoiceController();
			iController.addOnFile(invoice);
			handleCloseAction(invoice);

		}
		else {
			System.out.println("Please input correctly....");
		}



		try {


		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Please input correctly..");
		}


	}

	public void updatePropertyList() {
		setPropertyFromList();

		ArrayList<Property> list = DeserializePropertyList.readChildList();
		list.get(index).setAvailable(false);
		System.out.println("list index: "+ list.get(index));
		SerializeChildList.writeToFile(list, "property.dat");


	}

	public void setPropertyFromList(){



		ArrayList<Property> list = DeserializePropertyList.readChildList();

		System.out.println("setPropertyFromList");
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getId().equals(propertyId)) {
				//				list.get(i).setAvailable(false);
				index = i;
				setProperty(list.get(i));
				setSubtotal();
				break;
			}
		}
		System.out.println(property + " "+propertyId);
		setSubtotal();
	}


	public void handleCombobox() {

		System.out.println("handleCombobox");

		selectuserComboBox.setItems(FXCollections.observableArrayList(
				DeserializeCustomerList.readChildList()
				));

		selectuserComboBox.setCellFactory( new Callback<ListView<Customer>, ListCell<Customer>>() {
			public ListCell<Customer> call(ListView<Customer> param) {
				final ListCell<Customer> cell = new ListCell<Customer>() {
					@Override
					protected void updateItem(Customer t, boolean bln) {
						super.updateItem(t, bln);

						if (t != null) {
							setText(t.getFullName().toString());
							if(propertyId!=null)setPropertyFromList();

						} else {
							setText(null);
						}
					}
				};
				return cell;
			}
		});


	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		handleCombobox();

	}


	public String getPropertyId() {
		return propertyId;
	}


	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public Property getProperty() {
		return this.property;
	}


	public void setProperty(Property property) {
		this.property = property;
	}

	public void setSubtotal() {

		double deposit = property.getRentPerMonth() * 6;
		double agentFee = property.getRentPerMonth() * 0.2;
		double subTotal =  deposit + agentFee;
		System.out.println("Sub Total: "+ subTotal);
		depositeField.setText(String.valueOf(subTotal));
	}

	public Boolean dateValidation() {

		Period diff = Period.between(
				LocalDate.parse(startDate.getValue().toString()).withDayOfMonth(1),
				LocalDate.parse(startDate.getValue().toString()).withDayOfMonth(1));

		System.out.println("Diff: " + diff);
		if(diff.getMonths()>5) return true;
		else return false;
	}


	public void handleCloseAction(Invoice invoice) {
		Stage stage = (Stage) depositeField.getScene().getWindow();
		stage.close();
		InvoiceController iController = new InvoiceController();
		iController.showInvoicePageView(invoice);
	}

}



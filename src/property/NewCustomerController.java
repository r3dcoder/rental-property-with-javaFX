package property;

import java.util.ArrayList;
import java.util.Date;

import customer.models.Customer;
import filehandler.DeserializeCustomerList;
import filehandler.DeserializePropertyList;
import filehandler.SerializeChildList;
import helper.ObjectFieldValidation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import property.models.Property;

public class NewCustomerController {

	@FXML
    private TextField address;

    @FXML
    private TextField email;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField phoneNumber;
    @FXML
    private RadioButton male;
	@FXML
	private RadioButton female ;
     
    ObservableList<String>genderOptions = FXCollections.observableArrayList("Male", "Female");
    
	public NewCustomerController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@FXML
	public void onClickCustomerSaveButton(ActionEvent event) {
		System.out.println("onClickCustomerSaveButton" + 
				firstName +
				lastName + 
				email + phoneNumber + 
				address  );
		try {
			
			
			 
			String g = male.isSelected() ? "Male" : "Female";
 
			Customer customer = new Customer(firstName.getText().toString(), 
					lastName.getText().toString(), 
					email.getText().toString(), phoneNumber.getText().toString(), 
					address.getText().toString(), g.toString());
			System.out.println(customer);
			ObjectFieldValidation obj = new ObjectFieldValidation(); //checking validation
			
			if(obj.allFieldsAreNotNull(customer)){
				
				ArrayList<Customer> list = DeserializeCustomerList.readChildList();
				list.add(customer);
				SerializeChildList.writeToFile(list, "customer.dat"); 
				list = DeserializeCustomerList.readChildList();
				
//				handleCloseButtonAction(event); //modal close after save
			}
			else {
				System.out.println("Please input correctly");
			}

		} catch (Exception e) {
			System.out.println("Please input correctly");
//			System.out.println(e);
		}		



	}

}

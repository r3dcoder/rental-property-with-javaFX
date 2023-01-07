package property;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;

import filehandler.DeserializePropertyList;
import filehandler.SerializeChildList;
import helper.ObjectFieldValidation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import property.models.Property;
import javafx.fxml.FXML;

public class addNewPropertyController {


	public addNewPropertyController() {
		// TODO Auto-generated constructor stub
	}

	ObservableList<String>options = FXCollections.observableArrayList("y", "n");

	@FXML
	private Date listed;
	@FXML
	private TextField bedrooms;
	@FXML
	private TextField bathrooms;
	@FXML
	private TextField rentPerMonth;
	@FXML
	private TextField size;
	@FXML
	private TextField postcode;
	@FXML
	private TextField latitude;
	@FXML
	private TextField longitude;
	@FXML
	private TextField furnishingStatus;
	@FXML
	private TextField type;
	@FXML
	private RadioButton gardenY ;
	@FXML
	private RadioButton gardenN ;
	@FXML ToggleGroup   gardenGroup;
	
	@FXML 
	Button closeButton;

	@FXML
	public void onClickSaveButton(ActionEvent event) {

		try {
			Date date = new Date();

			Property p = new Property();
			p.setListed(date);
			p.setPostcode(postcode.getText().toString());
			p.setFurnishingStatus(furnishingStatus.getText().toString());
			p.setType(type.getText().toString());

			p.setBathrooms(Integer.parseInt(bathrooms.getText().toString()));
			p.setBedrooms(Integer.parseInt(bedrooms.getText().toString()));
			p.setSize(Double.parseDouble(size.getText().toString()));
			p.setLatitude(Double.parseDouble(latitude.getText().toString()));
			p.setLongitude(Double.parseDouble(longitude.getText().toString()));
			//		 
			p.setRentPerMonth(Double.parseDouble(rentPerMonth.getText().toString()));

			if (gardenY.isSelected()) {
				p.setGarden("y");
				System.out.println("Garden: Yes");
			} else if (gardenN.isSelected()) {
				System.out.println("Garden: No");
				p.setGarden("n");
			}
			
			ObjectFieldValidation obj = new ObjectFieldValidation(); //checking validation
			
			if(obj.allFieldsAreNotNull(p)){
				ArrayList<Property> list = DeserializePropertyList.readChildList();
				list.add(p);
				SerializeChildList.writeToFile(list); 
				list = DeserializePropertyList.readChildList();
				
				handleCloseButtonAction(event); //modal close after save
			}
			else {
				System.out.println("Please input correctly");
			}

		} catch (Exception e) {
			System.out.println("Please input correctly");
//			System.out.println(e);
		}		



	}
	
	 @FXML
	 public void handleCloseButtonAction(ActionEvent event) {
	   Stage stage = (Stage) closeButton.getScene().getWindow();
	   stage.close();
	 }

	


}

package property;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import property.models.Property;

public class PropertyDetailsController {
	
	private Property property;
	@FXML 
	private TextArea propertyDetails;
	public PropertyDetailsController() {
		 
		 
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		System.out.println("Set Property: " + property.getDetails());
		this.property = property;
		updateUI();
	}
	
	public String getDetails() {
		return property.getDetails();
	}
	
	private void updateUI() {
		propertyDetails.setText(getDetails());
	}
	
	

}

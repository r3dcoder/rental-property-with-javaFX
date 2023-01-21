module propertyrental {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires itextpdf;
	requires junit;
 	
	opens property.models;
	opens jUnitTest;
	opens customer.models;
	opens property to javafx.graphics, javafx.fxml;
 }

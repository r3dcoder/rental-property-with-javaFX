module propertyrental {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires itextpdf;
	opens property.models;
	opens customer.models;
	opens property to javafx.graphics, javafx.fxml;
 }

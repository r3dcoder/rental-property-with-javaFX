package property;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import property.models.Invoice;

public class InvoiceController  implements Initializable  {

	@FXML
    private Button downloadButton;

    @FXML
    private TextArea invoiceText;
    
    private Invoice invoice;
    
	public InvoiceController() {
		// TODO Auto-generated constructor stub
	}
	
	public void createInvoice(Invoice invoice) {
		
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		if(invoiceText!=null) invoiceText.setText(invoice.toString());
		this.invoice = invoice;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		invoiceText.setText(invoice.toString());
		
	}

}

package property;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.itextpdf.text.Paragraph;

import filehandler.DeserializeInvoiceList;
import filehandler.SerializeChildList;
import helper.ConvertToPdf;
import javafx.event.ActionEvent;
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

	public void showInvoicePageView(Invoice invoice) {
		Main main = new Main();
		try {
			main.showInvoiceDetailsView(invoice);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		if(invoiceText!=null) invoiceText.setText(invoice.toString());
		this.invoice = invoice;

	}
	
	public void  addOnFile(Invoice invoice) {
		ArrayList<Invoice> list =  DeserializeInvoiceList.readChildList();
		try {
			list = DeserializeInvoiceList.readChildList();
		} catch (Exception e) {
			System.out.println("Error from DeserializeInvoiceList");
			// TODO: handle exception
		}

		list.add(invoice);
		SerializeChildList.writeToFile(list, "invoice.dat");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//		invoiceText.setText(invoice.toString());

	}

	@FXML
	public void onClickSavePdfButton(ActionEvent event) {
		Paragraph p = new Paragraph();
		p.add(invoice.toString());

		ConvertToPdf cPDF = new ConvertToPdf(p, "Inoice "+ invoice.getInviceDate().toString());
	}
	@FXML
	public void onClickHomeButton(ActionEvent event) {
		Main main = new Main();
		try {
			main.showHomePage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

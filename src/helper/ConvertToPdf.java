package helper;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.scene.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class ConvertToPdf {
	public  ConvertToPdf(Paragraph p, String pdfFile) {
		Document document = new Document();

		try {
	        PdfWriter.getInstance(document, new FileOutputStream(new File(pdfFile)));

	        //open
	        document.open();

	        document.add((Element) p);


	        document.close();

	        System.out.println("PDF Done");
	        
		} catch (Exception e) {
			// TODO: handle exception
		}
        
	}
}

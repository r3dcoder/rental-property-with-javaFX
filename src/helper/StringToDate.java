package helper;
import java.text.SimpleDateFormat;
import java.util.Date;

 public class StringToDate {
     
        String dateString = "26-06-2022"; // The string to be converted
        String dateFormat = "dd/MM/yyyy"; // The format of the string
        public StringToDate(String dateString) {
        	this.dateString = dateString;
        }
        
        public Date getDate() throws Exception {
        	
        	SimpleDateFormat sdf = new SimpleDateFormat(dateFormat); // Create a SimpleDateFormat object with the specified format
            Date date = sdf.parse(dateString); // Parse the string and create a Date object
            System.out.println(date);
            return  date;
        }
}
 

package helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UniqueIdGenerator {

	public UniqueIdGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	public String  getUniqueID(){
	    DateFormat dateFormat = new SimpleDateFormat("yyddmm");
	    Date date = new Date();
	    String dt=String.valueOf(dateFormat.format(date));
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat time = new SimpleDateFormat("HHmmss");
	    String tm= String.valueOf(time.format(new Date()));//time in 24 hour format
	    String id= dt+tm;
	    int random_int = (int)Math.floor(Math.random() * (1001 - 1111 + 1) + 1111);
	      // Printing the generated random numbers
 	    return id+String.valueOf(random_int);   
	}


}

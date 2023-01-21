package property.models;

import java.io.Serializable;

public class PlaceOfInterest  implements Serializable  {
    private static final long serialVersionUID = 1L;
	private String name;
    private String postcode;
    private double latitude;
    private double longitude;
    
    public PlaceOfInterest(String name, String postcode, double latitude, double longitude) {
        this.name = name;
        this.postcode = postcode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPostcode() {
		return postcode;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String toString() {
		String str = "Name: "+ name + " post code: "+ postcode + " lat " + latitude + " lon : "+ longitude;
		return str;
	}
}


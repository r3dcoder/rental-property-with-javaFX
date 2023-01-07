package property.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Property  implements Serializable {
    private static final long serialVersionUID = 1L;
	private Date listed;
    private int bedrooms;
    private int bathrooms;
    private double rentPerMonth;
    private double size;
    private String postcode;
    private double latitude;
    private double longitude;
    private String furnishingStatus;
    private String type;
    private String garden;
    
    public Property() {
    
    }
    
    
    public Property(
    		Date listed, int bedrooms, int bathrooms, 
    		double rentPerMonth, 
    		double size, String postcode, double latitude, 
    		double longitude, String furnishingStatus, String type, String garden) {
    	
        this.listed = listed;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.rentPerMonth = rentPerMonth;
        this.size = size;
        this.postcode = postcode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.furnishingStatus = furnishingStatus;
        this.type = type;
        this.garden = garden;
    }

    public Date getListed() {
    	 
        return listed;
    }
    
    public void setListed(Date d) {
        this.listed = d;
    }

    public int getBedrooms() {
        return bedrooms;
    }
    
    public void setBedrooms(int n) {
        this.bedrooms = n;
    }

    public int getBathrooms() {
        return bathrooms;
    }
    public void setBathrooms(int n) {
        this.bathrooms = n;
    }

    public double getRentPerMonth() {
        return rentPerMonth;
    }
    
    public void setRentPerMonth(double n) {
        this.rentPerMonth = n;
    }

    public double getSize() {
        return size;
    }
    public void setSize(double n) {
        this.size = n;
    }

    public String getPostcode() {
        return postcode;
    }
    
    public void setPostcode(String code) {
        this.postcode = code;
    }

    public double getLatitude() {
        return latitude;
    }
    
    public void setLatitude(double lat) {
        this.latitude = lat;
    }

    public double getLongitude() {
        return longitude;
    }
    
    public void setLongitude(double lon) {
        this.longitude = lon;
    }

    public String getFurnishingStatus() {
        return furnishingStatus;
    }
    
    public void setFurnishingStatus(String status) {
        this.furnishingStatus = status;
        		
    }

    public String getType() {
        return type;
    }
    public void setType(String t) {
        this.type = t;
    }

    public String getGarden() {
        return garden;
    }
    
    public void setGarden( String garden) {
        this.garden = garden;
    }
    
    
    public String getDetails() {
        StringBuilder sb = new StringBuilder();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = sdf.format(listed);
        
        sb.append("Property Details:\n");
        sb.append("-----------------\n");
        sb.append("Listed: ").append(formattedDate).append("\n");
        sb.append("\n");
        sb.append("Bedrooms: ").append(this.getBedrooms()).append("\n");
        sb.append("\n");
        sb.append("Bathrooms: ").append(this.getBathrooms()).append("\n");
        sb.append("\n");
        sb.append("Rent per month: ").append(this.getRentPerMonth()).append("\n");
        sb.append("\n");
        sb.append("Size: ").append(this.getSize()).append("\n");
        sb.append("\n");
        sb.append("Postcode: ").append(this.getPostcode()).append("\n");
        sb.append("\n");
        sb.append("Latitude: ").append(this.getLatitude()).append("\n");
        sb.append("\n");
        sb.append("Longitude: ").append(this.getLongitude()).append("\n");
        sb.append("\n");
        sb.append("Furnishing status: ").append(this.getFurnishingStatus()).append("\n");
        sb.append("\n");
        sb.append("Type: ").append(this.getType()).append("\n");
        sb.append("\n");
        sb.append("Garden: ").append(this.getGarden()).append("\n");
        sb.append("\n");
        return sb.toString();
    }
    
    public String toString() {
    	return getDetails();
    }

}

package jUnitTest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.junit.Test;

import property.models.Property;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

 

public class PropertyTest {

    @Test
    public void testGetDetails() {
        Date listed = new Date();
        
        Property property = new Property(listed, 2, 1,
        		1000, 100, "12345", 
        		10.0, 20.0, "Furnished",
        		"Apartment", "Yes");
        
         System.out.print(property);
        
        String expected = getDetails( property.getListed(), property.getId(), 2,
        		1, 1000, 100, "12345",
        		10.0, 
        		20.0, 
        		"Furnished", "Apartment", "Yes",  true);
        System.out.print(expected);
         assertEquals(expected, property.getDetails());
    }
    
    @Test
    public void testSetters() {
        Property property = new Property();
        
        Date listed = new Date();
        property.setListed(listed);
        property.setBedrooms(3);
        property.setBathrooms(2);
        property.setRentPerMonth(1200);
        property.setSize(150);
        property.setPostcode("54321");
        property.setLatitude(15.0);
        property.setLongitude(25.0);
        property.setFurnishingStatus("Unfurnished");
        property.setType("House");
        property.setGarden("No");
        
        assertEquals(listed, property.getListed());
        assertEquals(3, property.getBedrooms());
        assertEquals(2, property.getBathrooms());
        assertEquals(1200, property.getRentPerMonth(),0.1);
        assertEquals(150, property.getSize(), 0.1);
        assertEquals("54321", property.getPostcode());
        assertEquals(15.0, property.getLatitude(), 0.1);
        assertEquals(25.0, property.getLongitude(), 0.1);
        assertEquals("Unfurnished", property.getFurnishingStatus());
        assertEquals("House", property.getType());
        assertEquals("No", property.getGarden());
    }
    
    @Test
    public void testUniqueId() {
        Property property1 = new Property();
        Property property2 = new Property();
        
        assertNotEquals(property1.getId(), property2.getId());
    }
    
    public String getDetails(Date listed, String id,int bedrooms,
    		int bathrooms, double rpm, double size, String postcode, double latitude, 
    		double longitude, 
    		String Fstatus, String type, String garden, boolean available) {
        StringBuilder sb = new StringBuilder();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = sdf.format(listed);
        
        sb.append("Property Details:\n");
        sb.append("-----------------\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Listed: ").append(formattedDate).append("\n");
        sb.append("\n");
        sb.append("Bedrooms: ").append(bedrooms).append("\n");
        sb.append("\n");
        sb.append("Bathrooms: ").append(bathrooms).append("\n");
        sb.append("\n");
        sb.append("Rent per month: ").append(rpm).append("\n");
        sb.append("\n");
        sb.append("Size: ").append(size).append("\n");
        sb.append("\n");
        sb.append("Postcode: ").append(postcode).append("\n");
        sb.append("\n");
        sb.append("Latitude: ").append(latitude).append("\n");
        sb.append("\n");
        sb.append("Longitude: ").append(longitude).append("\n");
        sb.append("\n");
        sb.append("Furnishing status: ").append(Fstatus).append("\n");
        sb.append("\n");
        sb.append("Type: ").append(type).append("\n");
        sb.append("\n");
        sb.append("Garden: ").append(garden).append("\n");
        sb.append("\n");
        sb.append("Available: ").append(available).append("\n");
        return sb.toString();
    }
}

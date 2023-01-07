package property.models;

public class PlaceOfInterest {
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

    public String getPostcode() {
        return postcode;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}


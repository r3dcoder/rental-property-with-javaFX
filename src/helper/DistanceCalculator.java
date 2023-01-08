package helper;

import java.text.DecimalFormat;

public class DistanceCalculator {

	private double lat1; 
	private double lon1; 
	private double lat2; 
	private double lon2; 
	String unit;
	
	public DistanceCalculator(
			double lat1, double lon1, 
			double lat2, double lon2, String unit) {
		 
		this.lat1 = lat1;
		this.lon1 = lon1;
		this.lat2 = lat2;
		this.lon2 = lon2;
		this.unit = unit;
	}


	 public double getDistance() {
		double dist = 0;
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return dist;
		}
		else {
			double theta = lon1 - lon2;
			 dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit.equals("K")) {
				dist = dist * 1.609344;
			} else if (unit.equals("M")) {
				dist = dist * 0.8684;
			}
			
			
 			return (dist);
		}
	}
	 
	public String toString() {
		String str  ="lat1 : "+ lat1 + ' ' + lon1+ ' ' + lat2 + ' ' + lon2+ ' ' ;
//		System.out.println(str);
		return str;

	}
}

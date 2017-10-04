

import java.lang.Math.*;

public class Location {
	public final double r = 6378.1; //radius of the earth in km
	public final double lo;
	public final double la;
	public final String Label;
	public final double cosla;
	
	

	// constructor
	public Location(String label, double latitudeDeg, double longitudeDeg) {
		
		Label = label;
		lo = (longitudeDeg*Math.PI/180);
		la = (latitudeDeg*Math.PI/180);
		cosla = Math.cos(this.la);
		
	}
	// compute the distance between the pathArray "this" and "other"
	public double dist(Location other) {
		double sin2la = Math.pow(Math.sin((other.la-this.la)/2), 2.0); //the latitude sin squared
		double sin2lo = Math.pow(Math.sin((other.lo-this.lo)/2), 2.0); //the longitude sin squared
		double route = Math.pow(sin2la+cosla*Math.cos(other.la)*sin2lo, 0.5); //all of the stuff under the route
		return 2*r*Math.asin(route); //the actual distance
	}
	// gives the label of this Location
	public String getLabel() {
		return this.Label;
	}
	// gives the Latitude in Degrees
	public double getLatitudeDeg() {
		return this.la;
	}
	// gives the Longitude in Degrees
	public double getLongitudeDeg() {
		return this.lo;
	}
	// (optional) draw Label at the Location using StdDraw
	public void draw() {
	}
	
}

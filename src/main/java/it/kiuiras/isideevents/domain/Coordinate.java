package it.kiuiras.isideevents.domain;

/**
 * A class that represents a point on the Earth's surface with its latitude and longitude
 */
public class Coordinate {

    private double latitude;
    private double longitude;

    public Coordinate (double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Coordinate [latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append("]");
		return builder.toString();
	}
    
    
}

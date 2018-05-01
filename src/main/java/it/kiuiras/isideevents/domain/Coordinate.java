package it.kiuiras.isideevents.domain;

import lombok.Data;

/**
 * A class that represents a point on the Earth's surface with its latitude and
 * longitude
 */
@Data
public class Coordinate {

	private double latitude;
	private double longitude;

	/**
	 * Public default parametric constructor.
	 * 
	 * @param latitude
	 * @param longitude
	 */
	public Coordinate(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
}

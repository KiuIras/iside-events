package it.kiuiras.isideevents.domain;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * A class that represents a seismic event.
 */
@Data
public class Earthquake {

	private int id;
	private Coordinate coordinate;
	private double depth;
	private LocalDateTime date;
	private double magnitude;
	private String location;

	/**
	 * Public parametric constructor of a {@link Earthquake} object.
	 * 
	 * @param id
	 *            the unique identifier of the Earthquake
	 * @param coordinate
	 *            the {@link Coordinate} of the Earthquake
	 * @param depth
	 *            the depth of the Earthquake in km
	 * @param date
	 *            the {@link LocalDateTime} of the Earthquake
	 * @param magnitude
	 *            the magnitude of the Earthquake
	 * @param location
	 *            the name of the location of the Earthquake
	 */
	public Earthquake(int id, Coordinate coordinate, double depth, LocalDateTime date, double magnitude,
			String location) {
		this.setId(id);
		this.setCoordinate(coordinate);
		this.setDepth(depth);
		this.setDate(date);
		this.setMagnitude(magnitude);
		this.setLocation(location);
	}
}

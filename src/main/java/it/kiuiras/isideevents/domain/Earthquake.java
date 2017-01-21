package it.kiuiras.isideevents.domain;

import java.time.LocalDateTime;

/**
 * A class that represents a seismic event
 */
public class Earthquake {

    private int id;
    private Coordinate coordinate;
    private double depth;
    private LocalDateTime date;
    private double magnitude;
    private String location;

    public Earthquake (int id, Coordinate coordinate, double depth, LocalDateTime date, double magnitude, String location) {
        this.setId(id);
        this.setCoordinate(coordinate);
        this.setDepth(depth);
        this.setDate(date);
        this.setMagnitude(magnitude);
        this.setLocation(location);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Earthquake [id=");
		builder.append(id);
		builder.append(", coordinate=");
		builder.append(coordinate);
		builder.append(", depth=");
		builder.append(depth);
		builder.append(", date=");
		builder.append(date);
		builder.append(", magnitude=");
		builder.append(magnitude);
		builder.append(", location=");
		builder.append(location);
		builder.append("]");
		return builder.toString();
	}
    
    

}

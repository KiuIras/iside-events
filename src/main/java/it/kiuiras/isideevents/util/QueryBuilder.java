package it.kiuiras.isideevents.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import it.kiuiras.isideevents.domain.Coordinate;

/**
 * A "static" utility class that implements methods to build valid {@link URL}s
 * that fetch events from ISIDe API.
 */
public final class QueryBuilder {

	/**
	 * A private constructor that does not allow anybody to create instances of this
	 * "static" class.
	 */
	private QueryBuilder() {
	}

	/**
	 * Method to build a {@link URL} that fetches last event
	 *
	 * @return a {@link URL} that fetches last event
	 * @throws MalformedURLException
	 */
	public static URL lastEventQuery() throws MalformedURLException {
		return buildUrl("starttime=2000-01-01T00:00:00&limit=1&");
	}

	/**
	 * Method to build a {@link URL} that fetches all events from a start time.
	 *
	 * @param time
	 *            the time after which the events are to be fetched
	 * @return a URL that fetches events from a specified start time
	 * @throws MalformedURLException
	 *
	 */
	public static URL eventsQuery(LocalDateTime time) throws MalformedURLException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		return buildUrl("starttime=" + time.format(formatter) + "&");
	}

	/**
	 * Method to build a URL that fetches all events in a specified period of time
	 *
	 * @param startTime
	 *            the time after which the events are to be fetched
	 * @param endTime
	 *            the time before which the events are to be fetched
	 * @return a URL that fetches events in a specified period of time
	 * @throws MalformedURLException
	 */
	public static URL eventsQuery(LocalDateTime startTime, LocalDateTime endTime) throws MalformedURLException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		return buildUrl("starttime=" + startTime.format(formatter) + "&endtime=" + endTime.format(formatter) + "&");
	}

	/**
	 * Method to build a URL that fetches all events in a specified period of time
	 * in a rectangle bounded from two points.
	 *
	 * @param startTime
	 *            the time after which the events are to be fetched
	 * @param endTime
	 *            the time before which the events are to be fetched
	 * @param p1
	 *            the point with minimum latitude and longitude
	 * @param p2
	 *            the point with maximum latitude and longitude
	 * @return a URL that fetches events in a specified period of time
	 * @throws MalformedURLException
	 */
	public static URL eventsQuery(LocalDateTime startTime, LocalDateTime endTime, Coordinate p1, Coordinate p2)
			throws MalformedURLException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		return buildUrl("starttime=" + startTime.format(formatter) + "&endtime=" + endTime.format(formatter)
				+ "&minlat=" + p1.getLatitude() + "&minlon=" + p1.getLongitude() + "&maxlat=" + p2.getLatitude()
				+ "&maxlon=" + p2.getLongitude() + "&");
	}

	/**
	 * Method to build a {@link URL} that fetches all events from a start time in a
	 * rectangle bounded from two points.
	 *
	 * @param time
	 *            the time after which the events are to be fetched
	 * @param p1
	 *            the point with minimum latitude and longitude
	 * @param p2
	 *            the point with maximum latitude and longitude
	 * @return a {@link URL} that fetches events in a specified period of time
	 * @throws MalformedURLException
	 */
	public static URL eventsQuery(LocalDateTime time, Coordinate p1, Coordinate p2) throws MalformedURLException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		return buildUrl("starttime=" + time.format(formatter) + "&minlat=" + p1.getLatitude() + "&minlon="
				+ p1.getLongitude() + "&maxlat=" + p2.getLatitude() + "&maxlon=" + p2.getLongitude() + "&");
	}

	/**
	 * A private method to build a valid ISIDe {@link URL}.
	 *
	 * @param query
	 *            the "parameters" part
	 * @return a valid ISIDe {@link URL}
	 * @throws MalformedURLException
	 */
	private static URL buildUrl(String query) throws MalformedURLException {
		return new URL("http://webservices.ingv.it/fdsnws/event/1/query?" + query + "format=text");
	}

}

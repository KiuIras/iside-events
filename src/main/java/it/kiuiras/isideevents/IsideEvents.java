package it.kiuiras.isideevents;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

import it.kiuiras.isideevents.domain.Coordinate;
import it.kiuiras.isideevents.domain.Earthquake;
import it.kiuiras.isideevents.util.Parser;
import it.kiuiras.isideevents.util.QueryBuilder;

/**
 * {@link IsideEvents} provides static methods to retrieve {@link Earthquake}
 * objects from INGV's FDSN web service.
 * 
 * @author Andrea Grossi
 */
public class IsideEvents {

	/**
	 * Retrieve last {@link Earthquake}.
	 * 
	 * @return instance of last {@link Earthquake}
	 * @throws IOException
	 *             if an I/O exception occurs
	 */
	public static Earthquake getLastEvent() throws IOException {
		URL url = QueryBuilder.lastEventQuery();
		return Parser.parse(url).get(0);
	}

	/**
	 * Retrieve a list of {@link Earthquake}s on or after the specified start time.
	 * 
	 * @param time
	 *            start {@link LocalDateTime}
	 * @return {@link List} of {@link Earthquake}s from given {@link LocalDateTime}
	 * @throws IOException
	 *             if an I/O exception occurs
	 */
	public static List<Earthquake> getEvents(LocalDateTime time) throws IOException {
		URL url = QueryBuilder.eventsQuery(time);
		return Parser.parse(url);
	}

	/**
	 * Retrieve a {@link List} of {@link Earthquake}s between start
	 * {@link LocalDateTime} and end {@link LocalDateTime}.
	 * 
	 * @param startTime
	 *            start {@link LocalDateTime}
	 * @param endTime
	 *            end {@link LocalDateTime}
	 * @return {@link List} of {@link Earthquake}s in given range of time
	 * @throws IOException
	 *             if an I/O exception occurs
	 */
	public static List<Earthquake> getEvents(LocalDateTime startTime, LocalDateTime endTime) throws IOException {
		URL url = QueryBuilder.eventsQuery(startTime, endTime);
		return Parser.parse(url);
	}

	/**
	 * Retrieve a {@link List} of {@link Earthquake}s between start
	 * {@link LocalDateTime} and end {@link LocalDateTime} within geographic
	 * constraints.
	 * 
	 * @param startTime
	 *            start {@link LocalDateTime}
	 * @param endTime
	 *            end {@link LocalDateTime}
	 * @param p1
	 *            minimum latitude and longitude expressed as {@link Coordinate}
	 * @param p2
	 *            maximum latitude and longitude expressed as {@link Coordinate}
	 * @return {@link List} of {@link Earthquake}s in given range of
	 *         {@link LocalDateTime}s within geographic constraints.
	 * @throws IOException
	 *             if an I/O exception occurs
	 */
	public static List<Earthquake> getEvents(LocalDateTime startTime, LocalDateTime endTime, Coordinate p1,
			Coordinate p2) throws IOException {
		URL url = QueryBuilder.eventsQuery(startTime, endTime, p1, p2);
		return Parser.parse(url);
	}

	/**
	 * Retrieve a {@link List} of {@link Earthquake}s on or after the specified
	 * start {@link LocalDateTime} within geographic constraints.
	 * 
	 * @param time
	 *            start {@link LocalDateTime}
	 * @param p1
	 *            minimum latitude and longitude expressed as {@link Coordinate}
	 * @param p2
	 *            maximum latitude and longitude expressed as {@link Coordinate}
	 * @return {@link List} of {@link Earthquake}s from a given
	 *         {@link LocalDateTime} within geographic constraints
	 * @throws IOException
	 *             if an I/O exception occurs
	 */
	public static List<Earthquake> getEvents(LocalDateTime time, Coordinate p1, Coordinate p2) throws IOException {
		URL url = QueryBuilder.eventsQuery(time, p1, p2);
		return Parser.parse(url);
	}

	/**
	 * Main method. Only for test purpose.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Print last event
			System.out.println("Last event: " + getLastEvent().toString());

			// Print events of last 10 days with magnitude >= 2.5
			for (Earthquake e : getEvents(LocalDateTime.now().minusDays(10))) {
				if (e.getMagnitude() > 2.5)
					System.out.println(e.getLocation() + ", " + e.getMagnitude());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

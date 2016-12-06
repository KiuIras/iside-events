package it.kiuiras.isideevents;

import static org.junit.Assert.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;

import it.kiuiras.isideevents.domain.Coordinate;
import it.kiuiras.isideevents.domain.Earthquake;

public class IsideEventsTest {

	@Test
	public void testGetLastEvent() {
		Earthquake last = null;
		try {
			last = IsideEvents.getLastEvent();
		} catch (IOException e) {
			e.printStackTrace();
			fail("Can't get last earthquake");
		}
		assertEquals("Last earthquake must be an earthquake",last.getClass(),Earthquake.class);
	}

	@Test
	public void testGetEventsLocalDateTime() {
		ArrayList<Earthquake> es = new ArrayList<>();
		try {
			es = (ArrayList<Earthquake>) IsideEvents.getEvents(LocalDateTime.now().minusDays(10));
		} catch (IOException e) {
			e.printStackTrace();
			fail("Can't get earthquakes");
		}
		for(Earthquake e : es) {
			assertEquals("Earthquakes must be earthquakes",e.getClass(),Earthquake.class);
		}
	}

	@Test
	public void testGetEventsLocalDateTimeLocalDateTime() {
		ArrayList<Earthquake> es = new ArrayList<>();
		try {
			es = (ArrayList<Earthquake>) IsideEvents.getEvents(LocalDateTime.now().minusDays(10),LocalDateTime.now().minusDays(5));
		} catch (IOException e) {
			e.printStackTrace();
			fail("Can't get earthquakes");
		}
		for(Earthquake e : es) {
			assertEquals("Earthquakes must be earthquakes",e.getClass(),Earthquake.class);
		}
	}

	@Test
	public void testGetEventsLocalDateTimeLocalDateTimeCoordinateCoordinate() {
		ArrayList<Earthquake> es = new ArrayList<>();
		try {
			es = (ArrayList<Earthquake>) IsideEvents.getEvents(LocalDateTime.now().minusDays(10),LocalDateTime.now().minusDays(5),new Coordinate(0,0), new Coordinate(90,90));
		} catch (IOException e) {
			e.printStackTrace();
			fail("Can't get earthquakes");
		}
		for(Earthquake e : es) {
			assertEquals("Earthquakes must be earthquakes",e.getClass(),Earthquake.class);
		}
	}

	@Test
	public void testGetEventsLocalDateTimeCoordinateCoordinate() {
		ArrayList<Earthquake> es = new ArrayList<>();
		try {
			es = (ArrayList<Earthquake>) IsideEvents.getEvents(LocalDateTime.now().minusDays(10),LocalDateTime.now().minusDays(5),new Coordinate(0,0), new Coordinate(90,90));
		} catch (IOException e) {
			e.printStackTrace();
			fail("Can't get earthquakes");
		}
		for(Earthquake e : es) {
			assertEquals("Earthquakes must be earthquakes",e.getClass(),Earthquake.class);
		}
	}

}

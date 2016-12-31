package it.kiuiras.isideevents;

import it.kiuiras.isideevents.domain.Coordinate;
import it.kiuiras.isideevents.domain.Earthquake;
import it.kiuiras.isideevents.util.Parser;
import it.kiuiras.isideevents.util.QueryBuilder;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

public class IsideEvents {

    public static void main(String[] args) {
        //	EXAMPLE
    	try {
        	//	Print last event
        	System.out.println("Ultimo evento " + getLastEvent().getLocation());
            
        	//	Print events of last 10 days
            for (Earthquake e : getEvents(LocalDateTime.now().minusDays(10))
                 ) {
                if (e.getMagnitude() > 2.5)
                System.out.println(e.getLocation() + ", "+ e.getMagnitude());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieve last earthquake.
     * 
     * @return instance of last earthquake
     * @throws IOException
     */
    public static Earthquake getLastEvent() throws IOException {
        URL url = QueryBuilder.lastEventQuery();
        return Parser.parse(url).get(0);
    }

    /**
     * Retrieve a list of earthquakes on or after the specified start time.
     * 
     * @param time			start time
     * @return				list of earthquakes from given time
     * @throws IOException
     */
    public static List<Earthquake> getEvents(LocalDateTime time) throws IOException {
        URL url = QueryBuilder.eventsQuery(time);
        return Parser.parse(url);
    }

    /**
     * Retrieve a list of earthquakes between start time and end time.
     * 
     * @param startTime		start time
     * @param endTime		end time
     * @return				list of earthquakes in given range of time
     * @throws IOException
     */
    public static List<Earthquake> getEvents(LocalDateTime startTime, LocalDateTime endTime) throws IOException {
        URL url = QueryBuilder.eventsQuery(startTime, endTime);
        return Parser.parse(url);
    }

    /**
     * Retrieve a list of earthquakes between start time and end time within geographic constraints.
     * 
     * @param startTime		start time
     * @param endTime		end time
     * @param p1			minimum latitude and longitude
     * @param p2			maximum latitude and longitude
     * @return				list of earthquakes in given range of time within geographic constraints.
     * @throws IOException
     */
    public static List<Earthquake> getEvents(LocalDateTime startTime, LocalDateTime endTime, Coordinate p1, Coordinate p2) throws IOException {
        URL url = QueryBuilder.eventsQuery(startTime, endTime, p1, p2);
        return Parser.parse(url);
    }

    /**
     * Retrieve a list of earthquakes on or after the specified start time within geographic constraints.
     * 
     * @param time			start time
     * @param p1			minimum latitude and longitude
     * @param p2			maximum latitude and longitude
     * @return				list of earthquake from a given time within geographic constraints
     * @throws IOException
     */
    public static List<Earthquake> getEvents(LocalDateTime time, Coordinate p1, Coordinate p2) throws IOException {
        URL url = QueryBuilder.eventsQuery(time, p1, p2);
        return Parser.parse(url);
    }
}

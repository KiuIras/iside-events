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
        try {
            System.out.println("Ultimo evento " + getLastEvent().getLocation());
            for (Earthquake e : getEvents(LocalDateTime.parse("2016-11-15T00:00:00"))
                 ) {
                if (e.getMagnitude() > 2.5)
                System.out.println(e.getLocation() + ", "+ e.getMagnitude());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Earthquake getLastEvent() throws IOException {
        URL url = QueryBuilder.lastEventQuery();
        return Parser.parse(url).get(0);
    }

    public static List<Earthquake> getEvents(LocalDateTime time) throws IOException {
        URL url = QueryBuilder.eventsQuery(time);
        return Parser.parse(url);
    }

    public static List<Earthquake> getEvents(LocalDateTime startTime, LocalDateTime endTime) throws IOException {
        URL url = QueryBuilder.eventsQuery(startTime, endTime);
        return Parser.parse(url);
    }

    public static List<Earthquake> getEvents(LocalDateTime startTime, LocalDateTime endTime, Coordinate p1, Coordinate p2) throws IOException {
        URL url = QueryBuilder.eventsQuery(startTime, endTime, p1, p2);
        return Parser.parse(url);
    }

    public static List<Earthquake> getEvents(LocalDateTime time, Coordinate p1, Coordinate p2) throws IOException {
        URL url = QueryBuilder.eventsQuery(time, p1, p2);
        return Parser.parse(url);
    }
}

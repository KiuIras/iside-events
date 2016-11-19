package it.kiuiras.isideevents.util;

import it.kiuiras.isideevents.domain.Coordinate;
import it.kiuiras.isideevents.domain.Earthquake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * A "static" class that implements methods to parse ISIDe API response
 */
public final class Parser {

    /**
     * A private constructor that does not allow anybody to create instances of this "static" class
     */
    private Parser() {
    }

    /**
     * Method to parse results from a ISIDe API call to a given URL
     *
     * @param url URL to visit
     * @return an ArrayList of Earthquake objects from results
     * @throws IOException
     */
    public static ArrayList<Earthquake> parse(URL url) throws IOException {
        ArrayList<Earthquake> earthquakes = new ArrayList<Earthquake>();
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        br.readLine();  // ignores the header
        String line = br.readLine();
        while(line != null) {
            String[] eventInfo = line.split("\\|");
            earthquakes.add(new Earthquake(Integer.parseInt(eventInfo[0]), new Coordinate(Double.parseDouble(eventInfo[2]),Double.parseDouble(eventInfo[3])), Double.parseDouble(eventInfo[4]), LocalDateTime.parse(eventInfo[1]), Double.parseDouble(eventInfo[10]), eventInfo[12]));
            line = br.readLine();
        }
        return earthquakes;
    }

}

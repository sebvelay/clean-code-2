package supple.iri;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    @Test
    public void should_retrieve_departure_airport_from_flight() {
        Flight f = Flight.from(City.Paris).to(City.Tokyo);
        f.setSuffix("CDG");

        assertEquals("Paris-Tokyo-CDG", f.getCode());
        assertEquals("CDG", f.getSuffix());
    }

}
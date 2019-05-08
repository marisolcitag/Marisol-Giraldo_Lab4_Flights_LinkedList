package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Date;
import model.Flight;
import model.Time;

class FlightTest {

	private Flight flight;
	
	public void setupScenary1() {
		flight = null;
	}
	
	@Test
	public void createFlightTest() {
		setupScenary1();
		Date date = new Date(7, 5, 2019);
		Time time = new Time(9,24,55);
		String airline = "Avianca";
		String flightNumber = "AV12345";
		String destination = "Hawai";
		String gate = "A10";
		flight = new Flight(date, time, airline, flightNumber, destination, gate);
		assertTrue("The Date was not assigned correctly", date.compareTo(flight.getDate()) == 0);
		assertTrue("The Airline was not assigned correctly", airline.equals(flight.getAirline()));
		assertTrue("The Flight number was not assigned correctly", flightNumber == flight.getNumFlight());
		assertTrue("The Destination was not assigned correctly", destination.equals(flight.getDestination()));
		assertTrue("The Gates were not assigned correctly", gate == flight.getGate());
		
		try {
			date = new Date(14, 24, 2019);
			airline = "Wingo";
			flightNumber = "W444";
			destination = "Medellin";
			gate = "W23";
			new Flight(date, time, airline, flightNumber, destination, gate);
			fail("The date should not have been created as the parameters were invalid");
		}
		catch(IllegalArgumentException iae) {
			assertTrue(true);
		}
	}
}

/**
 * 
 */
package com.chef.flighttransport.dao;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.chef.flighttransport.domain.Flight;

/**
 * @author Implement the Database operations for the flight
 */
@Repository
@Scope("singleton")
public class FlightRespoitoryImpl implements FlightRepository, ApplicationRunner {

	// Flights Details List
	private ArrayList<Flight> flights;

	private static int counter = 1001;

	@Override
	public void insert(Flight flight) {
		// Inserts the new Flight details into the arraylist
		flight.setFlightId(Integer.toString(++counter));
		this.flights.add(flight);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		/**
		 * Add the flight details when the bean is loaded into spring container
		 */
		this.flights = new ArrayList<Flight>();
		Flight flight1 = new Flight();
		flight1.setAirlines("Qatar");
		flight1.setDestination("Dublin");
		flight1.setFlightId(Integer.toString(counter));
		flight1.setFare(50000.30);
		flight1.setSource("Nagpur");
		flight1.setSeatCount(290);
		flight1.setJourneyDate(LocalDate.parse("2024-10-28"));
		this.flights.add(flight1);

	}

	@Override
	public List<Flight> fetchFlights() {
		// TODO Auto-generated method stub
		return this.flights;
	}

	@Override
	public List<Flight> fetchFlight(String source, String destination, LocalDate journeyDate) {
		return flights.stream()
        .filter(flight -> flight.getSource().equalsIgnoreCase(source))
        .filter(flight -> flight.getDestination().equalsIgnoreCase(destination))
        .filter(flight -> flight.getJourneyDate().isEqual(journeyDate))
        .collect(Collectors.toList());
	}

}

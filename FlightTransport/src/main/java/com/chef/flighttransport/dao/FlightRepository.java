/**
 * 
 */
package com.chef.flighttransport.dao;

import java.time.LocalDate;
import java.util.List;

import com.chef.flighttransport.domain.Flight;

/**
 * @author sramtekkar
 * This Interface will contains the operations to save in the databases
 */


public interface FlightRepository {
	
	/**
	 * Insert the flight details
	 * @param flight
	 */
	public void insert(Flight flight);
	
	
	/**
	 * Fetch all the flight Details
	 * @return
	 */
	public List<Flight> fetchFlights();
	
	/**
	 * Fetch the flight based on source, destination, and journey date
	 * @param source
	 * @param destination
	 * @param journeyDate
	 * @return
	 */
	public List<Flight> fetchFlight(String source, String destination, LocalDate journeyDate);
}

/**
 * 
 */
package com.chef.flighttransport.service;


import java.time.LocalDate;
import java.util.List;

import com.chef.flighttransport.dto.FlightDTO;

/**
 * @author sramtekkar
 * This will contains the Business class definition to be perform on the Flight
 */


public interface FlightService {
	
	/**
	 * Business logic to add the flight details
	 * @param flightDto
	 */
	public void addFlight(FlightDTO flightDto);
	
	
	/**
	 * Get the list of all the flights
	 * @return
	 */
	public List<FlightDTO> getFlights();
	
	
	/**
	 * Search flights based on source, destination, and journey date
	 * @param source
	 * @param destination
	 * @param journeyDate
	 * @return
	 */
	public List<FlightDTO> getFlight(String source,String destination,LocalDate journeyDate);

}

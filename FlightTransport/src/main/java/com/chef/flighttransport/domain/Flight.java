/**
 * 
 */
package com.chef.flighttransport.domain;

import java.time.LocalDate;

import com.chef.flighttransport.dto.FlightDTO;

/**
 * @author sramtekkar
 * This is the flight domain class which will have the flight details
 */
public class Flight {
	
	/**
	 * Flight Identifier
	 */
	private String flightId;
	
	/**
	 * Airline of the Flight
	 */
	private String airlines;
	
	/**
	 * Flight source 
	 */
	private String source;
	
	/*
	 * Flight destination
	 */
	private String destination;
	/**
	 * Fare of the travelling
	 */
	private Double fare;
	
	/**
	 * Date of journey
	 */
	private LocalDate journeyDate;
	
	/**
	 * Seat count of the flight 
	 */
	private Integer seatCount;
	
	/**
	 * @return the flightId
	 */
	public String getFlightId() {
		return flightId;
	}

	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	/**
	 * @return the airlines
	 */
	public String getAirlines() {
		return airlines;
	}

	/**
	 * @param airlines the airlines to set
	 */
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the fare
	 */
	public Double getFare() {
		return fare;
	}

	/**
	 * @param fare the fare to set
	 */
	public void setFare(Double fare) {
		this.fare = fare;
	}

	/**
	 * @return the journeyDate
	 */
	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	/**
	 * @param journeyDate the journeyDate to set
	 */
	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	/**
	 * @return the seatCount
	 */
	public Integer getSeatCount() {
		return seatCount;
	}

	/**
	 * @param seatCount the seatCount to set
	 */
	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", airlines=" + airlines + ", source=" + source + ", destination="
				+ destination + ", fare=" + fare + ", journeyDate=" + journeyDate + ", seatCount=" + seatCount + "]";
	}

	/**
	 * Convert the flight object to dto
	 * @param flight
	 * @return
	 */
	public static FlightDTO toFlightDTO(Flight flight) {
		FlightDTO flightDTO = new FlightDTO();
		flightDTO.setFlightName(flight.getAirlines());
		flightDTO.setFlightdestination(flight.getDestination());
		flightDTO.setFlightPrice(flight.getFare());
		flightDTO.setFlightNo(flight.getFlightId());
		flightDTO.setFlightPlannedDate(flight.getJourneyDate());
		flightDTO.setFlightNoOfSeat(flight.getSeatCount());
		flightDTO.setFlightSource(flight.getSource());
		return flightDTO;
		
	}
	
	
}

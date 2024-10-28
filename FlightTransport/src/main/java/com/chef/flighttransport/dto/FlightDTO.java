/**
 * 
 */
package com.chef.flighttransport.dto;

import java.time.LocalDate;

import com.chef.flighttransport.domain.Flight;

/**
 * 
 */
public class FlightDTO {
	
	/**
	 * Flight Identifier
	 */
	private String flightNo;
	
	/**
	 * Airline of the Flight
	 */
	private String flightName;
	
	/**
	 * Flight source 
	 */
	private String flightSource;
	
	/*
	 * Flight destination
	 */
	private String flightdestination;
	
	/**
	 * Fare of the travelling
	 */
	private Double flightPrice;

	/**
	 * Date of journey
	 */
	private LocalDate flightPlannedDate;
	
	/**
	 * Seat count of the flight 
	 */
	private Integer flightNoOfSeat;
	
	/**
	 * @return the flightNo
	 */
	public String getFlightNo() {
		return flightNo;
	}



	/**
	 * @param flightNo the flightNo to set
	 */
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}



	/**
	 * @return the flightName
	 */
	public String getFlightName() {
		return flightName;
	}



	/**
	 * @param flightName the flightName to set
	 */
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}



	/**
	 * @return the flightSource
	 */
	public String getFlightSource() {
		return flightSource;
	}



	/**
	 * @param flightSource the flightSource to set
	 */
	public void setFlightSource(String flightSource) {
		this.flightSource = flightSource;
	}



	/**
	 * @return the flightdestination
	 */
	public String getFlightdestination() {
		return flightdestination;
	}



	/**
	 * @param flightdestination the flightdestination to set
	 */
	public void setFlightdestination(String flightdestination) {
		this.flightdestination = flightdestination;
	}



	/**
	 * @return the flightPrice
	 */
	public Double getFlightPrice() {
		return flightPrice;
	}



	/**
	 * @param flightPrice the flightPrice to set
	 */
	public void setFlightPrice(Double flightPrice) {
		this.flightPrice = flightPrice;
	}



	/**
	 * @return the flightPlannedDate
	 */
	public LocalDate getFlightPlannedDate() {
		return flightPlannedDate;
	}



	/**
	 * @param flightPlannedDate the flightPlannedDate to set
	 */
	public void setFlightPlannedDate(LocalDate flightPlannedDate) {
		this.flightPlannedDate = flightPlannedDate;
	}



	/**
	 * @return the flightNoOfSeat
	 */
	public Integer getFlightNoOfSeat() {
		return flightNoOfSeat;
	}



	/**
	 * @param flightNoOfSeat the flightNoOfSeat to set
	 */
	public void setFlightNoOfSeat(Integer flightNoOfSeat) {
		this.flightNoOfSeat = flightNoOfSeat;
	}

	@Override
	public String toString() {
		return "FlightDTO [flightNo=" + flightNo + ", flightName=" + flightName + ", flightSource=" + flightSource
				+ ", flightdestination=" + flightdestination + ", flightPrice=" + flightPrice + ", flightPlannedDate="
				+ flightPlannedDate + ", flightNoOfSeat=" + flightNoOfSeat + "]";
	}

	public static Flight toFlight(FlightDTO flightDTO) {
		Flight flight = new Flight();
		flight.setAirlines(flightDTO.getFlightName());
		flight.setDestination(flightDTO.getFlightdestination());
		flight.setFare(flightDTO.getFlightPrice());
		flight.setFlightId(flightDTO.getFlightNo());
		flight.setJourneyDate(flightDTO.getFlightPlannedDate());
		flight.setSeatCount(flightDTO.getFlightNoOfSeat());
		flight.setSource(flightDTO.getFlightSource());
		return flight;
		
	}
}

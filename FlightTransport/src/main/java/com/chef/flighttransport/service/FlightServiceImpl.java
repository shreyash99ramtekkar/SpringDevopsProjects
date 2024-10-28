/**
 * 
 */
package com.chef.flighttransport.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.chef.flighttransport.dao.FlightRepository;
import com.chef.flighttransport.dao.FlightRespoitoryImpl;
import com.chef.flighttransport.domain.Flight;
import com.chef.flighttransport.dto.FlightDTO;

/**
 * @author sramtekkar Business logic for managing flight
 */
@Service
@Scope("prototype")
public class FlightServiceImpl implements FlightService {

	private FlightRepository flightDAO;

	@Autowired
	public void FligthServiceImpl(FlightRespoitoryImpl flightDAO) {
		this.flightDAO = flightDAO;
	}

	@Override
	public void addFlight(FlightDTO flightDTO) {
		this.flightDAO.insert(flightDTO.toFlight(flightDTO));

	}

	@Override
	public List<FlightDTO> getFlights() {
		return flightDAO.fetchFlights().stream().map(Flight::toFlightDTO).collect(Collectors.toList());
	}

	@Override
	public List<FlightDTO> getFlight(String source, String destination, LocalDate journeyDate) {
		if(journeyDate.getMonthValue() == 12 || journeyDate.getMonthValue() == 1) {
			return flightDAO.fetchFlight(source, destination, journeyDate).stream()
		    .map(this::applyDiscountIfApplicable)// Apply discount logic here
		    .collect(Collectors.toList());
		}
		return flightDAO.fetchFlight(source, destination, journeyDate).stream().map(Flight::toFlightDTO).collect(Collectors.toList());

	}

	private FlightDTO applyDiscountIfApplicable(Flight flight) {
		FlightDTO dto = Flight.toFlightDTO(flight);
		dto.setFlightPrice(dto.getFlightPrice() * 0.8); // Apply 20% discount
		return dto;
	}

}

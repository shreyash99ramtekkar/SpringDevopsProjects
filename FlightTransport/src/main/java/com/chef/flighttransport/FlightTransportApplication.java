package com.chef.flighttransport;


import java.time.LocalDate;

import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.Environment;

import com.chef.flighttransport.dto.FlightDTO;
import com.chef.flighttransport.service.FlightService;
import com.chef.flighttransport.service.FlightServiceImpl;;


@SpringBootApplication
public class FlightTransportApplication implements ApplicationRunner{
	@Autowired
	Environment env;
	
	public static Logger logger = LoggerFactory.getLogger(FlightTransportApplication.class);

	public static void main(String[] args) {
		AbstractApplicationContext context = (AbstractApplicationContext) SpringApplication.run(FlightTransportApplication.class, args);
		FlightService flightService = context.getBean(FlightServiceImpl.class);
		FlightDTO flightDTO = new FlightDTO();
		flightDTO.setFlightdestination("UK");
		flightDTO.setFlightName("Qatar");
		flightDTO.setFlightNoOfSeat(250);
		flightDTO.setFlightPlannedDate(LocalDate.parse("2024-12-27"));
		flightDTO.setFlightPrice(60000.43);
		flightDTO.setFlightSource("Nagpur");
		flightService.addFlight(flightDTO);
		FlightDTO flightDTO1 = new FlightDTO();
		flightDTO1.setFlightdestination("UK");
		flightDTO1.setFlightName("Ethihad");
		flightDTO1.setFlightNoOfSeat(250);
		flightDTO1.setFlightPlannedDate(LocalDate.parse("2024-12-27"));
		flightDTO1.setFlightPrice(50000.23);
		flightDTO1.setFlightSource("Nagpur");
		flightService.addFlight(flightDTO1);
		logger.info("Flight Details:");
		for(FlightDTO flight : flightService.getFlights()) {
                  logger.info(flight.toString());			
		}
		flightService.getFlight("Nagpur", "UK", LocalDate.parse("2024-12-27"));
		context.close();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
	
		logger.info("Application up and running");
	}

}

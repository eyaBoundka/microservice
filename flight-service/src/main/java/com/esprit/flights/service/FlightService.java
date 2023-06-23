package com.esprit.flights.service;

import com.esprit.flights.exception.FlightNotFoundException;
import com.esprit.flights.model.Flight;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface FlightService {
     List<Flight> getAllFlights();
     Optional<Flight> getFlightById(String id);
     Flight createFlight(Flight flight);
     Flight updateFlight(Flight flight, String id) throws FlightNotFoundException;
     void deleteFlight(String id);
}

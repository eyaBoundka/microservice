package com.esprit.flights.service;

import com.esprit.flights.exception.FlightNotFoundException;
import com.esprit.flights.repository.FlightRepository;
import com.esprit.flights.model.Flight;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {

    FlightRepository flightRepository;

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Optional<Flight> getFlightById(String id) {
        return flightRepository.findById(id);
    }

    @Override
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateFlight(Flight flightDto, String id) throws FlightNotFoundException {
        Optional<Flight> flight = this.flightRepository.findById(id);
        if (flight.isPresent()) {
            return this.flightRepository.save(flightDto);
        } else {
            throw new FlightNotFoundException(id);
        }
    }

    @Override
    public void deleteFlight(String id) {
        flightRepository.deleteById(id);
    }
}

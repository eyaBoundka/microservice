package com.esprit.flights.controller;

import com.esprit.flights.exception.FlightNotFoundException;
import com.esprit.flights.model.Flight;
import com.esprit.flights.service.FlightService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/flights")
@Api(value = "Flight API")
@AllArgsConstructor
public class FlightController {

    FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlight() {
        List<Flight> flights = this.flightService.getAllFlights();
        if (flights.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(flights, HttpStatus.OK);
        }
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable("id") String id) {
        Optional<Flight> flight = this.flightService.getFlightById(id);
        if (flight.isPresent()) {
            return new ResponseEntity<>(flight.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flightDto) {
        Flight flight = this.flightService.createFlight(flightDto);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);

    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable("id") String id, @RequestBody Flight flightDto) {
        try {
            return new ResponseEntity<>(this.flightService.updateFlight(flightDto, id), HttpStatus.OK);
        }catch (FlightNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFlight(@PathVariable("id") String id) {
        try {
            this.flightService.deleteFlight(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

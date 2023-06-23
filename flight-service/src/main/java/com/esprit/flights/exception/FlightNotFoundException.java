package com.esprit.flights.exception;


public class FlightNotFoundException extends Throwable {
    public FlightNotFoundException(String id) {
        super("Cannot found flight number [" + id + "]");
    }
}

package com.esprit.reservation.exception;
import java.util.UUID;


public class ReservationNotFoundException extends Throwable {
    public ReservationNotFoundException(UUID id) {
        super("Cannot found reservation number [" + id + "]");
    }
}

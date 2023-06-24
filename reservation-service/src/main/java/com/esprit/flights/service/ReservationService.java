package com.esprit.reservation.service;

import com.esprit.reservation.exception.ReservationNotFoundException;
import com.esprit.reservation.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ReservationService {
     List<Reservation> getAllReservations();
     Optional<Reservation> getReservationById(UUID id);
     Reservation createReservation(Reservation reservation);
     Reservation updateReservation(Reservation reservation, UUID id) throws ReservationNotFoundException;
     void deleteReservation(UUID id);
}

package com.esprit.reservation.service;

import com.esprit.reservation.exception.ReservationNotFoundException;
import com.esprit.reservation.repository.ReservationRepository;
import com.esprit.reservation.model.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> getReservationById(UUID id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservationDto, UUID id) throws ReservationNotFoundException {
        Optional<Reservation> reservation = this.reservationRepository.findById(id);
        if (reservation.isPresent()) {
            return this.reservationRepository.save(reservationDto);
        } else {
            throw new ReservationNotFoundException(id);
        }
    }

    @Override
    public void deleteReservation(UUID id) {
        reservationRepository.deleteById(id);
    }
}

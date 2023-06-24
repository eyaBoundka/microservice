package com.esprit.reservation.controller;

import com.esprit.reservation.exception.ReservationNotFoundException;
import com.esprit.reservation.model.Reservation;
import com.esprit.reservation.service.ReservationService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import java.util.UUID;

@RestController
@RequestMapping(value = "/reservation")
@Api(value = "Reservation API")
@AllArgsConstructor
public class ReservationController {

    ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservation() {
        List<Reservation> reservation = this.reservationService.getAllReservations();
        if (reservation.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        }
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") UUID id) {
        Optional<Reservation> reservation = this.reservationService.getReservationById(id);
        if (reservation.isPresent()) {
            return new ResponseEntity<>(reservation.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservationDto) {
        Reservation reservation = this.reservationService.createReservation(reservationDto);
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);

    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable("id") UUID id, @RequestBody Reservation reservationDto) {
        try {
            return new ResponseEntity<>(this.reservationService.updateReservation(reservationDto, id), HttpStatus.OK);
        }catch (ReservationNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReservation(@PathVariable("id") UUID id) {
        try {
            this.reservationService.deleteReservation(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

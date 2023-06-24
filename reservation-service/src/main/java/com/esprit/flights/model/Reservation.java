package com.esprit.reservation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.UUID;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;
        private int passengerId;
        private int flightId;
}

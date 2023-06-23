package com.esprit.crew.model;

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
public class Crew {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;
        private String pilotName;
        private String coPilotName;
        private String flightAttendants;
}

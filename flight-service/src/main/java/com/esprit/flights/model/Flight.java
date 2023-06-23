package com.esprit.flights.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Flight {
        @Id
        private String id;
        private String from;
        private String to;
        private String crewId;
        private Integer numberOfSeats;
        private String model;
}

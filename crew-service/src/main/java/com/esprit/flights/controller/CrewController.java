package com.esprit.crew.controller;

import com.esprit.crew.exception.CrewNotFoundException;
import com.esprit.crew.model.Crew;
import com.esprit.crew.service.CrewService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import java.util.UUID;

@RestController
@RequestMapping(value = "/crew")
@Api(value = "Crew API")
@AllArgsConstructor
public class CrewController {

    CrewService crewService;

    @GetMapping
    public ResponseEntity<List<Crew>> getAllCrew() {
        List<Crew> crew = this.crewService.getAllCrews();
        if (crew.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(crew, HttpStatus.OK);
        }
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Crew> getCrewById(@PathVariable("id") UUID id) {
        Optional<Crew> crew = this.crewService.getCrewById(id);
        if (crew.isPresent()) {
            return new ResponseEntity<>(crew.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Crew> createCrew(@RequestBody Crew crewDto) {
        Crew crew = this.crewService.createCrew(crewDto);
        return new ResponseEntity<>(crew, HttpStatus.CREATED);

    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<Crew> updateCrew(@PathVariable("id") UUID id, @RequestBody Crew crewDto) {
        try {
            return new ResponseEntity<>(this.crewService.updateCrew(crewDto, id), HttpStatus.OK);
        }catch (CrewNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCrew(@PathVariable("id") UUID id) {
        try {
            this.crewService.deleteCrew(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

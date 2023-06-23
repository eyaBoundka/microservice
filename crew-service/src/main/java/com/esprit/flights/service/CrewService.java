package com.esprit.crew.service;

import com.esprit.crew.exception.CrewNotFoundException;
import com.esprit.crew.model.Crew;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface CrewService {
     List<Crew> getAllCrews();
     Optional<Crew> getCrewById(UUID id);
     Crew createCrew(Crew crew);
     Crew updateCrew(Crew crew, UUID id) throws CrewNotFoundException;
     void deleteCrew(UUID id);
}

package com.esprit.crew.service;

import com.esprit.crew.exception.CrewNotFoundException;
import com.esprit.crew.repository.CrewRepository;
import com.esprit.crew.model.Crew;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CrewServiceImpl implements CrewService {

    CrewRepository crewRepository;

    @Override
    public List<Crew> getAllCrews() {
        return crewRepository.findAll();
    }

    @Override
    public Optional<Crew> getCrewById(UUID id) {
        return crewRepository.findById(id);
    }

    @Override
    public Crew createCrew(Crew crew) {
        return crewRepository.save(crew);
    }

    @Override
    public Crew updateCrew(Crew crewDto, UUID id) throws CrewNotFoundException {
        Optional<Crew> crew = this.crewRepository.findById(id);
        if (crew.isPresent()) {
            return this.crewRepository.save(crewDto);
        } else {
            throw new CrewNotFoundException(id);
        }
    }

    @Override
    public void deleteCrew(UUID id) {
        crewRepository.deleteById(id);
    }
}

package com.esprit.crew.repository;

import com.esprit.crew.model.Crew;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

@Repository
public interface CrewRepository extends JpaRepository<Crew, UUID>  {
}

package com.application.airlinebookingapp.repo;

import com.application.airlinebookingapp.models.Pilots;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotsRepo extends JpaRepository<Pilots,Long> {
}

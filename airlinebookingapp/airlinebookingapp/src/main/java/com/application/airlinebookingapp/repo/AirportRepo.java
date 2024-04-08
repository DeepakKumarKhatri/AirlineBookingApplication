package com.application.airlinebookingapp.repo;

import com.application.airlinebookingapp.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirportRepo extends JpaRepository<Airport, Long> {
    void deleteAirportById(Long id);

    Optional<Airport> findAirportById(Long id);
}

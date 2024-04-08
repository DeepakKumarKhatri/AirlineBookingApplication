package com.application.airlinebookingapp.repo;

import com.application.airlinebookingapp.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepo extends JpaRepository<Flight, Long> {
    Optional<Flight> getFlightById(Long id);
}

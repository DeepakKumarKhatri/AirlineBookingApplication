package com.application.airlinebookingapp.repo;

import com.application.airlinebookingapp.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepo extends JpaRepository<Airport, Long> {
}

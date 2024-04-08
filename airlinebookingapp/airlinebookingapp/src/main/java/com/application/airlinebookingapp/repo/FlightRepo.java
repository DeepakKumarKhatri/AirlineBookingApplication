package com.application.airlinebookingapp.repo;

import com.application.airlinebookingapp.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepo extends JpaRepository<Flight, Long> {
}

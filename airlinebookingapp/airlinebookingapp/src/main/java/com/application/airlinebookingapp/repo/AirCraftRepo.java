package com.application.airlinebookingapp.repo;

import com.application.airlinebookingapp.models.Aircraft;
import com.application.airlinebookingapp.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirCraftRepo extends JpaRepository<Aircraft,Long> {
    void deleteAircraftById(Long id);

    Optional<Aircraft> findAircraftById(Long id);
}

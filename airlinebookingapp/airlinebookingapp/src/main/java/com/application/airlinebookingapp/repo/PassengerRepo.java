package com.application.airlinebookingapp.repo;

import com.application.airlinebookingapp.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepo extends JpaRepository<Passenger, Long> {
}

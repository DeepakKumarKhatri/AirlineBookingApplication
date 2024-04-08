package com.application.airlinebookingapp.repo;

import com.application.airlinebookingapp.models.Airport;
import com.application.airlinebookingapp.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepo extends JpaRepository<Booking, Long> {
    Optional<Booking> findBookingById(Long id);
}

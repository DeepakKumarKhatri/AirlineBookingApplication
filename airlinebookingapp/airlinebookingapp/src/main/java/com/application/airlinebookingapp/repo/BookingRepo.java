package com.application.airlinebookingapp.repo;

import com.application.airlinebookingapp.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Long> {
}

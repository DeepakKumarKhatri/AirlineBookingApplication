package com.application.airlinebookingapp.services;

import com.application.airlinebookingapp.custom_exceptions.FlightNotFoundException;
import com.application.airlinebookingapp.models.Flight;
import com.application.airlinebookingapp.repo.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FlightService {
    private final FlightRepo flightRepo;

    @Autowired
    public FlightService(FlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }

    public Flight getFlightById(Long id) {
        return flightRepo.findById(id)
                .orElseThrow(() -> new FlightNotFoundException("Flight with ID: " + id + " not found"));
    }

    public List<Flight> getAllFlights() {
        return flightRepo.findAll();
    }

    public Flight createFlight(Flight flight) {
        return flightRepo.save(flight);
    }

    public Flight updateFlight(Long id, Flight updatedFlight) {
        Optional<Flight> optionalFlight = flightRepo.findById(id);
        if (optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            flight.setFlightNumber(updatedFlight.getFlightNumber());
            flight.setDepartureAirport(updatedFlight.getDepartureAirport());
            flight.setArrivalAirport(updatedFlight.getArrivalAirport());
            flight.setDepartureTime(updatedFlight.getDepartureTime());
            flight.setArrivalTime(updatedFlight.getArrivalTime());
            return flightRepo.save(flight);
        }
        return null;
    }

    public void deleteFlight(Long id) {
        flightRepo.deleteById(id);
    }
}

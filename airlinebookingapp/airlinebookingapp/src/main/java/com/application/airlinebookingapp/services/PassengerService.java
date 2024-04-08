package com.application.airlinebookingapp.services;

import com.application.airlinebookingapp.custom_exceptions.PassengerNotFoundException;
import com.application.airlinebookingapp.models.Passenger;
import com.application.airlinebookingapp.repo.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PassengerService {
    private final PassengerRepo passengerRepo;

    @Autowired
    public PassengerService(PassengerRepo passengerRepo) {
        this.passengerRepo = passengerRepo;
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepo.findById(id)
                .orElseThrow(() -> new PassengerNotFoundException("Passenger with ID: " + id + " not found"));
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepo.findAll();
    }

    public Passenger createPassenger(Passenger passenger) {
        return passengerRepo.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger updatedPassenger) {
        Optional<Passenger> optionalPassenger = passengerRepo.findById(id);
        if (optionalPassenger.isPresent()) {
            Passenger passenger = optionalPassenger.get();
            passenger.setFirstName(updatedPassenger.getFirstName());
            passenger.setLastName(updatedPassenger.getLastName());
            passenger.setEmail(updatedPassenger.getEmail());
            return passengerRepo.save(passenger);
        }
        return null;
    }

    public void deletePassenger(Long id) {
        passengerRepo.deleteById(id);
    }
}

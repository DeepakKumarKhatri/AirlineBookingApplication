package com.application.airlinebookingapp.services;

import com.application.airlinebookingapp.custom_exceptions.PilotNotFoundException;
import com.application.airlinebookingapp.models.Pilots;
import com.application.airlinebookingapp.repo.PilotsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PilotsService {

    private final PilotsRepo pilotsRepo;

    @Autowired
    public PilotsService(PilotsRepo pilotsRepo) {
        this.pilotsRepo = pilotsRepo;
    }

    public Pilots getPilotById(Long id) {
        return pilotsRepo.findById(id)
                .orElseThrow(() -> new PilotNotFoundException("Pilot with ID: " + id + " not found"));
    }

    public List<Pilots> getAllPilots() {
        return pilotsRepo.findAll();
    }

    public Pilots createPilot(Pilots pilot) {
        return pilotsRepo.save(pilot);
    }

    public Pilots updatePilot(Long id, Pilots updatedPilot) {
        Optional<Pilots> optionalPilot = pilotsRepo.findById(id);
        if (optionalPilot.isPresent()) {
            Pilots pilot = optionalPilot.get();
            pilot.setFirstName(updatedPilot.getFirstName());
            pilot.setLastName(updatedPilot.getLastName());
            pilot.setEmail(updatedPilot.getEmail());
            pilot.setPhone(updatedPilot.getPhone());
            pilot.setFlight(updatedPilot.getFlight());
            return pilotsRepo.save(pilot);
        }
        return null;
    }

    public void deletePilot(Long id) {
        pilotsRepo.deleteById(id);
    }
}

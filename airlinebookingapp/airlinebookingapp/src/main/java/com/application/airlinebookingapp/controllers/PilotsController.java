package com.application.airlinebookingapp.controllers;

import com.application.airlinebookingapp.models.Pilots;
import com.application.airlinebookingapp.services.PilotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilots")
public class PilotsController {

    private final PilotsService pilotsService;

    @Autowired
    public PilotsController(PilotsService pilotsService) {
        this.pilotsService = pilotsService;
    }

    @GetMapping("/{id}")
    public Pilots getPilotById(@PathVariable Long id) {
        return pilotsService.getPilotById(id);
    }

    @GetMapping("/all")
    public List<Pilots> getAllPilots() {
        return pilotsService.getAllPilots();
    }

    @PostMapping("/create")
    public Pilots createPilot(@RequestBody Pilots pilot) {
        return pilotsService.createPilot(pilot);
    }

    @PutMapping("/{id}")
    public Pilots updatePilot(@PathVariable Long id, @RequestBody Pilots updatedPilot) {
        return pilotsService.updatePilot(id, updatedPilot);
    }

    @DeleteMapping("/{id}")
    public void deletePilot(@PathVariable Long id) {
        pilotsService.deletePilot(id);
    }
}

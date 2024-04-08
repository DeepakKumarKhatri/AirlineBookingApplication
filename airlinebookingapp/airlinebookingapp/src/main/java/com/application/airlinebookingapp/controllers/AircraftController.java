package com.application.airlinebookingapp.controllers;

import com.application.airlinebookingapp.models.Aircraft;
import com.application.airlinebookingapp.services.AircraftService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {
    private final AircraftService aircraftService;

    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping("/allAircraft")
    public ResponseEntity<List<Aircraft>> getAllAircrafts(){
        List<Aircraft> aircrafts = aircraftService.findAllAircrafts();
        return new ResponseEntity<>(aircrafts, HttpStatus.OK);
    }

    @GetMapping("/findAircraft/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable("id") Long id){
        Aircraft aircraft = aircraftService.findAircraftById(id);
        return new ResponseEntity<>(aircraft, HttpStatus.OK);
    }

    @PostMapping("/addAircraft")
    public ResponseEntity<Aircraft> addAircraft(@RequestBody Aircraft aircraft){
        Aircraft newAircraft = aircraftService.addAircraft(aircraft);
        return new ResponseEntity<>(newAircraft, HttpStatus.CREATED);
    }

    @PutMapping("/updateAircraft")
    public ResponseEntity<Aircraft> updateAircraft(@RequestBody Aircraft aircraft){
        Aircraft updateAircraft = aircraftService.updateAircraft(aircraft);
        return new ResponseEntity<>(updateAircraft, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAircraft(@PathVariable("id") Long id){
        aircraftService.deleteAircraft(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

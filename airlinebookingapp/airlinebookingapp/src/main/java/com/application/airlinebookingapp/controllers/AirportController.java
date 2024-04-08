package com.application.airlinebookingapp.controllers;

import com.application.airlinebookingapp.models.Airport;
import com.application.airlinebookingapp.services.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/allAirPort")
    public ResponseEntity<List<Airport>> getAllAirports(){
        List<Airport> airports = airportService.findAllAirports();
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }

    @GetMapping("/findAirport/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable("id") Long id){
        Airport airport = airportService.findAirportById(id);
        return new ResponseEntity<>(airport, HttpStatus.OK);
    }

    @PostMapping("/addAirport")
    public ResponseEntity<Airport> addAirport(@RequestBody Airport airport){
        Airport newAirport = airportService.addAirport(airport);
        return new ResponseEntity<>(newAirport, HttpStatus.CREATED);
    }

    @PutMapping("/updateAirport")
    public ResponseEntity<Airport> updateAirPort(@RequestBody Airport airport){
        Airport updateAirport = airportService.updateAirport(airport);
        return new ResponseEntity<>(updateAirport, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAirport(@PathVariable("id") Long id){
        airportService.deleteAirport(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

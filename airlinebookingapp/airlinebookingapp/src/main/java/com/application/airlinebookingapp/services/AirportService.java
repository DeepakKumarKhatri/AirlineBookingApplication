package com.application.airlinebookingapp.services;

import com.application.airlinebookingapp.custom_exceptions.AirportNotFoundException;
import com.application.airlinebookingapp.models.Airport;
import com.application.airlinebookingapp.repo.AirportRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AirportService {
    private final AirportRepo airportRepo;

    @Autowired
    public AirportService(AirportRepo airportRepo) {
        this.airportRepo = airportRepo;
    }

    public Airport addAirport(Airport airport){
        airport.setCode(UUID.randomUUID().toString());
        return airportRepo.save(airport);
    }

    public List<Airport> findAllAirports(){
        return airportRepo.findAll();
    }

    public Airport updateAirport(Airport airport){
        return airportRepo.save(airport);
    }

    public Airport findAirportById(Long id){
        return airportRepo.findAirportById(id).
                orElseThrow(() ->
                        new AirportNotFoundException("Airport with ID: " + id + " Not Found!"));
    }

    public void deleteAirport(Long id){
        airportRepo.deleteAirportById(id);
    }
}

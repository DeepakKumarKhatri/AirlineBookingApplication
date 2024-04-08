package com.application.airlinebookingapp.services;

import com.application.airlinebookingapp.custom_exceptions.AircraftNotFoundException;
import com.application.airlinebookingapp.models.Aircraft;
import com.application.airlinebookingapp.repo.AirCraftRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AircraftService {
    private final AirCraftRepo airCraftRepo;

    @Autowired
    public AircraftService(AirCraftRepo airCraftRepo) {
        this.airCraftRepo = airCraftRepo;
    }

    public Aircraft addAircraft(Aircraft aircraft){
        return airCraftRepo.save(aircraft);
    }

    public List<Aircraft> findAllAircrafts(){
        return airCraftRepo.findAll();
    }

    public Aircraft updateAircraft(Aircraft aircraft){
        return airCraftRepo.save(aircraft);
    }

    public Aircraft findAircraftById(Long id){
        return airCraftRepo.findAircraftById(id).
                orElseThrow(() ->
                        new AircraftNotFoundException("Aircraft with ID: " + id + " Not Found!"));
    }

    public void deleteAircraft(Long id){
        airCraftRepo.deleteAircraftById(id);
    }
}

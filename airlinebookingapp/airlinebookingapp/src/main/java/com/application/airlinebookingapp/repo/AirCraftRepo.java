package com.application.airlinebookingapp.repo;

import com.application.airlinebookingapp.models.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirCraftRepo extends JpaRepository<Aircraft,Long> {

}

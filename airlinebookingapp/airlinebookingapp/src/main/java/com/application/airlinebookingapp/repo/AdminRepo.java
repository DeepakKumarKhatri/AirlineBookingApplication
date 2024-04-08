package com.application.airlinebookingapp.repo;

import com.application.airlinebookingapp.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Long> {
}

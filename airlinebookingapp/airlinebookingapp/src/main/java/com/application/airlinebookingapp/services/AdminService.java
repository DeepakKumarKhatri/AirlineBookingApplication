package com.application.airlinebookingapp.services;

import com.application.airlinebookingapp.models.Admin;
import com.application.airlinebookingapp.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminService {
    private final AdminRepo adminRepo;

    @Autowired
    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    public Admin createAdmin(Admin admin) {
        return adminRepo.save(admin);
    }
}

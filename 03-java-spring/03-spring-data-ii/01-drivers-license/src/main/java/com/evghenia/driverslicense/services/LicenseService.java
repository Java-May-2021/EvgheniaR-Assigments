package com.evghenia.driverslicense.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evghenia.driverslicense.models.License;
import com.evghenia.driverslicense.repositories.LicenseRepository;


@Service
public class LicenseService{
	@Autowired
	private LicenseRepository licenseRepo;
	
	
    
    // creates a license
    public License createLicense(License license) {
        return licenseRepo.save(license);
    }
    
    
    //Find a license
    public License getLicenseById(Long id) {
		return this.licenseRepo.findById(id).orElse(null);
	}
    
    //Update a license
    public License updatePerson(License updatedLicense) {
    	return this.licenseRepo.save(updatedLicense);
    }
    
    //Delete a license
	public void deleteById(Long id) {
        this.licenseRepo.deleteById(id);
        
    }
}

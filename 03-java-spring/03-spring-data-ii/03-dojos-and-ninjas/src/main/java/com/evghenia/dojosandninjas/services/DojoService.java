package com.evghenia.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evghenia.dojosandninjas.models.Dojo;
import com.evghenia.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService{
	@Autowired
	private DojoRepository dojoRepo;
	
	// returns all the dojos
    public List<Dojo> getAll() {
        return this.dojoRepo.findAll();
    }
    
    // creates a dojo
    public Dojo createDojo(Dojo dojo) {
        return dojoRepo.save(dojo);
    }
    
    
    //Find a dojo
    public Dojo getDojoById(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}
    
    //Update a dojo
    public Dojo updateDojo(Dojo updatedDojo) {
    	return this.dojoRepo.save(updatedDojo);
    }
    
    //Delete a dojo
	public void deleteById(Long id) {
        this.dojoRepo.deleteById(id);
        
    }
}


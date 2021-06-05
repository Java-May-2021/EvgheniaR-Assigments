package com.evghenia.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evghenia.dojosandninjas.models.Ninja;
import com.evghenia.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepo;
	
	 // returns all the ninjas
    public List<Ninja> getAll() {
        return this.ninjaRepo.findAll();
    }
    
    // creates a ninja
    public Ninja createNinja(Ninja newNinja) {
        return ninjaRepo.save(newNinja);
    }
    
    //Find a ninja
    public Ninja getSinglePerson(Long id) {
		return this.ninjaRepo.findById(id).orElse(null); //id is an optional(a boolean) (return everything or nothing)
	}
    
    //Update a ninja
    public Ninja updateNinja(Ninja updatedNinja) {
    	return this.ninjaRepo.save(updatedNinja);
    }
    
    //Delete a ninja
	public void deleteById(Long id) {
        this.ninjaRepo.deleteById(id);
        
    }

}


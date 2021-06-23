package com.evghenia.eventsbeltreviewer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evghenia.eventsbeltreviewer.models.Event;
import com.evghenia.eventsbeltreviewer.repositories.EventRepository;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepo;
    
    public Event createEvent(Event event) {
    	return this.eventRepo.save(event);
    }
    public Event getOneEvent(Long id) {
    	return this.eventRepo.findById(id).orElse(null);
    }
    public List<Event> getAllEvents(){
    	return this.eventRepo.findAll();
    }
    public Event updateEvent(Event event) {
    	return this.eventRepo.save(event);
    }
    public void deleteEvent(Long id) {
    	this.eventRepo.deleteById(id);
    }
    public List<Event> getEventsWithState(String state){
    	return this.eventRepo.findByState(state);
    }
    public List<Event> getEventsNoState(String state){
    	return this.eventRepo.findByStateIsNot(state);
    }
}

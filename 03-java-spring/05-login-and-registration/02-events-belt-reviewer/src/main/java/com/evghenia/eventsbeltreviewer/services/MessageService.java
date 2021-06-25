package com.evghenia.eventsbeltreviewer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evghenia.eventsbeltreviewer.models.Message;
import com.evghenia.eventsbeltreviewer.repositories.MessageRepository;

@Service
public class MessageService {
	@Autowired
	private MessageRepository messageRepo;
	
	public List<Message> getAllMessage() {
		return this.messageRepo.findAll();
	}
	public Message createMessage(Message message) {
		 return this.messageRepo.save(message);
	}
}

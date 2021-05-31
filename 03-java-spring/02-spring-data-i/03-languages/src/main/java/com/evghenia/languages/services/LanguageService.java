package com.evghenia.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evghenia.languages.models.Language;
import com.evghenia.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository lRepo;
	
	public LanguageService(LanguageRepository repo) {
		this.lRepo = repo;
	}
	public List<Language> getAllLanguages(){
		return this.lRepo.findAll();
	}
	public Language getSingleLanguage(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	public Language createLanguage(Language language) {
		return this.lRepo.save(language);
	}
	public Language updateLanguage(Language language) {
		return this.lRepo.save(language);
	}
	public void deleteLanguage(Long id) {
		this.lRepo.deleteById(id);
	}
}

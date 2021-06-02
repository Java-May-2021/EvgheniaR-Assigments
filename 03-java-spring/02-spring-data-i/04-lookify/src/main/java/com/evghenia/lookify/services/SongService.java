package com.evghenia.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evghenia.lookify.models.Song;
import com.evghenia.lookify.repositories.SongRepository;

@Service
public class SongService {
	private SongRepository sRepo;
	
	public SongService(SongRepository repo) {
		this.sRepo = repo;
	}
	public List<Song> getAllSongs(){
		return this.sRepo.findAll();
	}
	public Song getSingleSong(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}
	public Song createSong(Song song) {
		return this.sRepo.save(song);
	}
	public Song updateSong(Song updatedSong) {
		return this.sRepo.save(updatedSong);
	}
	public void deleteSong(Long id) {
		this.sRepo.deleteById(id);
	}
	public List<Song> findByArtist(String artist){
		return this.sRepo.findByArtistContaining(artist);
	}
	public List<Song> findTopTen(){
		return this.sRepo.findTopTenByOrderByRatingDesc();
	}
}

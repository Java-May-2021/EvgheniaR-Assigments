package com.evghenia.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.evghenia.lookify.models.Song;
import com.evghenia.lookify.services.SongService;

@Controller
public class SongController {
	@Autowired
	private  SongService songService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	@GetMapping("/dashboard")
	public String getAllSongs(Model model) {
		List<Song> allSongs = songService.getAllSongs();
		model.addAttribute("songs", allSongs );
		return "dashboard.jsp";
	}
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song")Song song,Model model) {
		return "new.jsp";
	}
	@PostMapping(value = "/dashboard")
	public String createSong(@Valid@ModelAttribute("song")Song song,BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	@GetMapping("/songs/{id}")
	public String findById(@ModelAttribute("song")Song song,Model model,@PathVariable("id") Long id) {
		Song newSong = this.songService.getSingleSong(id);
		model.addAttribute("song",newSong);
		return "show.jsp";
	}
	@GetMapping("/search/topTen")
	public String getTopTen(Model model) {
		List <Song> songs = songService.findTopTen();
		model.addAttribute("songs", songs);
		return "topTen.jsp";
	}
	@PostMapping(value = "/search")
	public String search(@RequestParam("artist")String artist,Model model) {
		List<Song> songs = songService.findByArtist(artist);
		model.addAttribute("songs",songs);
		model.addAttribute("artist",artist );
		return "search.jsp";
	}
	@GetMapping("/songs/delete/{id}")
	public String deleteSong(@PathVariable("id")Long id) {
		this.songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	
}

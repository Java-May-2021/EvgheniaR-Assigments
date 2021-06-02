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
}

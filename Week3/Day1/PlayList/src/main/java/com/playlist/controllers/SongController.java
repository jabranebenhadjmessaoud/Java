package com.playlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.playlist.models.Song;
import com.playlist.models.User;
import com.playlist.services.SongService;
import com.playlist.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class SongController {

	@Autowired
	SongService songServ;
	@Autowired 
	UserService userServ;
	
	//get create page 
	@GetMapping("/create")
	public String create(@ModelAttribute("song") Song song,HttpSession session ) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/logout";
		}
		return "create";
	}
	
	// post create song 
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("song")Song song,
			              BindingResult result,
			              HttpSession session) {
		
		// if there is validation errors 
		if(result.hasErrors()) {
			return "create";
		}
		// we will get the connected user
		User connectedUser = userServ.getUserById((Long) session.getAttribute("userId"));
		//set the creator of the song 
		song.setCreator(connectedUser);
		//else we will create the song 
		songServ.createSong(song);
		return "redirect:/home";
		
	}
	
	// add song to playList
	@GetMapping("/add/{songId}")
	public String addToPlayList(@PathVariable("songId")Long songId,
			                    HttpSession session) {
		// we will get the connected user
		User connectedUser = userServ.getUserById((Long) session.getAttribute("userId"));
		// we will get the song by id 
		Song song=songServ.findById(songId);
		System.out.println(song.getTitle());
		// we will add the song to the user playList
		connectedUser.getPlayList().add(song);
		System.out.println(connectedUser.getPlayList());
		userServ.updateUser(connectedUser);
		return "redirect:/home";
	}
	
	// remove song from playList
		@GetMapping("/remove/{songId}")
		public String removeFromPlayList(@PathVariable("songId")Long songId,
				                    HttpSession session) {
			// we will get the connected user
			User connectedUser = userServ.getUserById((Long) session.getAttribute("userId"));
			// we will get the song by id 
			Song song=songServ.findById(songId);
			System.out.println(song.getTitle());
			// we will add the song to the user playList
			connectedUser.getPlayList().remove(song);
			System.out.println(connectedUser.getPlayList());
			userServ.updateUser(connectedUser);
			
			return "redirect:/home";
		}
		
		// Display Song
		
		@GetMapping("/display/{songId}")
	    public String displaySong(@PathVariable("songId")Long songId,
	    		Model model) {
			// get the song by id 
			Song song =songServ.findById(songId);
			model.addAttribute("song",song);
			return "display";
		}
		
		
		// GetEdit page 
		@GetMapping("/edit/{songId}")
		public String getEditPage(@PathVariable("songId")Long songId,
				                 Model model) {
			
			// we will get the song using the id 
			Song song =songServ.findById(songId);
			//set the song to the model attribute 
			model.addAttribute("song",song);
			System.out.print("From get edit page"+song.getCreator());
			//return edit page
			return "edit";
		}
		
		// delete a song
		@GetMapping("/delete/{songId}")
		public String deleteSong(@PathVariable("songId") Long songId) {
			songServ.deleteSong(songId);
			return "redirect:/home";
		}
		
		// Post Edit
		@PutMapping("/edit/{songId}")
		public String editSong(@Valid @ModelAttribute("song")Song song,
				BindingResult result,
				                @PathVariable("songId")Long songId,
				                HttpSession session
				                ) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "edit";
		}	   
		System.out.print(song.getCreator());
		song.setCreator(userServ.getUserById((Long) session.getAttribute("userId")));
		songServ.updateSong(songId, song);
		return "redirect:/home";
			
		}
		
		
		// search with title 
		
		@GetMapping("/songs/search")
		public String search(@RequestParam("query")String str,Model model) {
			model.addAttribute("songs",songServ.searchSong(str));
			return "home";
		}
}

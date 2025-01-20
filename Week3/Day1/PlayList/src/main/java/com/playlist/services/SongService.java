package com.playlist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playlist.models.Song;
import com.playlist.repositories.SongRepository;
import com.playlist.repositories.UserRepository;

@Service			
public class SongService {

	@Autowired
	SongRepository songRepo;
	@Autowired
	UserRepository userRepo;
	
	//get all songs 
	public List<Song> getAllSongs(){
		return songRepo.findAll();
	}
	
	// create song 
	public Song createSong(Song song) {
		return songRepo.save(song);
	}
	
	// get one song by id 
	public Song findById(Long id) {
		Optional<Song> s=songRepo.findById(id);
		if(s.isPresent()) {
			return s.get();
		}
		return null;
	}
	
	// update
	public Song updateSong(Long id,Song song) {
		// we wil lset the id to the song
		song.setId(id);
		// we will save using songRepo
	return	songRepo.save(song);
	}
	
	// Delete song 
	public void deleteSong(Long id) {
		//get the song with id 
		Song song=findById(id);
		//we will set the users to null
		song.setUsersAddedThisSong(null);
		//we will set the creator to null 
		song.setCreator(null);
		// we wil ldelete the song now 
		songRepo.deleteById(id);
	}
	
	// search by query
	public List<Song> searchSong(String query){
		return songRepo.findByTitleContains(query);
	}
}

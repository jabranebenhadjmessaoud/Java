package com.playlist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.playlist.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song,Long> {
	
	//find all 
	List<Song> findAll();
	//search byTitle
	List<Song> findByTitleContains(String query);

}

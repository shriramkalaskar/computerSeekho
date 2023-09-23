package com.example.servicesGallary;

	import java.util.List;
	import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entityGallary.*;

	@Service
	public interface AlbumManager {
		
			
			List<Album> getAlbum();
			void delete(int id);
			void update(Album album,int id);
			Optional<Album> getSelected(String cat);
			void addAlbum(Album album);
			
		}





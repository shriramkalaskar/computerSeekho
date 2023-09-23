package com.example.servicesGallary;

import java.util.List;
import java.util.Optional;

import com.example.entityGallary.Videos;

public interface VideosServices {
	
	void AddVideo(Videos vdo);
	void DeleteVideo(int id);
	List<Videos> GetAllVideos();
	Optional<Videos> getVideos(int id);
	

}

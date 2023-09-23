package com.example.controllerGallary;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entityGallary.Videos;
import com.example.servicesGallary.VideosServices;

@RestController
public class VideosController {
	
	@Autowired
	VideosServices video_Service;
	
	@GetMapping("api/getVideos")
	public List<Videos> getAllVideos(){
	  return	video_Service.GetAllVideos();
	}
	
	@GetMapping("api/getVideobyID/{ID}")
	public Optional<Videos> getVideobyID(@PathVariable int ID){
		return video_Service.getVideos(ID);
	}
	
	@PostMapping("api/addVideos")
	public void AddVideo(@RequestBody Videos video) {
		video_Service.AddVideo(video);
	}
	
	@DeleteMapping("api/deleteVideobyID/{ID}")
	public void deleteVideobyID(@PathVariable int ID) {
		video_Service.DeleteVideo(ID);
	}

}

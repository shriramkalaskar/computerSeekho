package com.example.servicesGallary;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entityGallary.Videos;
import com.example.repositoryGallary.VideosRepository;

@Service
public class VideosServicesImp implements VideosServices {
	
	@Autowired
	private VideosRepository videoRepo;

	@Override
	public void AddVideo(Videos vedio) {
		// TODO Auto-generated method stub
		videoRepo.save(vedio);
		
	}

	@Override
	public void DeleteVideo(int id) {
		// TODO Auto-generated method stub
		videoRepo.deleteById(id);
	}

	@Override
	public List<Videos> GetAllVideos() {
		// TODO Auto-generated method stub
		List<Videos> vid = videoRepo.findAll();
		return vid ;
	}

	@Override
	public Optional<Videos> getVideos(int id) {
		// TODO Auto-generated method stub
		
		Optional<Videos> vid = videoRepo.findById(id);
		return vid ;
	}

}

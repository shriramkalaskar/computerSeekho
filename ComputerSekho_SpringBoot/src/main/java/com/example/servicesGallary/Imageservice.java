package com.example.servicesGallary;

	import java.util.List;
	import java.util.Optional;

	import org.springframework.stereotype.Service;

import com.example.entityGallary.Image;

	

	@Service
	public interface Imageservice
	{
		void insert(Image image);
		List<Image> getAll();
		Optional<Image> getImage(int id);
		void delete(int id);
		void update(Image image,int imageid);
		
	}



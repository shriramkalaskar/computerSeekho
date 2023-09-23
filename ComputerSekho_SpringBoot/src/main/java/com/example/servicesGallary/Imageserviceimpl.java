package com.example.servicesGallary;

	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.example.entityGallary.Image;
import com.example.repositoryGallary.Imagerepository;

	

	@Service
	public class Imageserviceimpl implements Imageservice
	{
		@Autowired
		private Imagerepository i_repository;
		 
		@Override
		public void insert(Image image) {
			i_repository.save(image);
			
		}

		@Override
		public List<Image> getAll() {
			
			return i_repository.findAll();
		}

		@Override
		public Optional<Image> getImage(int id) {
			return i_repository.findById(id);
			
		}

		@Override
		public void delete(int id) {
			
				i_repository.deleteById(id);
			
		}

		@Override
		public void update(Image image, int imageid) {
			// TODO Auto-generated method stub
			
		}

//		@Override
//		public void update(Image image, int imageid) 
//		{
//			i_repository.update(image.getImage_id(),image.getImage_path(),image.isIs_album_cover(),image. isImagage_is_active(),imageid);
//			
//		}

	}



package com.example.controllerGallary;

	import java.util.List;
	import com.example.entityGallary.*;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.*;
	import org.springframework.web.bind.annotation.*;

	import com.example.servicesGallary.*;

	    @RestController  
		@CrossOrigin( "*")
		public class AlbumController 
		{
			@Autowired
			AlbumManager manager;
			
			
			 @GetMapping(value = "api/getAlbums") //working
			 public List<Album> showAlbum()
			 {
				  return manager.getAlbum(); 			
			 }
			
			 @PostMapping(value = "api/addAlbums")     //working
			 public void addAlbum(@RequestBody Album album)
			 {
				System.out.println("addalbum called");
				manager.addAlbum(album);
			 }
			 
			 @DeleteMapping(value = "api/deleteAlbums/{aid}") // working
			 public void removeAlbum(@PathVariable int aid)
			 {
				manager.delete(aid);
			 }
			 
			 @GetMapping(value = "api/getAlbumsByname/{cat}")
			 public Optional<Album> getAlbumCat(@PathVariable String cat)
			 {
				return manager.getSelected(cat);
			 }
			 
			
			 @PutMapping(value = "api/updateAlbums/{aid}")   //working
			 public void updateAlbum(@RequestBody Album album,@PathVariable int aid)
			 {
				System.out.println("inside updatealbum of controller");
				manager.update(album,aid);
			 }
			
		}





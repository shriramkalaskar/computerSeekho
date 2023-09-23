package com.example.controllerCourseBatchStd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entityCourseBatchStd.Batch;
import com.example.servicesCourseBatchStd.BatchManager;

@RestController
@CrossOrigin("*")
public class BatchController {
	@Autowired
	private BatchManager service;
	
	
	  @PostMapping("/api/addBatch") 
	  public void saveBatch(@RequestBody Batch ref) {
		  System.out.println("a");
		  System.out.println(ref);
	  service.save(ref); 
	  }
	 
	
	@GetMapping("/api/batch")
	public List<Batch> getAllBatch()
	{
		return service.getAll();
	}
	@GetMapping("/api/batch/{batchno}")
	public Batch getBatch(@PathVariable int batchno)
	{
		return service.getBatch(batchno); 
	}
	
	@GetMapping("/api/upcomingBatch")
	public List<Batch> getUpcomingBatch(){
		return service.getUpcomingBatch();
	}
	
	@GetMapping("/api/getCurrentBatch")
	public List<Batch> getCurrentBatch(){
		return service.getCurrentBatch();
	}
	
	@GetMapping("/api/getBatchByName/{batchName}")
	public List<Batch> getBatchByName(@PathVariable String batchName){
		return service.getBatchByName(batchName);
	}
	
	@GetMapping("/api/getPastBatch")
	public List<Batch> getPastBatch(){
		return service.getPastBatch(); 
	}

	@GetMapping("/api/getBatchByCourseId/{cid}")
	public List<Batch> getBatchByCourseId(@PathVariable int cid){
		return service.getBatchByCourseId(cid); 
	}
}



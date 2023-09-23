package com.example.controllerPlacement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entityPlacement.Placement;
import com.example.servicesPlacement.PlacementManager;



@RestController
@CrossOrigin("*")
public class PlacementController {
	@Autowired
	private PlacementManager manager;

	@GetMapping(value = "/api/getplacement")
	public List<Placement> getplaced() {
		// TODO Auto-generated method stub
		return manager.getPlacement();
	}

	@GetMapping(value="/api/placement/{id}")
	public Optional<Placement> getbyid(@PathVariable int id){
		return manager.getPlacement(id);}
	
	
	@PutMapping(value="api/placementedit/{pid}")
	public void updatePlacement(@RequestBody Placement p, @PathVariable int pid) {
		// TODO Auto-generated method stub
		      manager.updatePlacement(p, pid);
	}

	@PostMapping(value = "/api/addplacement")
	public void addplace(@RequestBody Placement p) {
		manager.addPlacement(p);

	}

}

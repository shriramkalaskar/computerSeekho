package com.example.servicesPlacement;

import java.util.List;
import java.util.Optional;

import com.example.entityPlacement.Placement;



public interface PlacementManager {
	void addPlacement(Placement p);

	List<Placement> getPlacement();
	
	Optional<Placement> getPlacement(int id);

	void updatePlacement(Placement p, int id);

}

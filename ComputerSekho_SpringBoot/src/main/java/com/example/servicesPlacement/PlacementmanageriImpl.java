package com.example.servicesPlacement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entityPlacement.Placement;
import com.example.repositoryPlacement.PlacementRepository;


@Service
public class PlacementmanageriImpl implements PlacementManager
{
	@Autowired
   PlacementRepository repository;
	@Override
	public void addPlacement(Placement placement) {
		repository.save(placement);
		
	}

	@Override
	public List<Placement> getPlacement() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void updatePlacement(Placement p, int id) {
		// TODO Auto-generated method stub
		repository.update(p.getCoursename(),p.getBatchid(), p.getPlacedstudents(),p.getTotal_student(), p.getPlacemetid());
	}

	@Override
	public Optional<Placement> getPlacement(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}
	
	

}

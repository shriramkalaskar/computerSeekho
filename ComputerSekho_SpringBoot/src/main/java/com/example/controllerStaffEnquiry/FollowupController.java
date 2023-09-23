package com.example.controllerStaffEnquiry;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entityStaffEnquiry.Enquiry;
import com.example.entityStaffEnquiry.Followup;
import com.example.servicesStaffEnquiry.FollowupManagerImp;


@RestController
@CrossOrigin("*")
public class FollowupController {
	@Autowired
	FollowupManagerImp folloup;
	@GetMapping("api/followup")
	public List<Enquiry> GetAllEnquiry()
	{
		return folloup.GetAllFollowUp();
	}
	
	@GetMapping(value="api/followup/{id}")
	public List<Enquiry>GetByStaff(@PathVariable int id)
	{
		return folloup.GetFollowUpByStaffId(id);
	}
	
	@PostMapping(value = "api/followup/")
	public void add(@RequestBody Followup follow)
	{
		folloup.Add(follow);
	}
}

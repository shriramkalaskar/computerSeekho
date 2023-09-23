package com.example.servicesStaffEnquiry;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entityStaffEnquiry.Enquiry;
import com.example.entityStaffEnquiry.Followup;
import com.example.repositoryStaffEnquiry.FollowupRepository;


@Service
public class FollowupManagerImp implements FollowupManager{
	@Autowired
	FollowupRepository followuprepo;

	@Override
	public List<Enquiry> GetAllFollowUp() {
		// TODO Auto-generated method stub
	
		return followuprepo.getAll();
	}

	@Override
	public List<Enquiry> GetFollowUpByStaffId(int staffid) {
		// TODO Auto-generated method stub
		return followuprepo.getBystaffId(staffid);
	}

	@Override
	public void Add(Followup follow) {
		// TODO Auto-generated method stub
		
		followuprepo.save(follow);
	}

}

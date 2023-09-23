package com.example.servicesStaffEnquiry;

import java.util.List;
import java.util.Optional;

import com.example.entityStaffEnquiry.*;

public interface FollowupManager {
	public void Add(Followup follow);
	public List<Enquiry> GetAllFollowUp();
	public List<Enquiry> GetFollowUpByStaffId(int staffid);
}
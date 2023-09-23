package com.example.servicesStaffEnquiry;

import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entityStaffEnquiry.Enquiry;
import com.example.entityStaffEnquiry.Staff;
import com.example.repositoryStaffEnquiry.StaffRepository;


@Service
public class StaffManagerImpl implements StaffManager{
	@Autowired
	StaffRepository repository;
	@Autowired
	StaffRepository srep;

	@Override
	public void addStaff(Staff s) {
		// TODO Auto-generated method stub
		srep.save(s);
	}

	@Override
	public List<Staff> getStaff() {
		// TODO Auto-generated method stub

		return srep.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		srep.deleteById(id);
	}

	@Override
	public void updateStaffData(Staff s, int id) {
		// TODO Auto-generated method stub
		srep.updateStaff(s.getStaff_name(), s.getPhoto_url(), s.getStaff_mobile(), s.getStaff_email(),
				s.getStaff_username(), s.getStaff_password(), s.getStaff_role(), s.isStaff_isactive(), id);
	}

	@Override
	public Optional<Staff> getStaff(int id) {
		// TODO Auto-generated method stub
		return srep.findById(id);
	}

	@Override
	public void inactive(boolean status, int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Staff> stafflogin(String name) {
		// TODO Auto-generated method stub
		return srep.findByUsername(name);
	}

	@Override
	public List<Enquiry> getAllEnquiriesForStaff(int id) {
		Optional<Staff> staffOptional = srep.findById(id);
		if (staffOptional.isPresent()) {
			Staff staff = staffOptional.get();
			//return staff.getEnquiries();
			return null;
		}
		return new ArrayList<>();// Return an empty list if staff not found
	}

}
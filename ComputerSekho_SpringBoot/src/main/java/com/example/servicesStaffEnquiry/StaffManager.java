package com.example.servicesStaffEnquiry;
import java.util.List;
import java.util.Optional;

import com.example.entityStaffEnquiry.*;

public interface StaffManager {
	void addStaff(Staff s);
	List<Staff> getStaff();
	void delete(int id);
	void updateStaffData(Staff s,int id);
	Optional<Staff> getStaff(int id);
	void inactive(boolean status, int id);
	Optional<Staff> stafflogin(String name);
	
	 public List<Enquiry> getAllEnquiriesForStaff(int staffId);
}

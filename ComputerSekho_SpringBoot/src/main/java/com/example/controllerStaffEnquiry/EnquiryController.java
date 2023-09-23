package com.example.controllerStaffEnquiry;

import java.util.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entityStaffEnquiry.Enquiry;
import com.example.servicesStaffEnquiry.EnquiryManager;
import com.example.servicesStaffEnquiry.EnquiryManagerImpl;



@RestController
@CrossOrigin("*")
public class EnquiryController {

	@Autowired
	private EnquiryManager enq;

	@PostMapping(value = "api/new_enquiry")
	public void FormSubmit(@RequestBody Enquiry enquiry) {
		// Get the enquiry date
		Date enquiryDate = enquiry.getEnquiry_date();

		// Calculate the follow-up date by adding three days
		Calendar cal = Calendar.getInstance();
		cal.setTime(enquiryDate);
		cal.add(Calendar.DAY_OF_MONTH, 3);
		Date followUpDate = cal.getTime();

		// Set the follow-up date in the Enquiry object
		enquiry.setFollow_up_date(followUpDate);

		enq.Formsubmit(enquiry);
	}
	// @DeleteMapping(value="/api/del_enquiry/{id}")
	// public void DeleteById(@PathVariable int id)
	// {
	// enq.DeleteById(id);
	// }

	@GetMapping(value = "api/getenq")
	public List<Enquiry> GetAllList() {
		return enq.GetAll();
	}

	@GetMapping(value = "api/getById/{id}")
	public Optional<Enquiry> GetById(@PathVariable int id) {
		return enq.FindById(id);
	}

	@GetMapping(value = "api/getName/{name}")
	public Optional<Enquiry> GetByName(@PathVariable String name) {
		Optional<Enquiry> p = enq.GetByName(name);
		return p;
	}

	/*
	 * @PutMapping(value="api/update/{id}")
	 * public void updatedata(@RequestBody Enquiry e,@PathVariable int id)
	 * {
	 * enq.update(e, id);
	 * }
	 */

	@PutMapping("api/update_enquiry/{enquiryId}")
	public void updateEnquiry(@PathVariable int enquiryId, @RequestBody Enquiry enquiry) {

		enq.updateEnquiry(enquiryId, enquiry);

	}

	@GetMapping("api/getEnquiriesByStaffId/{staff_id}")
	public List<Enquiry> getEnquiriesByStaffId(@PathVariable int staff_id) {
		return enq.getEnquiriesByStaffId(staff_id);
	}
	
	@PostMapping("api/updateprocessflag/{enquiryId}")
    public void updateEnquiry( @PathVariable int enquiryId) {
        
            enq.updateprocessflag(enquiryId);
            
    }


}

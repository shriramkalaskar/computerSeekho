package com.example.entityStaffEnquiry;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Followup {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int followup_id;
	private int enquiry_id;
	private int staff_id;
	private String followup_msg;
	public int getFollowup_id() {
		return followup_id;
	}
	public void setFollowup_id(int followup_id) {
		this.followup_id = followup_id;
	}
	public int getEnquiry_id() {
		return enquiry_id;
	}
	public void setEnquiry_id(int enquiry_id) {
		this.enquiry_id = enquiry_id;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getFollowup_msg() {
		return followup_msg;
	}
	public void setFollowup_msg(String followup_msg) {
		this.followup_msg = followup_msg;
	}
	
	
	
}

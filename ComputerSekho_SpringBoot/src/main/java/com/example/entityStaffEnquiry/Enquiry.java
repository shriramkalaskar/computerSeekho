package com.example.entityStaffEnquiry;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Enquiry {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int enquiry_id;
	String enquirer_name;
	
	String enquirer_mobile;
	String enquirer_email_id;
	Date enquiry_date;
	Date follow_up_date;
	String closure_reason;
	String followup_msg;
	String enquirer_query;
	boolean enquiry_processed_flag=false;
	int staff_id;
	public int getEnquiry_id() {
		return enquiry_id;
	}
	public void setEnquiry_id(int enquiry_id) {
		this.enquiry_id = enquiry_id;
	}
	public String getEnquirer_name() {
		return enquirer_name;
	}
	public void setEnquirer_name(String enquirer_name) {
		this.enquirer_name = enquirer_name;
	}
	public String getEnquirer_mobile() {
		return enquirer_mobile;
	}
	public void setEnquirer_mobile(String enquirer_mobile) {
		this.enquirer_mobile = enquirer_mobile;
	}
	public String getEnquirer_email_id() {
		return enquirer_email_id;
	}
	public void setEnquirer_email_id(String enquirer_email_id) {
		this.enquirer_email_id = enquirer_email_id;
	}
	public Date getEnquiry_date() {
		return enquiry_date;
	}
	public void setEnquiry_date(Date enquiry_date) {
		this.enquiry_date = enquiry_date;
	}
	public Date getFollow_up_date() {
		return follow_up_date;
	}
	public void setFollow_up_date(Date follow_up_date) {
		this.follow_up_date = follow_up_date;
	}
	public String getClosure_reason() {
		return closure_reason;
	}
	public void setClosure_reason(String closure_reason) {
		this.closure_reason = closure_reason;
	}
	public String getFollowup_msg() {
		return followup_msg;
	}
	public void setFollowup_msg(String followup_msg) {
		this.followup_msg = followup_msg;
	}
	public String getEnquirer_query() {
		return enquirer_query;
	}
	public void setEnquirer_query(String enquirer_query) {
		this.enquirer_query = enquirer_query;
	}
	public boolean isEnquiry_processed_flag() {
		return enquiry_processed_flag;
	}
	public void setEnquiry_processed_flag(boolean enquiry_processed_flag) {
		this.enquiry_processed_flag = enquiry_processed_flag;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
   
	
}

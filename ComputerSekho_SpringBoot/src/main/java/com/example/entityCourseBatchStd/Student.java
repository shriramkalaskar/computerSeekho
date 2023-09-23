package com.example.entityCourseBatchStd;

import java.util.Date;
import java.util.Set;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
	
	@Column(nullable = false)
	private String  student_name ;
	
	@Column(nullable = false)
	private String student_address;
	
	@Column(nullable = false, length=8)
	private String student_gender;
	
	@Column(nullable = false)
	private Date student_dob;
	
	@Column(nullable = false, length=20)
	private String  student_qualification;
	
	@Column(nullable = false)
	private String  student_mobile ;
	
	private int batch_id;
	
	private int course_id;
	private int enquiry_id;
	
	

		

	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_address() {
		return student_address;
	}
	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}
	public String getStudent_gender() {
		return student_gender;
	}
	public void setStudent_gender(String student_gender) {
		this.student_gender = student_gender;
	}
	public Date getStudent_dob() {
		return student_dob;
	}
	public void setStudent_dob(Date student_dob) {
		this.student_dob = student_dob;
	}
	public String getStudent_qualification() {
		return student_qualification;
	}
	public void setStudent_qualification(String student_qualification) {
		this.student_qualification = student_qualification;
	}
	public String getStudent_mobile() {
		return student_mobile;
	}
	public void setStudent_mobile(String student_mobile) {
		this.student_mobile = student_mobile;
	}
	
	
	@Override
	public String toString() {
		return "student [student_id=" + student_id + ", student_name=" + student_name + ", student_address="
				+ student_address + ", student_gender=" + student_gender + ", student_dob=" + student_dob
				+ ", student_qualification=" + student_qualification + ", student_mobile=" + student_mobile
				+  ", batch_id="
				+ "]";
	}
	public int getEnquiry_id() {
		return enquiry_id;
	}
	public void setEnquiry_id(int enquiry_id) {
		this.enquiry_id = enquiry_id;
	}
	
	

}

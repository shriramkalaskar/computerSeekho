package com.example.entityPlacement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Placement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int placemetid;
	private String coursename;
	private int batchid;
	private int total_student;
	private int placedstudents;

	@Override
	public String toString() {
		return "Placement [placemetid=" + placemetid + ", coursename=" + coursename + ", batchid=" + batchid
				+ ", total_student=" + total_student + ", placedstudents=" + placedstudents + "]";
	}

	public int getTotal_student() {
		return total_student;
	}

	public void setTotal_student(int total_student) {
		this.total_student = total_student;
	}

	public int getPlacemetid() {
		return placemetid;
	}

	public void setPlacemetid(int placemetid) {
		this.placemetid = placemetid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public int getBatchid() {
		return batchid;
	}

	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}

	public int getPlacedstudents() {
		return placedstudents;
	}

	public void setPlacedstudents(int placedstudents) {
		this.placedstudents = placedstudents;
	}

}

package com.example.entityPayment;

import java.sql.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payment_id;
	private String payment_transaction_id;
	private Date payment_date;
	private boolean payment_done;
	private double batch_fees;
	private double fees_paid;
	private String payment_mode ;
	private int student_id;
	private double remaining_fees;
	
	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public double getBatch_fees() {
		return batch_fees;
	}

	public void setBatch_fees(double batch_fees) {
		this.batch_fees = batch_fees;
	}

	public double getFees_paid() {
		return fees_paid;
	}

	public void setFees_paid(double fees_paid) {
		this.fees_paid = fees_paid;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getPayment_transaction_id() {
		return payment_transaction_id;
	}

	public void setPayment_transaction_id(String payment_transaction_id) {
		this.payment_transaction_id = payment_transaction_id;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public boolean isPayment_done() {
		return payment_done;
	}

	public void setPayment_done(boolean payment_done) {
		this.payment_done = payment_done;
	}

	public String getPayment_type() {
		return payment_mode;
	}

	public void setPayment_type(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public double getRemaining_fees() {
		return remaining_fees;
	}

	public void setRemaining_fees(double remaining_fees) {
		this.remaining_fees = remaining_fees;
	}
	
	
	
	
	

}
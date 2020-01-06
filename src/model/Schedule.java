package model;

import java.sql.Timestamp;
import java.util.Date;

public class Schedule {
	private Doctor doctor;
	private Timestamp date;
	private User user;
	
	private boolean paid;
	private Analysis analysis;
	
	public Schedule() {
		
	}

	public Schedule(Doctor doctor, Timestamp date, User user, boolean paid, Analysis type) {
		this.doctor = doctor;
		this.date = date;
		this.user = user;
		this.paid = paid;
		this.analysis = type;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public String getAnalysis() {
		return analysis.toString();
	}

	public void setAnalysis(Analysis type) {
		this.analysis = type;
	}
	
	
}

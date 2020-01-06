package model;

import java.util.ArrayList;

public class Doctor {
	private String name;
	private String surname;
	private String ssnb;
	private String mail;
	public float salary;
	public ArrayList<Schedule> schedule;
	
	
	
	
	public Doctor() {

		name = null;
		surname = null;
		ssnb = null;
		mail = null;
		salary = 0;
		schedule = null;

	}
	
	public Doctor(String nameInput, String SurnameInput, String ssnbInput,String mailInput, float salaryInput) {

		name = nameInput;
		surname = SurnameInput;
		ssnb = ssnbInput;
		mail = mailInput;
		salary = salaryInput;
		schedule = new ArrayList<Schedule>();

	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSsnb() {
		return ssnb;
	}
	public void setSsnb(String ssnb) {
		this.ssnb = ssnb;
	}
	
	
	
	public String getMail() {
		return mail;
	}

	public float getSalary() {
		return salary;
	}
	public ArrayList<Schedule> getSchedule() {
		return schedule;
	}
	
	//Get Schedule by date, user...
	
	public void addSchedule(Schedule scheduleInput) {
		schedule.add(scheduleInput);
	}

}

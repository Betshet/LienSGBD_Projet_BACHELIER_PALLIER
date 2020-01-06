package model;

public class User {
	

	private String name;
	private String surname;
	private String ssnb;
	private String address;
	private String mail;
	
	
	
	public User() {

		name = null;
		surname = null;
		ssnb = null;
		address = null;
		mail = null;
	}
	
	public User(String nameInput, String SurnameInput, String ssnbInput, String addressInput, String mailInput) {

		name = nameInput;
		surname = SurnameInput;
		ssnb = ssnbInput;
		address = addressInput;
		mail = mailInput;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
	
}

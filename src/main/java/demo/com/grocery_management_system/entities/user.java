package demo.com.grocery_management_system.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class user {
	
	@Id
	@Column(name="id", length=10)
	private String userId;
	@Column(name="username", length=15)
	private String username;
	@Column(name="password", length=20)
	private String password;
	@Column(name="email", length=25)
	private String email;
	@Column(name="FirstName", length=10)
	private String Firstname;
	@Column(name="LastName", length=10)
	private String Lastname;
	@Column(name="Address", length=50)
	private String Address;
	@Column(name="PhoneNumber", length=10)
	private String phonenumber;
	@Column(name="Dob")
	private LocalDate DOB;
	@Column(name="Dateofjoined")
	private LocalDate DateJoined;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	public LocalDate getDateJoined() {
		return DateJoined;
	}
	public void setDateJoined(LocalDate dateJoined) {
		DateJoined = dateJoined;
	}
	@Override
	public String toString() {
		return "user [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", Firstname=" + Firstname + ", Lastname=" + Lastname + ", Address=" + Address + ", phonenumber="
				+ phonenumber + ", DOB=" + DOB + ", DateJoined=" + DateJoined + "]";
	}
	public user(String userId, String username, String password, String email, String firstname, String lastname,
			String address, String phonenumber, LocalDate dOB, LocalDate dateJoined) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		Firstname = firstname;
		Lastname = lastname;
		Address = address;
		this.phonenumber = phonenumber;
		DOB = dOB;
		DateJoined = dateJoined;
	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
}

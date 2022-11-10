package com.masai.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	@Column(unique = true)
	@NotNull(message = "username cannot be null")
	@Size(min = 3, max = 10, message = "length of username must be between 3 & 10")
	private String username;

	@NotNull(message = "password cannot be null")
	@Size(min = 5, max = 8, message = "password length should be between 5 & 8.")
	private String password;

	private String address;

	@NotNull(message = "mobile number cannot be null")
	@Pattern(regexp = "[789]{1}[0-9]{9}", message = "invalid mobile number")
	private String mobile;

	@Email
	private String email;

	private LocalDate dateOfCreation = LocalDate.now();

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(
			@NotNull(message = "username cannot be null") @Size(min = 3, max = 10, message = "length of username must be between 3 & 10") String username,
			@NotNull(message = "password cannot be null") @Size(min = 5, max = 8, message = "password length should be between 5 & 8.") String password,
			String address,
			@NotNull(message = "mobile number cannot be null") @Pattern(regexp = "[789]{1}[0-9]{9}", message = "invalid mobile number") String mobile,
			@Email String email, LocalDate dateOfCreation) {
		super();
		this.username = username;
		this.password = password;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.dateOfCreation = dateOfCreation;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(LocalDate dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", address=" + address + ", mobile=" + mobile
				+ ", email=" + email + ", dateOfCreation=" + dateOfCreation + "]";
	}

}

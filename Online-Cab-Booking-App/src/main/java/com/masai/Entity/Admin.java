package com.masai.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor

@PrimaryKeyJoinColumn(name="adminId")
public class Admin extends Abstractuser {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@EqualsAndHashCode.Include
	private Integer userId;
	
	@Size(min = 3, max = 255, message = "{nameRange}")
	@NotNull(message = "{notNull}")
	private String Username;
	
	@Size(min = 4, max = 20, message = "{PasswordRange}")
	@NotNull(message = "{notNull}")
	private String Password;
	


	@Size(min = 10, message = "{MobileRange}")
	private String Mobile;


	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private Address address;
	
	@Email
	@NotNull(message = "{notNull}")
	private String Email;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Admin(Integer userId,
			@Size(min = 3, max = 255, message = "{nameRange}") @NotNull(message = "{notNull}") String username,
			@Size(min = 4, max = 20, message = "{PasswordRange}") @NotNull(message = "{notNull}") String password,
			@Size(min = 10, message = "{MobileRange}") String mobile, Address address,
			@javax.validation.constraints.Email @NotNull(message = "{notNull}") String email) {
		super();
		this.userId = userId;
		Username = username;
		Password = password;
		Mobile = mobile;
		this.address = address;
		Email = email;
	}

	public Admin() {
		super();
	}
	
	
}

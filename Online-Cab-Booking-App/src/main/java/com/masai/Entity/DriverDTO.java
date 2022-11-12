package com.masai.Entity;

import lombok.Data;

@Data
public class DriverDTO {
	
private Integer userId;
	
	private String Username;
	
	private String Mobile;
	
	private Address address;
	
	private String Email;
	
	private Integer licenseNo;
	
	private Double rating;
	
	private Boolean available;

	
	private Cab cab;

	private TripBooking tripBooking;

}

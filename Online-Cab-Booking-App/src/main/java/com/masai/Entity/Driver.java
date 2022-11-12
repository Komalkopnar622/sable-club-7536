package com.masai.Entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@PrimaryKeyJoinColumn(name="driverId")
public class Driver {
	
	@Min(value=1, message="id should be more than 1")
	private Integer licenseNo;
	@Min(value=1, message="id should be more than 1")
	private Double rating;
	private Boolean available;

	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="cabId")
	private Cab cab;


	@OneToMany(cascade = CascadeType.ALL,mappedBy = "driver",orphanRemoval = true)
	@JsonIgnore
	private List<TripBooking> tripBooking;


	public Integer getLicenseNo() {
		return licenseNo;
	}


	public void setLicenseNo(Integer licenseNo) {
		this.licenseNo = licenseNo;
	}


	public Double getRating() {
		return rating;
	}


	public void setRating(Double rating) {
		this.rating = rating;
	}


	public Boolean getAvailable() {
		return available;
	}


	public void setAvailable(Boolean available) {
		this.available = available;
	}


	public Cab getCab() {
		return cab;
	}


	public void setCab(Cab cab) {
		this.cab = cab;
	}


	public List<TripBooking> getTripBooking() {
		return tripBooking;
	}


	public void setTripBooking(List<TripBooking> tripBooking) {
		this.tripBooking = tripBooking;
	}


	public Address getAddress() {
		// TODO Auto-generated method stub
		return null;
	}


	

}

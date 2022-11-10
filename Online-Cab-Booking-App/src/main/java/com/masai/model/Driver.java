package com.masai.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Driver {
	
	@Id
	private int driverId;
	private String licenceNo;
	private float rating;
	private Boolean available;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cabId")
	private Cab cab;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "driver")
	private List<TripBooking> tripBooking;

	public Driver() {
		super();
	}

	public Driver(int driverId, String licenceNo, float rating, Boolean available, Cab cab,
			List<TripBooking> tripBooking) {
		super();
		this.driverId = driverId;
		this.licenceNo = licenceNo;
		this.rating = rating;
		this.available = available;
		this.cab = cab;
		this.tripBooking = tripBooking;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
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

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", licenceNo=" + licenceNo + ", rating=" + rating + ", available="
				+ available + ", cab=" + cab + ", tripBooking=" + tripBooking + "]";
	}
	
	
	

}

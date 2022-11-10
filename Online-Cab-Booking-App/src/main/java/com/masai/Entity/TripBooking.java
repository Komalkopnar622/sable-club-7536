package com.masai.Entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.NonNull;

@Entity
public class TripBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer TripBookingId;
	
	@NonNull
	private Integer CustomerId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="driverId",referencedColumnName = "driverID")
	private Driver driver;
	private String fromLocation;
	private String toLocation;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private boolean status;
	private float distanceInKm;
	private float bill;
	
	
	public TripBooking() {
		super();
	}


	public TripBooking(Integer tripBookingId, Integer customerId, Driver driver, String fromLocation, String toLocation,
			LocalDateTime fromDateTime, LocalDateTime toDateTime, boolean status, float distanceInKm, float bill) {
		super();
		TripBookingId = tripBookingId;
		CustomerId = customerId;
		this.driver = driver;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
	}


	public Integer getTripBookingId() {
		return TripBookingId;
	}


	public void setTripBookingId(Integer tripBookingId) {
		TripBookingId = tripBookingId;
	}


	public Integer getCustomerId() {
		return CustomerId;
	}


	public void setCustomerId(Integer customerId) {
		CustomerId = customerId;
	}


	public Driver getDriver() {
		return driver;
	}


	public void setDriver(Driver driver) {
		this.driver = driver;
	}


	public String getFromLocation() {
		return fromLocation;
	}


	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}


	public String getToLocation() {
		return toLocation;
	}


	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}


	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}


	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}


	public LocalDateTime getToDateTime() {
		return toDateTime;
	}


	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public float getDistanceInKm() {
		return distanceInKm;
	}


	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}


	public float getBill() {
		return bill;
	}


	public void setBill(float bill) {
		this.bill = bill;
	}


	@Override
	public String toString() {
		return "TripBooking [TripBookingId=" + TripBookingId + ", CustomerId=" + CustomerId + ", driver=" + driver
				+ ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + ", fromDateTime=" + fromDateTime
				+ ", toDateTime=" + toDateTime + ", status=" + status + ", distanceInKm=" + distanceInKm + ", bill="
				+ bill + "]";
	}
	
	
	

}

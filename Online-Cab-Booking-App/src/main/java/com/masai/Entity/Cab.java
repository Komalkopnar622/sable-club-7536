package com.masai.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cabId;
	private String carType;
	private float ratePerKm;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "cab")
	private Driver driver;

	public Cab() {
		super();
	}

	public Cab(Integer cabId, String carType, float ratePerKm, Driver driver) {
		super();
		this.cabId = cabId;
		this.carType = carType;
		this.ratePerKm = ratePerKm;
		this.driver = driver;
	}

	public Integer getCabId() {
		return cabId;
	}

	public void setCabId(Integer cabId) {
		this.cabId = cabId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public float getRatePerKm() {
		return ratePerKm;
	}

	public void setRatePerKm(float ratePerKm) {
		this.ratePerKm = ratePerKm;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@Override
	public String toString() {
		return "Cab [cabId=" + cabId + ", carType=" + carType + ", ratePerKm=" + ratePerKm + ", driver=" + driver + "]";
	}
	
	
	

}

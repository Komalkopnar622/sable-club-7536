package com.masai.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cab {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cabId;
	private String carType;
	private Integer ratePerKm;

	@OneToOne(cascade=CascadeType.ALL,mappedBy="cab",orphanRemoval = true)
	@JsonIgnore

	private Driver driver;

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

	public Integer getRatePerKm() {
		return ratePerKm;
	}

	public void setRatePerKm(Integer ratePerKm) {
		this.ratePerKm = ratePerKm;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	

}

package com.masai.Entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TripBooking {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private Integer TripBookingId;
	   @NonNull
	   private Integer CustomerId; 
	   
	   @ManyToOne(cascade=CascadeType.ALL)
	   @JoinColumn(name="driver_id",referencedColumnName = "driverID")
	   private Driver driver;

	   @NotNull(message = "{From Location notNull}")
	   private String From_location;
	   
	   @NotNull(message = "{To Loccation notNull}")
	   private String To_location;
	   
	   
	    @FutureOrPresent(message = "{futOrPres}")
	    @NotNull(message = "{data not null}")
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
     private LocalDate Fromdate_time;
	    
	    
	    @FutureOrPresent(message = "{futOrPres}")
	    @NotNull(message = "{data not null}")
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
     private LocalDate Todate_time;
	   
     private Integer km;
     private Integer  Totalamount;
     private Boolean Payment;
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
	public String getFrom_location() {
		return From_location;
	}
	public void setFrom_location(String from_location) {
		From_location = from_location;
	}
	public String getTo_location() {
		return To_location;
	}
	public void setTo_location(String to_location) {
		To_location = to_location;
	}
	public LocalDate getFromdate_time() {
		return Fromdate_time;
	}
	public void setFromdate_time(LocalDate fromdate_time) {
		Fromdate_time = fromdate_time;
	}
	public LocalDate getTodate_time() {
		return Todate_time;
	}
	public void setTodate_time(LocalDate todate_time) {
		Todate_time = todate_time;
	}
	public Integer getKm() {
		return km;
	}
	public void setKm(Integer km) {
		this.km = km;
	}
	public Integer getTotalamount() {
		return Totalamount;
	}
	public void setTotalamount(Integer totalamount) {
		Totalamount = totalamount;
	}
	public Boolean getPayment() {
		return Payment;
	}
	public void setPayment(Boolean payment) {
		Payment = payment;
	}
	
	
    

}

package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.TripBooking;
import com.masai.Exception.BookingNotFoundException;
import com.masai.Exception.DriverNotFoundException;
import com.masai.Service.TripService;

@RestController
public class TripBookingController {
	
	@Autowired
	private TripService tService;
	
	@PostMapping("/tripbooking")
	public ResponseEntity<TripBooking> insertTripBookingHandler(@RequestBody TripBooking trp) throws BookingNotFoundException, DriverNotFoundException{
		TripBooking tb = tService.insertTripBooking(trp);
		return new ResponseEntity<TripBooking>(tb,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/tripbooking")
	public ResponseEntity<TripBooking> updateTripHandler(@RequestBody TripBooking tb) throws BookingNotFoundException{
		
		TripBooking tb1 = tService.updateTripBooking(tb);
		
		return new ResponseEntity<TripBooking>(tb1,HttpStatus.OK);	
	}
	
	
	@DeleteMapping("/tripbooking/{id}")
	public ResponseEntity<TripBooking> deleteTripBookingHandler(@PathVariable Integer id) throws BookingNotFoundException{
		TripBooking tb = tService.deleteTripBooking(id);
		return new ResponseEntity<TripBooking>(tb,HttpStatus.OK);	
	}
	
	
	@GetMapping("/tripbooking/{id}")
	public ResponseEntity<List<TripBooking>> getAllTripsOfCustomerByIdHandler(@PathVariable Integer customerId) throws BookingNotFoundException{
		List<TripBooking> tb = tService.viewAllTripsOfCustomer(customerId);
		return new ResponseEntity<List<TripBooking>>(tb,HttpStatus.OK);
	}
	
	@GetMapping("/tripbooking/{customerId}")
	public float calculateBillHandler(@PathVariable Integer customerId) throws BookingNotFoundException{
		float totalBill = tService.calculateBill(customerId);
		return totalBill;
	}
	
	
	

}

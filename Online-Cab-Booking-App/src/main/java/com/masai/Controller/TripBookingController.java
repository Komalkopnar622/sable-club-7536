package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.TripBooking;
import com.masai.Exception.BookingNotFoundException;
import com.masai.Service.TripService;

@RestController
public class TripBookingController {
	
	@Autowired
	private TripService tService;
	
	@PostMapping("/tripbooking")
	public ResponseEntity<TripBooking> insertTripBookingHandler(@RequestBody TripBooking trp) throws BookingNotFoundException{
		TripBooking tb = tService.insertTripBooking(trp);
		return new ResponseEntity<TripBooking>(tb,HttpStatus.CREATED);
		
	}

}

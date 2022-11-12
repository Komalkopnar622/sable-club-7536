package com.masai.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.TripBooking;
import com.masai.Exception.DriverNotFoundException;
import com.masai.Exception.InvalidId;
import com.masai.Service.TripService;

@RestController
public class TripBookingController {
	
	@Autowired
	TripService service;
	
	
	@PostMapping("/trip")
	public TripBooking Add( @Valid @RequestBody TripBooking trip) throws InvalidId, DriverNotFoundException
	{
		return service.AddTrip(trip);
	}
    
	@GetMapping("/trips")
	public List<TripBooking> getAllCustomer()
	{    
		return service.alltrip() ;
	}
	@PutMapping("/tripupdate/{id}")
	public TripBooking updateStudent(@Valid @RequestBody TripBooking trip,@PathVariable("id")Integer id)
	{
		
		return service.updateTrip(trip,id);
	}
	 @DeleteMapping("/tripdelete/{id}")
		public String delete(@PathVariable("id")Integer id) {
			
	    	return service.deletetrip(id);
		}
	 @PatchMapping("/tripend/{id}")
		public TripBooking end(@PathVariable("id")Integer id) {
			
	    	return service.tripEnd(id);
		}
	
	

}

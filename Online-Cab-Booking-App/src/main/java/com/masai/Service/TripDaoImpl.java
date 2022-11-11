package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Customer;
import com.masai.Entity.Driver;
import com.masai.Entity.TripBooking;
import com.masai.Exception.BookingNotFoundException;
import com.masai.Exception.DriverNotFoundException;
import com.masai.Repository.CustomerRepo;
import com.masai.Repository.DriverRepo;
import com.masai.Repository.TripRepo;

@Service
public class TripDaoImpl implements TripService{
	
	@Autowired
	TripRepo tRepo;
	
	@Autowired
	CustomerRepo cRepo;
	
	@Autowired
	DriverRepo dRepo;

	@Override
	public TripBooking insertTripBooking(TripBooking tripbooking) throws BookingNotFoundException, DriverNotFoundException {
		
		cRepo.findById(tripbooking.getCustomerId());
		
		List<Driver> driver = dRepo.findByAvailable();
		
		if(driver.size()==0) {
			throw new DriverNotFoundException("Driver not found at this moment");
		}
		driver.get(0).setAvailable(false);
		dRepo.save(driver.get(0));
		float km = tripbooking.getDistanceInKm(); 
		float price = driver.get(0).getCab().getRatePerKm();
		tripbooking.setBill(price*km);
		tripbooking.setDriver(driver.get(0));
	
		TripBooking tb = tRepo.save(tripbooking);
		
		if(tb == null)
			throw new BookingNotFoundException("Booking not confirmed.");
		else
			return tb;
	}
	
	

	@Override
	public TripBooking updateTripBooking(TripBooking tripbooking) throws BookingNotFoundException {
		
		Optional<TripBooking> tb = tRepo.findById(tripbooking.getTripBookingId());
		
		if(tb.isPresent()) {
			tb.get().setCustomerId(tripbooking.getCustomerId());
			tb.get().setFromLocation(tripbooking.getFromLocation());
			tb.get().setToLocation(tripbooking.getToLocation());
			tb.get().setFromDateTime(tripbooking.getFromDateTime());
			tb.get().setToDateTime(tripbooking.getToDateTime());
			tb.get().setDistanceInKm(tripbooking.getDistanceInKm());
			
			TripBooking tb1 = tRepo.save(tb.get());
			
			return tb1;
		}else {
			throw new BookingNotFoundException("Booking not found");
		}
	}
	
	

	@Override
	public TripBooking deleteTripBooking(Integer tripBookinkId) throws BookingNotFoundException {
		Optional<TripBooking> tb = tRepo.findById(tripBookinkId);
		
		if(tb.isPresent()) {
			TripBooking tb1 = tb.get();
		    tRepo.delete(tb1);
		    return tb1;
		}else {
			throw new BookingNotFoundException("Booking not found");
		}	
	}
	
	

	@Override
	public List<TripBooking> viewAllTripsOfCustomer(Integer customerId) throws BookingNotFoundException {
		List<TripBooking> tb = tRepo.findByCustomerId(customerId);
		
		if(tb.size()==0) {
			throw new BookingNotFoundException("Bookimgs not found");
		}else {
			return tb;
		}
	}

	@Override
	public float calculateBill(Integer customerId) throws BookingNotFoundException {
		float tb = 0;
		tb = tRepo.totalBillBycustomerId(customerId);
		
		if(tb == 0) {
			throw new BookingNotFoundException("Booking not found");
		}else {
			return tb;
		}
	}

}

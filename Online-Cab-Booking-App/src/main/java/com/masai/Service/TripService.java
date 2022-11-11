package com.masai.Service;

import java.util.List;

import com.masai.Entity.TripBooking;
import com.masai.Exception.BookingNotFoundException;
import com.masai.Exception.DriverNotFoundException;

public interface TripService {
	
	public TripBooking insertTripBooking(TripBooking tripbooking) throws BookingNotFoundException, DriverNotFoundException;
	public TripBooking updateTripBooking(TripBooking tripbooking) throws BookingNotFoundException;
	public TripBooking deleteTripBooking(Integer tripBookinkId) throws BookingNotFoundException;
	public List<TripBooking> viewAllTripsOfCustomer(Integer customerId) throws BookingNotFoundException;
	public float calculateBill(Integer customerId)throws BookingNotFoundException;

}

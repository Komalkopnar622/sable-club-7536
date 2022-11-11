package com.masai.Service;

import java.util.List;

import com.masai.Entity.TripBooking;
import com.masai.Exception.BookingNotFoundException;

public interface TripService {
	
	public TripBooking insertTripBooking(TripBooking tripbooking) throws BookingNotFoundException;
	public TripBooking updateTripBooking(TripBooking tripbooking) throws BookingNotFoundException;
	public TripBooking deleteTripBooking(Integer tripBookinkId) throws BookingNotFoundException;
	public List<TripBooking> viewAllTripsCustomer(Integer customerId) throws BookingNotFoundException;
	public TripBooking calculateBill(Integer customerId)throws BookingNotFoundException;

}

package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.TripBooking;
import com.masai.Exception.BookingNotFoundException;
import com.masai.Repository.TripRepo;

@Service
public class TripDaoImpl implements TripService{
	
	@Autowired
	TripRepo tRepo;

	@Override
	public TripBooking insertTripBooking(TripBooking tripbooking) throws BookingNotFoundException {
		TripBooking tb = tRepo.save(tripbooking);
		
		if(tb == null)
			throw new BookingNotFoundException("Booking not confirmed.");
		else
			return tb;
		
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripbooking) throws BookingNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TripBooking deleteTripBooking(Integer tripBookinkId) throws BookingNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> viewAllTripsCustomer(Integer customerId) throws BookingNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TripBooking calculateBill(Integer customerId) throws BookingNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.masai.Service;

import java.util.List;

import com.masai.Entity.TripBooking;
import com.masai.Exception.DriverNotFoundException;
import com.masai.Exception.InvalidId;

public interface TripService {
	
	public TripBooking AddTrip(TripBooking tb) throws InvalidId, DriverNotFoundException;
	public List<TripBooking> alltrip();
	public TripBooking updateTrip(TripBooking tb,Integer id)throws InvalidId;
	public String deletetrip(Integer id) throws InvalidId;
	public TripBooking tripEnd(Integer id)throws InvalidId;

}

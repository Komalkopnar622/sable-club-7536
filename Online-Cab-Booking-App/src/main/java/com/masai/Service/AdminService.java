package com.masai.Service;

import java.time.LocalDate;
import java.util.List;

import com.masai.Entity.Admin;
import com.masai.Entity.TripBooking;
import com.masai.Exception.AdminExceptions;





public interface AdminService {

	public Admin saveAdmin(Admin admin) throws AdminExceptions;
	
	public Admin update(Admin admin) throws AdminExceptions;
	
	public Admin delete(Integer id) throws AdminExceptions;
	
	public List<TripBooking> getAllTrips(Integer customerid) throws AdminExceptions;
	
	public List<TripBooking> getTripsDriverwise();
	
	public List<TripBooking> getTripsCustomerwise();
	
	public List<TripBooking> getTripsDatewise() throws AdminExceptions;
	
	public List<TripBooking> getTripsDatewiseAndCustomer(Integer customerId,LocalDate date) throws AdminExceptions;
	
	
	

}
